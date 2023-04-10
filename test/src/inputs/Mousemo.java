package inputs;

import Main.Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mousemo implements MouseMotionListener {
    private Panel panel;
    public Mousemo(Panel panel){
        this.panel =  panel;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

       }
}
