import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel centerPnl;
    JPanel bottomPnl;

    JLabel titleLbl;
    ImageIcon icon = new ImageIcon("src/photo.jpg");
    Image originalImg = icon.getImage();
    Image scaleImg = originalImg.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
    ImageIcon scaleIcon = new ImageIcon(scaleImg);

    TextArea displayTA;
    JScrollPane scrollPane;

    JButton readFortuneBtn = new  JButton("Read My Fortune!");
    JButton quitBtn = new JButton("Quit");
    String[] fortunes = {"You will have a great day!",
                         "You will have a great weekend!",
                         "You will have a great month!",
                         "You will have a great year!",
                         "You will have a great life!",
                         "You will get to fish one day!",
                         "You will have a great life!",
                         "Try harder!",
                         "You will find a stable job!",
                         "You can do it",
                         "There is nothing that you can't do",
                         "Challenge is just a chance for you to grow",
                        };

    Random rand = new Random();
    int curIdx = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = (int) dimension.getWidth() * 3/4;
        int height = (int) dimension.getHeight() * 3/4;

        createTopPanel();

        createCenterPanel();

        createBottomPanel();
        add(mainPnl);
        mainPnl.setBackground(new Color(173,216,230));
    }

    public void createTopPanel() {
         topPnl = new JPanel();
         titleLbl = new JLabel("Fortune Teller",scaleIcon,JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
         titleLbl.setHorizontalTextPosition(JLabel.CENTER);
         Font newFont = new Font("SansSerif",Font.PLAIN,36);
         titleLbl.setFont(newFont);


         topPnl.add(titleLbl);
        mainPnl.add(topPnl, BorderLayout.NORTH);
        topPnl.setBackground(new Color(173,216,230));
    }

    public void createCenterPanel() {
        centerPnl = new JPanel();
        displayTA = new TextArea(15,30);
        scrollPane = new JScrollPane(displayTA);
        displayTA.setEditable(false);
        centerPnl.add(scrollPane);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        centerPnl.setBackground(new Color(173,216,230));
    }

    public void createBottomPanel() {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        readFortuneBtn.addActionListener((ActionEvent ae) -> {
            int newIdx = -1;
            do {
                newIdx = rand.nextInt(fortunes.length);

            } while (newIdx == curIdx);

            displayTA.append(fortunes[newIdx] + "\n");
            curIdx = newIdx;
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        Font newFont = new Font("Arial",Font.BOLD,30);
        readFortuneBtn.setFont(newFont);
        quitBtn.setFont(newFont);
        readFortuneBtn.setBackground(Color.ORANGE);
        readFortuneBtn.setOpaque(true);
        readFortuneBtn.setBorderPainted(false);
        quitBtn.setBackground(Color.RED);
        quitBtn.setOpaque(true);
        quitBtn.setBorderPainted(false);
        bottomPnl.add(readFortuneBtn);
        bottomPnl.add(quitBtn);

        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        bottomPnl.setBackground(new Color(173,216,230));

    }

}
