import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel {     // יצירת מרחב ה GUI

    private final int X_Y_START=0;
        private final int WITH=800;
        private final int HIGTH=600;
    private final int  WITH_TEXT_F=300;
    private final int HIGTH_TEXT_F=50;
    private final int Y_TEXT_F=300;
    private final int WITH_BUTTON=100;
    private final int FOUNS_SIZE=40;


    private ImageIcon background;


    public BackGround(){
        this.setBounds(X_Y_START,X_Y_START,WITH,HIGTH);


        background = new ImageIcon("IMG_20220804_195733.png");
        repaint();
        this.setVisible(true);



    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.background.paintIcon(this,g,X_Y_START,X_Y_START);
        doDrawing(g);
    }


    public void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    }

}
