package com.pl.agh;

public class Tablica {
    public static int[][] Tablica(int ix, int iy) {
        int tablica[][] = new int[ix][iy];
        for (int i = 0; i < ix; i++)
            for (int j = 0; j < iy; j++)
                tablica[i][j] = 0;
        return tablica;
    }
}