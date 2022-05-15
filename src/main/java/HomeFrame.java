import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class HomeFrame extends JFrame {     // יצירת מרחב ה GUI

    private final int X_Y_START=0;
        private final int WITH=800;
    private final int TEXT_HIGTH = 15;
        private final int HIGTH=600;
        private final int  WITH_TEXT_F=300;
        private final int HIGTH_TEXT_F=50;
        private final int WITH_BUTTON=100;
        private final int HIGTH_BUTTON=50;
        private final int Y_TEXT_F=300;
    private final int FOUNS_SIZE=30;



    private JTextField textField;

    public HomeFrame(){
        this.setSize(WITH,HIGTH);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

            //  מסך הבית
        JPanel panel =new JPanel();
        panel.setBounds(X_Y_START,X_Y_START,WITH,HIGTH);
        panel.setBackground(Color.MAGENTA);
        add(panel);
        panel.setVisible(true);


             //  תיבת הטקסט להזנת חיפוש מילה
         textField = new JTextField();
        textField.setBounds(((WITH/2)-(WITH_TEXT_F/2)),Y_TEXT_F,WITH_TEXT_F,HIGTH_TEXT_F);
        Font JTextFont= new Font("",Font.BOLD,TEXT_HIGTH);
        textField.setFont(JTextFont);
        textField.setText("DELITE AND WIRT YOUR WORD HIR..");
        textField.setBackground(Color.CYAN);
        add(textField);
        textField.setVisible(true);
        textField.requestFocus();


               // עיצוב הכפתור
        JButton scherchButton = new JButton("serch");
        scherchButton .setBounds((WITH/2)-HIGTH_BUTTON,Y_TEXT_F+WITH_BUTTON,WITH_BUTTON,HIGTH_BUTTON);
        scherchButton.setBackground(Color.YELLOW);

        scherchButton.addActionListener((event -> {

            WebScrapping w=new WebScrapping(textField.getText());
        }));

        add(scherchButton);
        scherchButton.setVisible(true);
        scherchButton.requestFocus();

                  //    הוראות לתיבת הטקסט
        JLabel instruction = new JLabel("wirte the word you wont too serch: ");
        Font fontInstruction =  new Font("",Font.BOLD,FOUNS_SIZE);
        instruction.setBounds(((WITH/2)-WITH_TEXT_F-WITH_BUTTON),Y_TEXT_F-WITH_BUTTON,WITH_TEXT_F,HIGTH_TEXT_F);
        instruction.setHorizontalTextPosition(SwingConstants.CENTER);
        instruction.setFont(fontInstruction);
        panel.add(instruction);
        instruction.setVisible(true);
    }

    public String getWord() {
        return textField.getText();
    }

    public static void main(String[] args) {
        HomeFrame test=new HomeFrame();
        test.setVisible(true);
        System.out.println("finish");
    }
}
