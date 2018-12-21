import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardTrackerGUI extends JFrame {
    private JButton xButton;
    private JButton ebayButton;
    private JPanel rootPanel;
    private JLabel statusLabel;

    public CardTrackerGUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    //Initial...
        add(rootPanel);
        setSize(466,187);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ebayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Please wait while I read from the excel sheet...");
                stageTwo();
            }
        });
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(rootPanel.getWidth());
            }
        });
        setResizable(false);
    }

    public void stageTwo()
    {
        System.out.println("Called phase two");
        ExcelHandler excelHandler = new ExcelHandler(statusLabel);
    }

    public void stageThree(JLabel label, DataHandler data) {}
}