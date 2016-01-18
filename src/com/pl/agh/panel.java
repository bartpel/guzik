package com.pl.agh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel extends JPanel {

    private JButton button;
    private JButton play;
    private JButton stop;
    private JButton open;
    public static JButton poz;

    static int track=test.ix;
    static boolean starton = false;
    static boolean stoppressed=false;
    static int tempo = 90;

    public  panel()    {

        play = new StartButton();
        stop = new StopButton();

        JLabel lab = new JLabel();
        lab.setBounds(370,700,100,20);
        lab.setText("Tempo: "+panel.tempo);

        JButton up = new JButton();
        up.setBounds(450, 700, 50, 20);
        up.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                if(!panel.starton) {
                    panel.tempo++;
                    System.out.println(panel.tempo);
                    lab.setText("Tempo: "+panel.tempo);
                }
            }
        });

        JButton down = new JButton();
        down.setBounds(300, 700, 50, 20);
        down.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                if(!panel.starton) {
                    panel.tempo--;
                    System.out.println(panel.tempo);
                    lab.setText("Tempo: "+panel.tempo);
                }
            }
        });

        add(play);
        add(stop);
        add(up);
        add(down);
        add(lab);

        setLayout(null);
        setPreferredSize(new Dimension(800, 400));

        poz = new Pozycja();
        poz.setBounds(30,0,30,30);
        add(poz);

        for(int i=1;i<track+1;i++) {
            for (int j = 1; j < 33; j++) {
                button = new guzik(i, j, false);
                button.setBounds(j * 30, i * 30, 30, 30);
                add(button);
            }
            open = new OpenButton(i);
            open.setBounds(1100,i*30,80,30);
            add(open);
        }
    }
}
