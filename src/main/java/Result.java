import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    private final int X_Y_START = 0;
    private final int WITH = 1400;
    private final int HIGTH = 1000;
    private final int SPACE = 150;
    private final int TEXT_F_HIGTH = 110;
    private final int TEXT_HIGTH = 15;
    private final int DESTANCE_X_LEABEL = 300;
    private final int LEABEL_FOUNT_SIZE = 25;
    private final int TOP_WITH = 600;
    private final int TOP_HIGTH = 80;
    private TextArea textAreaMost;
    private TextArea textAreaSecond;
    private TextArea textAreaTrid;
    private TextArea textAreaFourth;
    private TextArea textAreaLast;

    public Result() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WITH, HIGTH);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  תיבת הטקסט עם תשובת החיפוש
        Font JLabelFont= new Font("",Font.BOLD,LEABEL_FOUNT_SIZE);

        JLabel top=new JLabel("YOUR FIVE MOST NEW ARTICLE RESULT : ");
        top.setBounds((WITH/2)-DESTANCE_X_LEABEL,LEABEL_FOUNT_SIZE,TOP_WITH,TOP_HIGTH);
        top.setFont(JLabelFont);
        this.add(top);
        top.requestFocus();

        Font JTextFont= new Font("",Font.BOLD,TEXT_HIGTH);

        textAreaMost=new TextArea("No-Result Yet!");
        textAreaMost.setBounds(X_Y_START,SPACE,WITH,TEXT_F_HIGTH);
        textAreaMost.setFont(JTextFont);
        textAreaMost.setBackground(Color.pink);
        this.add(textAreaMost);
        textAreaMost.requestFocus();

        textAreaSecond=new TextArea("No-Result Yet!");
        textAreaSecond.setBounds(X_Y_START,textAreaMost.getY()+SPACE,WITH,TEXT_F_HIGTH);
        textAreaSecond.setFont(JTextFont);
        textAreaSecond.setBackground(Color.pink);
        this.add(textAreaSecond);
        textAreaSecond.requestFocus();

        textAreaTrid=new TextArea("No-Result Yet!");
        textAreaTrid.setBounds(X_Y_START,textAreaSecond.getY()+SPACE,WITH,TEXT_F_HIGTH);
        textAreaTrid.setFont(JTextFont);
        textAreaTrid.setBackground(Color.pink);
        this.add(textAreaTrid);
        textAreaTrid.requestFocus();

        textAreaFourth=new TextArea("No-Result Yet!");
        textAreaFourth.setBounds(X_Y_START,textAreaTrid.getY()+SPACE,WITH,TEXT_F_HIGTH);
        textAreaFourth.setFont(JTextFont);
        textAreaFourth.setBackground(Color.pink);
        this.add(textAreaFourth);
        textAreaFourth.requestFocus();

        textAreaLast=new TextArea("No-Result Yet!");
        textAreaLast.setBounds(X_Y_START,textAreaFourth.getY()+SPACE,WITH,TEXT_F_HIGTH);
        textAreaLast.setFont(JTextFont);
        textAreaLast.setBackground(Color.pink);
        this.add(textAreaLast);
        textAreaLast.requestFocus();

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
