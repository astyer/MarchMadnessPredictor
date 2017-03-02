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

        int x = 0;
        while(x+1<south.size()){
            Teams team1;
            Teams team2;
            team1 = (Teams)south.get(x);
            team2 = (Teams)south.get(x+ 1);
            if (team1.winloss > team2.winloss){
                south.remove(x+1);
            }else /*if (team2.winloss > team1.winloss)*/{
                south.remove(x);
            }
            x++;
        }

        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }

        int z = 0;
        while(z+1<south.size()){
            Teams team1;
            Teams team2;
            team1 = (Teams)south.get(z);
            team2 = (Teams)south.get(z+ 1);
            if (team1.winloss > team2.winloss){
                south.remove(z+1);
            }else /*if (team2.winloss > team1.winloss)*/{
                south.remove(z);
            }
            z++;
        }

        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        int a = 0;
        while(a+1<south.size()){
            Teams team1;
            Teams team2;
            team1 = (Teams)south.get(a);
            team2 = (Teams)south.get(a+ 1);
            if (team1.winloss > team2.winloss){
                south.remove(a+1);
            }else /*if (team2.winloss > team1.winloss)*/{
                south.remove(a);
            }
            a++;
        }

        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");

        int b = 0;
        while(z+1<south.size()){
            Teams team1;
            Teams team2;
            team1 = (Teams)south.get(b);
            team2 = (Teams)south.get(b+ 1);
            if (team1.winloss > team2.winloss){
                south.remove(b+1);
            }else /*if (team2.winloss > team1.winloss)*/{
                south.remove(b);
            }
            b++;
        }

        for (int y = 0; y<south.size(); y++){
            Teams dummy = (Teams)south.get(y);
            System.out.println(dummy.name);
        }
        System.out.println("");
    }
}
