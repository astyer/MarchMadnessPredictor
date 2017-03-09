package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;

public class Main {

    static BufferedImage newImage;
    static JFrame mainFrame = new JFrame("Main");


    public static void main(String[] args) throws IOException{
        BufferedImage img = null;


        try {

            img = ImageIO.read(new File("newbracket.jpg"));

        } catch (IOException e) {
            System.out.println("blank");
        }
        newImage = img;

        Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(newImage, 0, 0, null);
        g2d.setPaint(Color.black);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        FontMetrics fm = g2d.getFontMetrics();
        //int x = newImage.getWidth() - fm.stringWidth(s) - 5;
        //int y = fm.getHeight();


        mainFrame.setSize(1000, 1000);
        mainFrame.getContentPane().add(new JLabel(new ImageIcon(newImage)));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        mainFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                System.out.println(x);
                System.out.println(y);
            }

        });

        Scanner sf = new Scanner(new File("2016data.txt"));

        ArrayList data = new ArrayList<String>();
        while(sf.hasNextLine())
        {
            data.add(sf.nextLine());
        }
        sf.close();

        ArrayList teams = new ArrayList();
        for(int i = 0; i < data.size(); i++)
        {
            String toSplit = (String)data.get(i);
            String [] indivdata = toSplit.split("\t");
            double wl = Double.parseDouble(indivdata[1]);
            double sos = Double.parseDouble(indivdata[2]);
            Teams a = new Teams(indivdata[0], wl, sos);
            teams.add(a);
        }

        ArrayList south = new ArrayList();
        for(int i = 0; i < 16; i++)
        {
            south.add(teams.get(i));
        }

        ArrayList west = new ArrayList();
        for(int i = 16; i < 32; i++)
        {
            west.add(teams.get(i));
        }

        ArrayList east = new ArrayList();
        for(int i = 32; i < 48; i++)
        {
            east.add(teams.get(i));
        }

        ArrayList midwest = new ArrayList();
        for(int i = 48; i < 64; i++)
        {
            midwest.add(teams.get(i));
        }

        System.out.println("March Madness Predictions:");

        int y = 0;
        int i = 0;
        while(y<south.size())
        {
            Teams dummy = (Teams) south.get(y);
            g2d.drawString(dummy.name, 100, i+35);
            i+=26;
            y++;
        }
        nextRound(south);
        System.out.println("Round of 32 South:");
        printTeams(south);
        System.out.println("");
        nextRound(south);
        System.out.println("Round of 16 South:");
        printTeams(south);
        System.out.println("");
        nextRound(south);
        System.out.println("Quarterfinals South:");
        printTeams(south);
        System.out.println("");
        nextRound(south);
        System.out.println("Semifinals South:");
        printTeams(south);
        System.out.println("");

        nextRound(west);
        System.out.println("Round of 32 West:");
        printTeams(west);
        System.out.println("");
        nextRound(west);
        System.out.println("Round of 16 West:");
        printTeams(west);
        System.out.println("");
        nextRound(west);
        System.out.println("Quarterfinals West:");
        printTeams(west);
        System.out.println("");
        nextRound(west);
        System.out.println("Semifinals West:");
        printTeams(west);
        System.out.println("");

        nextRound(east);
        System.out.println("Round of 32 East:");
        printTeams(east);
        System.out.println("");
        nextRound(east);
        System.out.println("Round of 16 East:");
        printTeams(east);
        System.out.println("");
        nextRound(east);
        System.out.println("Quarterfinals East:");
        printTeams(east);
        System.out.println("");
        nextRound(east);
        System.out.println("Semifinals East:");
        printTeams(east);
        System.out.println("");

        nextRound(midwest);
        System.out.println("Round of 32 Midwest:");
        printTeams(midwest);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Round of 16 Midwest:");
        printTeams(midwest);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Quarterfinals Midwest:");
        printTeams(midwest);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Semifinals Midwest:");
        printTeams(midwest);
        System.out.println("");

        ArrayList leftsemis = new ArrayList();
        leftsemis.add(south.get(0));
        leftsemis.add(west.get(0));
        nextRound(leftsemis);
        System.out.println("South and West finalist:");
        printTeams(leftsemis);
        System.out.println("");

        ArrayList rightsemis = new ArrayList();
        rightsemis.add(east.get(0));
        rightsemis.add(midwest.get(0));
        nextRound(rightsemis);
        System.out.println("East and Midwest finalist:");
        printTeams(rightsemis);
        System.out.println("");

        ArrayList finalists = new ArrayList();
        finalists.add(leftsemis.get(0));
        finalists.add(rightsemis.get(0));
        nextRound(finalists);
        System.out.println("Champion:");
        printTeams(finalists);
    }


    public static ArrayList nextRound(ArrayList a)
    {
        int x = 0;
        while(x+1 < a.size())
        {
            Teams team1;
            Teams team2;
            team1 = (Teams)a.get(x);
            team2 = (Teams)a.get(x+1);
            double compare1 = team1.winloss * team1.sStrength;
            double compare2 = team2.winloss * team2.sStrength;
            if (compare1 > compare2)
            {
                a.remove(x+1);
            }
            else if (compare2 > compare1)
            {
                a.remove(x);
            }
            else
            {
                Random rand = new Random();
                int r = rand.nextInt(2);
                if(r == 0)
                {
                    a.remove(x+1);
                }
                else
                {
                    a.remove(x);
                }
            }
            x++;
        }
        return a;
    }

    public static void printTeams(ArrayList a)
    {
        for(int y = 0; y < a.size(); y++) {
            Teams dummy = (Teams) a.get(y);
            System.out.println(dummy.name);
        }
    }
}

