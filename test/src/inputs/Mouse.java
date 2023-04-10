package inputs;

import Main.Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Mouse implements MouseListener  {
    private Panel panel;
    public Mouse(Panel panel){
        this.panel =  panel;

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        panel.changey(1);
        panel.changex(1);
        //panel.setrectpo(e.getX() , e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
