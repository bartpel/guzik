package com.pl.agh;

import javax.swing.*;

public class okno extends JFrame {



    public okno() {
        super( "Boom Bap Maker" );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(50,50);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(true);
        JPanel buttonpanel=new panel();
        add(buttonpanel);
    }

    }
