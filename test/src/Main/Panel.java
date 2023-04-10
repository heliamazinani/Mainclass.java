package Main;

import inputs.Keyboard;
import inputs.Mouse;
import inputs.Mousemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Panel extends JPanel {
    private Map map;
    private Button up;
    private int plyrsizex,plyrsizey,plyrsizex1,plyrsizey1;

    private int cordred =0,ydelta = 0;
    private BufferedImage img;
    private BufferedImage plyred;
    private BufferedImage plyblue;
    private BufferedImage castle;
    private BufferedImage[] background;
    private BufferedImage[] red;
    private BufferedImage[] blue;
    private int anitick,aniindex,anred,anispeed= 14;
    public Panel(){

        map = new Map();
        up = new Button();
        importimage();
        loadanimations();
        setpanelsize();
        addKeyListener(new Keyboard(this));
        addMouseListener(new Mouse(this));
        addMouseMotionListener(new Mousemo(this));
        up.setBounds(545,1431,30,30);
        this.add((up));

    }

    private void loadanimations() {
        background = new BufferedImage[20];
        red = new BufferedImage[7];
        blue = new BufferedImage[7];


        for(int i = 0; i< background.length; i++)
        background[i] = img.getSubimage(i*2224,0,2224,1668);
        for(int i = 0; i< red.length; i++)
            red[i] = plyred.getSubimage(i*1668,0,1668,2224);
       // for(int i = 0; i< background.length; i++)
            //background[i] = img.getSubimage(i*2224,0,2224,1668);
    }

    private void importimage(){
        InputStream is = getClass().getResourceAsStream("/backg.png");
        InputStream ris = getClass().getResourceAsStream("/redsprite.png");
        InputStream cas = getClass().getResourceAsStream("/castle.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            plyred = ImageIO.read(ris);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                ris.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            castle = ImageIO.read(cas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                cas.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void setpanelsize(){
        Dimension size = new Dimension(1112,843);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }
    public void changex(int value){
        this.cordred += value;

    }
    public void changey(int value){
        this.ydelta += value;

    }
    public void setrectpo(int x,int y){
        this.cordred = x;
        this.ydelta = y;

    }
   private void Plyrsize(){
        switch (map.cords[cordred][0]){
            case (720):
            case (680):
                plyrsizex = 52;
                plyrsizey = 70;
                plyrsizex1 = 26;
                plyrsizey1 = 35;
                break;
            case (639):
            case (607):
                plyrsizex = 51;
                plyrsizey = 69;
                plyrsizex1 = 25;
                plyrsizey1 = 35;
                break;
            case (575):
            case (546):
                plyrsizex = 50;
                plyrsizey = 68;
                plyrsizex1 = 25;
                plyrsizey1 = 35;
                break;
            case (519):
            case (494):
                plyrsizex = 49;
                plyrsizey = 67;
                plyrsizex1 = 24;
                plyrsizey1 = 35;
                break;
             case (471):
             case (448):
               plyrsizex = 48;
               plyrsizey = 66;
                 plyrsizex1 = 24;
                 plyrsizey1 = 37;
               break;}
    }


    private void updateanimationtick() {
        anitick++;
        if(anitick >= anispeed) {
            anitick = 0;
            aniindex++;
            anred++;
            if(aniindex >= background.length)
                aniindex = 0;
            if(anred >= red.length)
                anred = 0;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateanimationtick();
        Plyrsize();
       g.drawImage(background[aniindex],0,0,1112,843,null);

        g.drawImage(castle,0,0,1112,843,null);
        g.drawImage(red[anred] ,map.cords[cordred][1] - plyrsizex1,map.cords[cordred][0] - plyrsizey1,plyrsizex,plyrsizey,null);
        //ag.drawImage(red[anred] ,483 - 26,639 - 35,52,70,null);

    }


}
