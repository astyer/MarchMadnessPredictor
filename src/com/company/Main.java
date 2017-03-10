package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
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

        mainFrame.setSize(1000, 1000);
        mainFrame.getContentPane().add(new JLabel(new ImageIcon(newImage)));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

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

        drawTeams(south, g2d, 100, 35, 26);
        nextRound(south);
        System.out.println("Round of 32 South:");
        printTeams(south);
        drawTeams(south, g2d, 295, 50, 52);
        System.out.println("");
        nextRound(south);
        System.out.println("Round of 16 South:");
        printTeams(south);
        drawTeams(south, g2d, 440, 75, 105);
        System.out.println("");
        nextRound(south);
        System.out.println("Quarterfinals South:");
        printTeams(south);
        drawTeams(south, g2d, 560, 127, 210);
        System.out.println("");
        nextRound(south);
        System.out.println("Semifinals South:");
        printTeams(south);
        drawTeams(south, g2d, 675, 233, 0);
        System.out.println("");

        drawTeams(west, g2d, 100, 460, 26);
        nextRound(west);
        System.out.println("Round of 32 West:");
        printTeams(west);
        drawTeams(west, g2d, 295, 475, 52);
        System.out.println("");
        nextRound(west);
        System.out.println("Round of 16 West:");
        printTeams(west);
        drawTeams(west, g2d, 440, 500, 105);
        System.out.println("");
        nextRound(west);
        System.out.println("Quarterfinals West:");
        printTeams(west);
        drawTeams(west, g2d, 560, 552, 210);
        System.out.println("");
        nextRound(west);
        System.out.println("Semifinals West:");
        printTeams(west);
        drawTeams(west, g2d, 675, 658, 0);
        System.out.println("");

        drawTeams(east, g2d, 1630, 35, 26);
        nextRound(east);
        System.out.println("Round of 32 East:");
        printTeams(east);
        drawTeams(east, g2d, 1440, 50, 52);
        System.out.println("");
        nextRound(east);
        System.out.println("Round of 16 East:");
        printTeams(east);
        drawTeams(east, g2d, 1320, 75, 105);
        System.out.println("");
        nextRound(east);
        System.out.println("Quarterfinals East:");
        printTeams(east);
        drawTeams(east, g2d, 1205, 127, 210);
        System.out.println("");
        nextRound(east);
        System.out.println("Semifinals East:");
        printTeams(east);
        drawTeams(east, g2d, 1090, 233, 0);
        System.out.println("");

        drawTeams(midwest, g2d, 1630, 460, 26);
        nextRound(midwest);
        System.out.println("Round of 32 Midwest:");
        printTeams(midwest);
        drawTeams(midwest, g2d, 1440, 475, 52);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Round of 16 Midwest:");
        printTeams(midwest);
        drawTeams(midwest, g2d, 1320, 500, 105);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Quarterfinals Midwest:");
        printTeams(midwest);
        drawTeams(midwest, g2d, 1205, 552, 210);
        System.out.println("");
        nextRound(midwest);
        System.out.println("Semifinals Midwest:");
        printTeams(midwest);
        drawTeams(midwest, g2d, 1090, 658, 0);
        System.out.println("");

        ArrayList leftsemis = new ArrayList();
        leftsemis.add(south.get(0));
        leftsemis.add(west.get(0));
        nextRound(leftsemis);
        System.out.println("South and West finalist:");
        printTeams(leftsemis);
        drawTeams(leftsemis, g2d, 686, 455, 0);
        System.out.println("");

        ArrayList rightsemis = new ArrayList();
        rightsemis.add(east.get(0));
        rightsemis.add(midwest.get(0));
        nextRound(rightsemis);
        System.out.println("East and Midwest finalist:");
        printTeams(rightsemis);
        drawTeams(rightsemis, g2d, 1052, 455, 0);
        System.out.println("");

        ArrayList finalists = new ArrayList();
        finalists.add(leftsemis.get(0));
        finalists.add(rightsemis.get(0));
        nextRound(finalists);
        System.out.println("Champion:");
        drawTeams(finalists, g2d, 857, 455, 0);
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

    public static void drawTeams(ArrayList a, Graphics2D g, int x, int starty, int incy)
    {
        int y = 0;
        int i = 0;
        while(y<a.size())
        {
            Teams dummy = (Teams) a.get(y);
            g.drawString(dummy.name, x, i+starty);
            i+=incy;
            y++;
        }
    }
}

