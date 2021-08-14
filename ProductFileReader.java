import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProductFileReader{
    BufferedReader bufferedReader;
    private String file;
    String pid,productName,brand,productUrl,discountedPrice;
    float retailPrice;
    float productRating;
    ProductsData []productsList;
    public  ProductFileReader(String file) throws FileNotFoundException{
         this.file=file;
         toReadFile();
    }

    public void toReadFile() throws FileNotFoundException{
       bufferedReader=new BufferedReader(new FileReader(file));
    }

    public int countValue() throws IOException { 
        bufferedReader.readLine();
        int count =0;
        while(bufferedReader.readLine()!=null){
            count++;
        }
        return count;
    }

    public String header() throws IOException{
        toReadFile();
        String header = bufferedReader.readLine();
        return header;
    }

    public ProductsData addDetailsToProduct(String record) throws IOException{
        String[] fields = record.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        ProductsData product = new ProductsData();
        product.setPid(fields[0]);
        product.setProductName(fields[1]);
        if(fields[2].equals("")){
            brand="Null";
            product.setBrand("Null");
        }else{
            product.setBrand(fields[2]);
        }
        product.setProductUrl(fields[3]);
        product.setRetailPrice(floatConverter(fields[4]));
        product.setDiscountedPrice(floatConverter(fields[5]));
        if(fields[6].equals("No rating available"))
        {
            product.setProductRating(0);
        }else{
            product.setProductRating(floatConverter(fields[6]));
        }
        return product;
    }


    public ProductsData[] getProducts() throws IOException{
       
        int count = countValue();
        toReadFile(); // reinitalise buffered reader to move cursor to start point of file
        String header = bufferedReader.readLine();
        String record;
        ProductsData[] productList = new ProductsData[count];
        int index=0;
        while((record = bufferedReader.readLine())!= null){
            ProductsData products = addDetailsToProduct(record);
            productList[index++] = products;
        }
        return productList;
    }

    public float floatConverter(String value){
        try{
            return Float.parseFloat(value);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            return 0.0f;
        }
    }


}
 