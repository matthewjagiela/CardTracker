import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardTrackerGUI extends JFrame {

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
        setResizable(false);
    }

    public void stageTwo()
    {
        System.out.println("Called phase two");
        ExcelHandler excelHandler = new ExcelHandler(statusLabel);
    }

    public void stageThree(JLabel label, DataHandler data) {
        label.setText("Creating Links... Please wait...");
        new LinkHandler(data,label); //This is going to make links based of the data we already have
    }
    public void stageFour(JLabel label, ArrayList<String> links){
        label.setText("TEST");
        WebHandler webHandler = new WebHandler(label,links);

    }

}