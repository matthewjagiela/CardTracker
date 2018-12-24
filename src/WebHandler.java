import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class WebHandler {
    ArrayList<String>links = new ArrayList<String>();
    JLabel label;
    public WebHandler(JLabel label, ArrayList<String> links){
        this.links = links;
        this.label = label;
        searchEbay();

    }
    private void searchEbay(){
        System.out.println("Searching ebay");
        Double[] priceArray = new Double[links.size()];
        for (int i = 0; i < links.size(); i++) {
            Double total = Double.valueOf(0.0D);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            Document document = null;
            try {
                document = Jsoup.connect(links.get(i)).get();
                System.out.println(document);
                Elements price = document.select(".positive.contains($)");
                for (int d = 0; d < price.size(); d++){
                    String numericPriceOne = price.get(d).text().replaceAll(",","");
                    String numericPriceTwo = numericPriceOne.substring(1);
                    Double actualNumericPrice = Double.valueOf(numericPriceTwo);
                    total = Double.valueOf(total.doubleValue() + actualNumericPrice.doubleValue());

                }
                total = Double.valueOf(total.doubleValue() / price.size()); //The average of all the cards...
                priceArray[i] = total; //Hold the price array
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("AN ERROR SEARCHING + " +  e.getLocalizedMessage());
            }


        }
        collectionWorth(priceArray);
    }

    private void collectionWorth(Double[] prices){
        Double collectionWorth = Double.valueOf(0.0D);
        for (int i = 0; i < prices.length ; i++) {
            if (!prices[i].isNaN()) {
                collectionWorth = Double.valueOf(collectionWorth.doubleValue() + prices[i].doubleValue());
            }
        }
        label.setText("The total value of your collection is: " + collectionWorth);
    }
}
