package com.company;
//http://www.ncaa.com/interactive-bracket/basketball-men/d1
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sf = new Scanner(new File("2016seeds.txt"));

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
            String [] namesandwl = toSplit.split("\t");
            double wl = Double.parseDouble(namesandwl[1]);
            Teams a = new Teams(namesandwl[0], wl);
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

        nextRound(south);
        System.out.println("Round of 32 South:");
        printTeams(south);
        System.out.println("");
        nextRound(south);
        System.out.println("Round of 16 South:");
        printTeams(south);
        System.out.println("");
        nextRound(south);
        System.out.println("Quartefinals South:");
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
        System.out.println("Quartefinals West:");
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
        System.out.println("Quartefinals East:");
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
        System.out.println("Quartefinals Midwest:");
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
            if (team1.winloss > team2.winloss)
            {
                a.remove(x+1);
            }
            else if (team2.winloss > team1.winloss)
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
        for(int y = 0; y < a.size(); y++)
        {
            Teams dummy = (Teams)a.get(y);
            System.out.println(dummy.name);
        }
    }
}
