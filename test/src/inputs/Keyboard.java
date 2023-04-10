package inputs;

import Main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    private Panel panel;

    public Keyboard(Panel panel){
        this.panel = panel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }



    @Override
    public void keyReleased(KeyEvent e) {
     switch(e.getKeyCode()){
         case KeyEvent.VK_W:
             panel.changex(10);
             break;
         case KeyEvent.VK_A:
             panel.changex(-1);
             break;
         case KeyEvent.VK_S:
             panel.changex(-10);
             break;
         case KeyEvent.VK_D:
             panel.changex(1);
             break;
    }}
}
