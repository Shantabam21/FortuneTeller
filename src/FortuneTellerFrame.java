import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel centerPnl;
    JPanel bottomPnl;

    JLabel titleLbl;
    ImageIcon icon = new ImageIcon("src/photo.jpg");
    Image originalImg = icon.getImage();
    Image scaleImg = originalImg.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
    ImageIcon scaleIcon = new ImageIcon(scaleImg);


    JButton quitBtn = new JButton("Quit");

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());


        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        add(mainPnl);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void createTopPanel() {
         topPnl = new JPanel();
         titleLbl = new JLabel("Fortune Teller",scaleIcon,JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
         titleLbl.setHorizontalTextPosition(JLabel.CENTER);
         Font newFont = new Font("SansSerif",Font.PLAIN,36);
         titleLbl.setFont(newFont);


         topPnl.add(titleLbl);
    }

}
