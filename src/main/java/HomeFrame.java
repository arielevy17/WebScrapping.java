import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    private final int X_Y_START = 0;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int TEXT_HEIGHT = 15;
    private final int WIDTH_TEXT_F = 300;
    private final int HEIGHT_TEXT_F = 50;
    private final int WIDTH_BUTTON = 100;
    private final int HEIGHT_BUTTON = 50;
    private final int Y_TEXT_F = 300;
    private final int FONT_SIZE = 30;
    private final int X_PAGE_TITLE = 200;
    private final int Y_PAGE_TITLE = 20;
    private final int PAGE_TITLE_HEIGHT = 40;
    private JTextField textField;

    public HomeFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // יצירת לוח עם תמונת רקע
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // טעינת תמונת הרקע
                ImageIcon icon = new ImageIcon("C:\\Users\\ariel\\Documents\\WebScrapping.java\\src\\main\\java\\G.N.png.jpg");
                Image image = icon.getImage();
                // ציור התמונה על הלוח
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null); // הגדרת פריסה ידנית
        setContentPane(backgroundPanel); // הגדרת ה-backgroundPanel כלוח התוכן של החלון

        // תיבת הטקסט להזנת חיפוש מילה
        textField = new JTextField();
        textField.setBounds(((WIDTH / 2) - (WIDTH_TEXT_F / 2)), Y_TEXT_F, WIDTH_TEXT_F, HEIGHT_TEXT_F);
        Font JTextFont = new Font("", Font.BOLD, TEXT_HEIGHT);
        textField.setFont(JTextFont);
        textField.setText("Write here the word you want to search..");
        textField.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(textField);

        // עיצוב הכפתור
        JButton searchButton = new JButton("search");
        searchButton.setBounds((WIDTH / 2) - HEIGHT_BUTTON, Y_TEXT_F + WIDTH_BUTTON, WIDTH_BUTTON, HEIGHT_BUTTON);
        searchButton.setBackground(Color.LIGHT_GRAY);

        searchButton.addActionListener((event -> {
            WebScrapping w = new WebScrapping(textField.getText());
        }));

        backgroundPanel.add(searchButton);

        // הוראות לתיבת הטקסט
        JLabel instruction = new JLabel("Welcome to the G.N search engine ");
        Font fontInstruction = new Font("", Font.BOLD, FONT_SIZE);
        instruction.setFont(fontInstruction);
        instruction.setForeground(Color.WHITE);
        instruction.setBounds(X_PAGE_TITLE, Y_PAGE_TITLE, WIDTH, PAGE_TITLE_HEIGHT);
        instruction.setFont(fontInstruction);
        backgroundPanel.add(instruction);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // הצגת החלון
    }

    public String getWord() {
        return textField.getText();
    }

    public static void main(String[] args) {
        HomeFrame test = new HomeFrame();
        test.setVisible(true);
    }
}
