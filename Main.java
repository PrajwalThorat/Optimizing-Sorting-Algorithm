import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[]args){
        try {
            ProductSorting sort=new ProductSorting("./data/flipkart_product_sample.csv");
            sort.analyze();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
