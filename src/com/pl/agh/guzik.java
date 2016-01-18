package com.pl.agh;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.FileInputStream;


class Pozycja extends JButton {
    public Pozycja()
    {
        setBackground(Color.BLACK);

    }
}

class OpenButton extends JButton implements ActionListener {

    private int wiersz;

    OpenButton(int wiersz)
    {
        super("Otwórz");
        addActionListener(this);
        this.wiersz=wiersz;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(OpenButton.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();                        ;
                //This is where a real application would open the file.
                System.out.println("Opening: " + file.getName() + ".");
                String path = file.getPath();

                System.out.println(path);
                copy(path);

            } else {
                System.out.println("Open command cancelled by user.");
            }


    }

    public void copy(String p){

        try{
            FileInputStream from = new FileInputStream(p);
            FileOutputStream to = new FileOutputStream(wiersz+".wav");
            byte [] buffer = new byte[4096];
            int byteRead;
            while((byteRead=from.read(buffer))!=-1)
            {
                to.write(buffer,0,byteRead);
            }
            from.close();
            to.close();
        }
        catch (Exception ee)
        {}
    }

}

class StartButton extends JButton implements ActionListener {
    StartButton()
    {
        super("Start");
        addActionListener(this);
        setBounds(30,700,100,100);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(panel.starton==false) {
            panel.starton=true;
            panel.stoppressed=false;
            System.out.println("Yoo");
            java.util.Timer timer = new java.util.Timer();
            Sekwencja sekwencja = new Sekwencja();
            timer.scheduleAtFixedRate(sekwencja,0,15000/panel.tempo);
        }
        else
        {
            System.out.println("Błąd");
        }
    }
}

class StopButton extends JButton implements ActionListener {
    StopButton()
    {
        super("Stop");
        addActionListener(this);
        setBounds(130,700,100,100);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(panel.stoppressed==false) {
            panel.stoppressed = true;
            panel.starton = false;
        }
        else
        {
            panel.starton = false;
        }
    }
}


public class guzik extends JButton implements ActionListener {
    private int wiersz;
    private int kolumna;
    private boolean stan;
    private String sound;

    public guzik(int wiersz,int kolumna, boolean stan)    {
        this.wiersz=wiersz;
        this.kolumna=kolumna;
        this.stan=stan;
        addActionListener(this);
        setBackground(Color.RED);

        this.sound=String.valueOf(wiersz)+".wav";
        System.out.println(this.sound);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.stan == false) {
            setBackground(Color.GREEN);
            this.stan = true;
            System.out.println(this.wiersz);
            System.out.println(this.kolumna);
            test.tablica[this.wiersz-1][this.kolumna-1]=1;

        }
        else {
            setBackground(Color.RED);
            this.stan = false;
            test.tablica[this.wiersz-1][this.kolumna-1]=0;
        }
    }

}
