import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataHandler {
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();
    ArrayList<String> year = new ArrayList<String>();
    ArrayList<String> brand = new ArrayList<String>();
    ArrayList<String> product = new ArrayList<String>();
    ArrayList<String> cardType = new ArrayList<String>();
    ArrayList<String> extraAttributes = new ArrayList<String>(); //If there is nothing inside of the cell a blank will be added here...
    ArrayList<String> cardNumber = new ArrayList<String>();
    ArrayList<String> graded = new ArrayList<String>();

    public void addToQuantity(int quantity){
        this.quantity.add(quantity);
    }
    public void addToFirstName(String firstName){
        this.firstName.add(firstName);
    }
    public void addToLastName(String lastName){
        this.lastName.add(lastName);
    }
    public void addToYear(String year){
        this.year.add(year);
    }
    public void addToBrand(String brand){
        this.brand.add(brand);
    }
    public void addToProduct(String product){
        this.product.add(product);
    }
    public void addToCardType(String cardType){
        this.cardType.add(cardType);
    }
    public void addExtraAttributes(String attributes){
        extraAttributes.add(attributes);
    }
    public void addToCardNumber(String cardNumber){
        this.cardNumber.add(cardNumber);
    }
    public void addGraded(String graded){
        this.graded.add(graded);
    }

}
