package Main;

public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread thread;
    private final int FPS_SET = 126;
    public Game(){
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
        startgameloop();



    }
    private void startgameloop(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timeperframe = 1000000000 / FPS_SET;
        long lastfram = System.nanoTime();
        int frames =0;
        long lastCheck = System.currentTimeMillis();
        long now = System.nanoTime();
        while(true){
            now = System.nanoTime();
            if(now - lastfram >= timeperframe){
                panel.repaint();
                lastfram = now;
                frames++;
            }
            frames++;
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println(frames);
                frames =0;
            }

        }
    }
}
