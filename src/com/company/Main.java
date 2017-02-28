package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sf = new Scanner(new File("2016seeds.txt"));

        int maxIndex = -1;
        String data [] = new String [1000];
        while(sf.hasNextLine())
        {
            maxIndex++;
            data[maxIndex] = sf.nextLine();
        }
        sf.close();

        for(int i = 0; i < data.length; i++)
        {
            String toSplit = data[i];
            String
        }
    }
}
