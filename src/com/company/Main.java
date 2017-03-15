// providence/USC
// N.C. Central/UC Davis
// upload github link to classroom

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

        Scanner sf = new Scanner(new File("2017data.txt"));

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

        ArrayList W = new ArrayList();
        for(int i = 0; i < 16; i++)
        {
            W.add(teams.get(i));
        }

        ArrayList X = new ArrayList();
        for(int i = 16; i < 32; i++)
        {
            X.add(teams.get(i));
        }

        ArrayList Y = new ArrayList();
        for(int i = 32; i < 48; i++)
        {
            Y.add(teams.get(i));
        }

        ArrayList Z = new ArrayList();
        for(int i = 48; i < 64; i++)
        {
            Z.add(teams.get(i));
        }

        System.out.println("March Madness Predictions:");

        drawTeams(W, g2d, 100, 35, 26);
        nextRound(W);
        System.out.println("Round of 32 W:");
        printTeams(W);
        drawTeams(W, g2d, 295, 50, 52);
        System.out.println("");
        nextRound(W);
        System.out.println("Round of 16 W:");
        printTeams(W);
        drawTeams(W, g2d, 440, 75, 105);
        System.out.println("");
        nextRound(W);
        System.out.println("Quarterfinals W:");
        printTeams(W);
        drawTeams(W, g2d, 560, 127, 210);
        System.out.println("");
        nextRound(W);
        System.out.println("Semifinals W:");
        printTeams(W);
        drawTeams(W, g2d, 675, 233, 0);
        System.out.println("");

        drawTeams(X, g2d, 100, 460, 26);
        nextRound(X);
        System.out.println("Round of 32 X:");
        printTeams(X);
        drawTeams(X, g2d, 295, 475, 52);
        System.out.println("");
        nextRound(X);
        System.out.println("Round of 16 X:");
        printTeams(X);
        drawTeams(X, g2d, 440, 500, 105);
        System.out.println("");
        nextRound(X);
        System.out.println("Quarterfinals X:");
        printTeams(X);
        drawTeams(X, g2d, 560, 552, 210);
        System.out.println("");
        nextRound(X);
        System.out.println("Semifinals X:");
        printTeams(X);
        drawTeams(X, g2d, 675, 658, 0);
        System.out.println("");

        drawTeams(Y, g2d, 1630, 35, 26);
        nextRound(Y);
        System.out.println("Round of 32 Y:");
        printTeams(Y);
        drawTeams(Y, g2d, 1444, 50, 52);
        System.out.println("");
        nextRound(Y);
        System.out.println("Round of 16 Y:");
        printTeams(Y);
        drawTeams(Y, g2d, 1323, 75, 105);
        System.out.println("");
        nextRound(Y);
        System.out.println("Quarterfinals Y:");
        printTeams(Y);
        drawTeams(Y, g2d, 1205, 127, 210);
        System.out.println("");
        nextRound(Y);
        System.out.println("Semifinals Y:");
        printTeams(Y);
        drawTeams(Y, g2d, 1090, 233, 0);
        System.out.println("");

        drawTeams(Z, g2d, 1630, 460, 26);
        nextRound(Z);
        System.out.println("Round of 32 Z:");
        printTeams(Z);
        drawTeams(Z, g2d, 1444, 475, 52);
        System.out.println("");
        nextRound(Z);
        System.out.println("Round of 16 Z:");
        printTeams(Z);
        drawTeams(Z, g2d, 1323, 500, 105);
        System.out.println("");
        nextRound(Z);
        System.out.println("Quarterfinals Z:");
        printTeams(Z);
        drawTeams(Z, g2d, 1205, 552, 210);
        System.out.println("");
        nextRound(Z);
        System.out.println("Semifinals Z:");
        printTeams(Z);
        drawTeams(Z, g2d, 1090, 658, 0);
        System.out.println("");

        ArrayList leftsemis = new ArrayList();
        leftsemis.add(W.get(0));
        leftsemis.add(X.get(0));
        nextRound(leftsemis);
        System.out.println("W and X finalist:");
        printTeams(leftsemis);
        drawTeams(leftsemis, g2d, 686, 455, 0);
        System.out.println("");

        ArrayList rightsemis = new ArrayList();
        rightsemis.add(Y.get(0));
        rightsemis.add(Z.get(0));
        nextRound(rightsemis);
        System.out.println("Y and Z finalist:");
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

