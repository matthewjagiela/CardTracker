import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        System.out.println("Hello World");
        //This is going to show the first step of the application...
        CardTrackerGUI cardTrackerGUI = new CardTrackerGUI();
        cardTrackerGUI.setVisible(true);

    }
}
