package com.company;

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
        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(south);

        System.out.println("Round of 16 South:");
        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(south);

        System.out.println("Quartefinals South:");
        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(south);

        System.out.println("Semifinals South:");
        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(west);
        System.out.println("Round of 32 West:");
        for (int y = 0; y<west.size(); y++){
            Teams dummy = (Teams)west.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(west);

        System.out.println("Round of 16 West:");
        for (int y = 0; y<west.size(); y++){
            Teams dummy = (Teams)west.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(west);

        System.out.println("Quartefinals West:");
        for (int y = 0; y<west.size(); y++){
            Teams dummy = (Teams)west.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        nextRound(west);

        System.out.println("Semifinals West:");
        for (int y = 0; y<west.size(); y++){
            Teams dummy = (Teams)west.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");
    }

    public static ArrayList nextRound(ArrayList a)
    {
        int x = 0;
        while(x+1<a.size()){
            Teams team1;
            Teams team2;
            team1 = (Teams)a.get(x);
            team2 = (Teams)a.get(x+ 1);
            if (team1.winloss > team2.winloss){
                a.remove(x+1);
            }else /*if (team2.winloss > team1.winloss)*/{
                a.remove(x);
            }
            x++;
        }
        return a;
    }
}
