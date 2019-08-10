package apilet;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.text.*;

public class atislar extends Applet implements KeyListener, Runnable {

    double x, y, a, b;
    int m, n, k, l;
    double teta = Math.PI / 2;
    Color c;
    int puan;
    Random r = new Random();
    int ran = 150 + r.nextInt(50);

    public void init() {
        setSize(700, 700);
        setBackground(Color.BLACK);
        addKeyListener(this);

        x = 200;
        y = 200;
        k = 70;
        l = 70;
        a = x;
        b = y;

        puan = 0;
       
        ran = 150 + r.nextInt(50);

        n = 300 - (int) (ran * Math.sin(Math.random() * 2 * Math.PI));
        m = 200 + (int) (ran * Math.cos(Math.random() * 2 * Math.PI));
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawString(puan + " puan", 20, 20);
        g.setColor(Color.black);
       
        
        g.setColor(Color.green);
        g.fillOval(100, 200, 200, 200);
        g.setColor(Color.yellow);
        g.drawLine(200, 300, (int) x, (int) y);
        g.fillOval((int) a - 5, (int) b - 5, 10, 10);
        g.fillOval(m, n, 10, 10);

        g.setColor(c);

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int ch = ke.getKeyChar();
        if (ch == 'd') {

            teta = teta - Math.PI / 80;
            y = 300 - 100 * Math.sin(teta);
            x = 200 + 100 * Math.cos(teta);
            a = x;
            b = y;
        } else if (ch == 'a') {
            teta = teta + Math.PI / 80;
            y = 300 - 100 * Math.sin(teta);
            x = 200 + 100 * Math.cos(teta);
            a = x;
            b = y;
        } else if (ch == 's') {
            b = 300 - 300 * Math.sin(teta);
            a = 200 + 300 * Math.cos(teta);
            new Thread(this).start();
        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void run() {
        int r = 100;
        ran = 150 + this.r.nextInt(50);
        while (r != 1000) {

            b = 300 - r * Math.sin(teta);
            a = 200 + r * Math.cos(teta);
            r = r + 5;

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            double mesafe = Math.sqrt((m  - (a-5)) * (m  - (a-5)) + (n  - (b-5)) * (n  - (b-5)));
            if (mesafe<5) {
              
                puan += 5;

                n = 300 - (int) (ran * Math.sin(Math.random() * 2 * Math.PI));
                m = 200 + (int) (ran * Math.cos(Math.random() * 2 * Math.PI));
        

                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                }
                break;

            }
               if (a > getWidth() || b > getHeight() || a < 0 || b < 0){
                   break;
               }

            repaint();
        }
        n = 300 - (int) (ran * Math.sin(Math.random() * 2 * Math.PI));
        m = 200 + (int) (ran * Math.cos(Math.random() * 2 * Math.PI));
        repaint();

    }

}
