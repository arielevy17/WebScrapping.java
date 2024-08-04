import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    private final int X_START = 50;
    private final int WITH = 1400;
    private final int HIGTH = 1000;
    private final int X_PAGE_TITLE = 200;
    private final int WIDTH = 800;
    private final int SPACE = 35;
    private final int TEXT_HIGTH = 15;
    private final int LEABEL_FOUNT_SIZE = 30;
    private final int WITH_LABEL_SIZE = WITH/5;
    private TextArea textAreaMost;
    private TextArea textAreaSecond;
    private TextArea textAreaTrid;
    private TextArea textAreaFourth;
    private TextArea textAreaLast;

    public Result() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WITH, HIGTH);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Font JTextFont= new Font("",Font.BOLD,TEXT_HIGTH);
        textAreaMost=new TextArea("No Result Yet..");
        textAreaMost.setBounds(X_START, SPACE ,WITH_LABEL_SIZE,HIGTH-SPACE);
        textAreaMost.setFont(JTextFont);
        textAreaMost.setBackground(Color.gray);
        this.add(textAreaMost);
        textAreaMost.requestFocus();

        textAreaSecond=new TextArea("No Result Yet..");
        textAreaSecond.setBounds(textAreaMost.getX() + WITH_LABEL_SIZE +SPACE , textAreaMost.getY(), WITH_LABEL_SIZE,HIGTH-SPACE);
        textAreaSecond.setFont(JTextFont);
        textAreaSecond.setBackground(Color.gray);
        this.add(textAreaSecond);
        textAreaSecond.requestFocus();

        textAreaTrid=new TextArea("No Result Yet..");
        textAreaTrid.setBounds(textAreaSecond.getX()+ WITH_LABEL_SIZE +SPACE , textAreaMost.getY() ,WITH_LABEL_SIZE ,HIGTH-SPACE);
        textAreaTrid.setFont(JTextFont);
        textAreaTrid.setBackground(Color.gray);
        this.add(textAreaTrid);
        textAreaTrid.requestFocus();

        textAreaFourth=new TextArea("No Result Yet..");
        textAreaFourth.setBounds(textAreaTrid.getX()+ WITH_LABEL_SIZE +SPACE, textAreaMost.getY() ,WITH_LABEL_SIZE,HIGTH-SPACE);
        textAreaFourth.setFont(JTextFont);
        textAreaFourth.setBackground(Color.gray);
        this.add(textAreaFourth);
        textAreaFourth.requestFocus();
        this.setVisible(true);

    }


    public void setTextAreaMost(String textAreaMost) {
        this.textAreaMost.setText(textAreaMost);
    }


    public void setTextAreaSecond(String textAreaSecond) {
        this.textAreaSecond.setText(textAreaSecond);
    }

    public void setTextAreaTrid(String textAreaTrid) {
        this.textAreaTrid.setText(textAreaTrid);
    }

    public void setTextAreaFourth(String textAreaFourth) {
        this.textAreaFourth.setText(textAreaFourth);
    }

    public void setTextAreaLast(String textAreaLast) {
        this.textAreaLast.setText(textAreaLast);
    }

}
