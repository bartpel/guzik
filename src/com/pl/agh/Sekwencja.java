package com.pl.agh;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;


public class Sekwencja extends TimerTask {

    int i = 0;

    public void run() {

        if (panel.stoppressed) {
            cancel();
            i=0;
            panel.stoppressed=false;
        }
        else {
            if (i ==31) {
                panel.poz.setBounds((i+1)*30,0,30,30);
                for(int x=0;x<panel.track;x++)
                {
                    if (test.tablica[x][i]==1) {
                        String sound = String.valueOf(x+1) + ".wav";
                        music(sound);
                    }
                }
                i = 0;
            } else {
                if(i>0)
                {
                    panel.poz.setBounds((i+1)*30,0,30,30);}
                else
                {
                    panel.poz.setBounds((i+1)*30,0,30,30);}

               for(int x=0;x<panel.track;x++)
                {
                    if (test.tablica[x][i]==1) {
                        String sound = String.valueOf(x+1) + ".wav";
                        music(sound);
                    }
                }

                i++;
            }
        }
    }

    public static void music(String dzwiek) {

        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream play = null;

        try
        {
            InputStream test = new FileInputStream(dzwiek);
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
    }
}
