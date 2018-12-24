import javax.swing.*;
import java.util.ArrayList;

public class LinkHandler { //All this class does is make all the links we need to visit and sort through
    ArrayList<String> links = new ArrayList<String>();
    final String linkBase = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=";
    public LinkHandler(DataHandler data, JLabel label){
        System.out.println("Link stage of the program... AKA Stage 3... ");
        for (int i = 0; i < data.firstName.size(); i++) { //For each excel entry...
            String preSpaceLink = linkBase + data.firstName.get(i) + "+" + data.lastName.get(i) + "+" + data.year.get(i) + "+" + data.brand.get(i) + "+" + data.product.get(i) + "+" + data.cardType.get(i) + "+" + data.cardNumber.get(i) + "bgs+-PSA+-SGC+&_sacat=0&LH_Sold=1&LH_Complete=1&rt=nc&LH_All=1";
            String officialLink = preSpaceLink.replace(" ","+");
            links.add(officialLink);
        }
        CardTrackerGUI cardTrackerGUI = null;
        try {
            cardTrackerGUI = new CardTrackerGUI();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        cardTrackerGUI.stageFour(label,links); //Send back the label and the links to use...

    }
}
