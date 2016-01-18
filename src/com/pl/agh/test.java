package com.pl.agh;

import java.awt.*;

public class test {

    static int ix = 16; // I wymiar
    static int iy = 32; // II wymiar
    static int tablica[][]=Tablica.Tablica(ix,iy);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new okno();
                new Tablica();

                for(int i = 0; i < ix; i++) {
                    for (int j = 0; j < iy; j++)
                        System.out.println(tablica[i][j]);
                    System.out.println("Next");
                }
            }
        });
    }

}
