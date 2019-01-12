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
        System.out.println("Web Handler...");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                searchEbay();
            }
        });
        t.start();

    }
    private void searchEbay(){
        System.out.println("Searching ebay");
        label.setText("Still searching...");
        Double[] priceArray = new Double[links.size()];
        for (int i = 0; i < links.size(); i++) {
            Double total = Double.valueOf(0.0D);
            Document document = null;
            try {
                document = Jsoup.connect(links.get(i)).get();
                Elements price = document.select(".positive:contains($)");
                for (int d = 0; d < price.size(); d++) {
                    String numericPriceOne = price.get(d).text().replaceAll(",", "");
                    String numericPriceTwo = numericPriceOne.substring(1);
                    Double actualNumericPrice = Double.valueOf(numericPriceTwo);
                    total = Double.valueOf(total.doubleValue() + actualNumericPrice.doubleValue());

                }
                total = Double.valueOf(total.doubleValue() / price.size()); //The average of all the cards...
                priceArray[i] = total; //Hold the price array
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("AN ERROR SEARCHING + " + e.getLocalizedMessage());
            }

            label.setText("Price " + i + " of " + links.size() + " found...");
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
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        label.setText("The total value of your collection is: " + numberFormat.format(collectionWorth));
    }
}
