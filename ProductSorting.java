import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;

public class ProductSorting {
    private ProductFileReader details;
    BufferedWriter bufferedwriter;
    public ProductSorting(String file) throws FileNotFoundException{
        details=new ProductFileReader(file);   
    }

   public void  analyze() throws IOException{
        long timeTaken[]=new long[3];
        int index=0;
        int shortestAlgo=0;
        char option='a';
        ProductsData []products=details.getProducts();
        do{
        System.out.println("Press 1 for bubble sort");
        System.out.println("Press 2 for selection sort");
        System.out.println("Press 3 for insertion sort");
       // System.out.println("Press 4 for quick sort");
       Scanner scanner=new Scanner(System.in);
       int choice=scanner.nextInt();
        switch(choice)
        {
        case 1: sortByPriceBubble(products);
        sortByRatingBubble(products);
        timeTaken[index++]=System.currentTimeMillis();
        break;
        case 2: sortByPriceSelection(products);
        sortByRatingSelection(products);
        timeTaken[index++]=System.currentTimeMillis();
        break;
        case 3: sortByPriceInsertion(products);
        sortByRatingInsertion(products);
        timeTaken[index]=System.currentTimeMillis();
        break;
        //sortByPriceQuick(products);
        //sortByRatingQuick(products);
        //timeTaken[index++]=System.currentTimeMillis();
        }
        System.out.println("Do you want to continue (Y/N) :");
        option=scanner.next().charAt(0);
        }while(option=='Y'||option=='y');

        for(int i=1;i<timeTaken.length;i++)
        {
            long smallest=timeTaken[0];
            if(timeTaken[i]<smallest && timeTaken[i]>0)
            {
            smallest=timeTaken[i];
            shortestAlgo=i;
            }
        }

        for(int i=0;i<timeTaken.length;i++)
        {
        if(i==0)
        {
        System.out.print("Bubble Sort : ");
        System.out.println(timeTaken[i]);
        }
        if(i==1)
        {
        System.out.print("Selection Sort : ");
        System.out.println(timeTaken[i]);
        }
        if(i==2)
        {
        System.out.print("Insertion Sort : ");
        System.out.println(timeTaken[i]);
        }
        }
        System.out.println("The sorting algorithm which takes the least time to execute is : ");
        if(shortestAlgo==0)
        System.out.println("Bubble sort");
        else if(shortestAlgo==1)
        System.out.println("Selection sort");
        else if(shortestAlgo==2)
        System.out.println("Insertion sort");
        //else if(shortestAlgo==3)
        //System.out.print("Quick sort");   
        
    }

    private void sortByRatingInsertion(ProductsData[] products)
    {
        int j;
        for(int i=1;i<products.length;i++)
        {
            ProductsData temp=products[i];
            j=i-1;
        while(j>=0 && products[j].getProductRating()<temp.getProductRating())
        {
            products[j+1]=products[j];
            j--;
            products[j+1]=temp;
        }
    }
        writeDataToFile(products,"./data/SortedByRating.csv");
    }

    private void sortByPriceInsertion(ProductsData[] products)
    {
        int j;
        for(int i=1;i<products.length;i++)
        {
            ProductsData temp=products[i];
            j=i-1;
        while(j>=0 && products[j].getRetailPrice()<temp.getRetailPrice())
        {
            products[j+1]=products[j];
            j--;
            products[j+1]=temp;
        }
    }

        writeDataToFile(products,"./data/SortedByPrice.csv");
    }

    private void sortByRatingQuick(ProductsData[] products){

        writeDataToFile(products,"./data/SortedByRating.csv");

   }

    private void sortByPriceQuick(ProductsData[] products)
    {


        writeDataToFile(products,"./data/SortedByPrice.csv");
    }

    private void sortByRatingSelection(ProductsData[] products)
    {
        for(int count=0;count<products.length-1;count++){
            for(int i=count+1;i<products.length-1;i++){
                if(products[count].getProductRating()<products[i].getProductRating()){
                    ProductsData temp=products[i];
                    products[i]=products[i+1];
                    products[i+1]=temp;
                }
            }
            }
            writeDataToFile(products,"./data/SortedByRating.csv");
    }

    private void sortByPriceSelection(ProductsData[] products)
    {
        for(int count=0;count<products.length-1;count++){
            for(int i=count+1;i<products.length-1;i++){
                if(products[count].getRetailPrice()<products[i].getRetailPrice()){
                    ProductsData temp=products[i];
                    products[i]=products[i+1];
                    products[i+1]=temp;
                }
            }
            }
            writeDataToFile(products,"./data/SortedByPrice.csv");
    }

    public void sortByPriceBubble(ProductsData []products){
        for(int count=1;count<=products.length;count++){
            for(int i=0;i<products.length-1;i++){
                if(products[i].getRetailPrice()<products[i+1].getRetailPrice()){
                    ProductsData temp=products[i];
                    products[i]=products[i+1];
                    products[i+1]=temp;
                }
            }
            }
            writeDataToFile(products,"./data/SortedByPrice.csv");
    }

    public void sortByRatingBubble(ProductsData []products){
        for(int count=1;count<=products.length;count++){
            for(int i=0;i<products.length-1;i++){
                if(products[i].getProductRating()<products[i+1].getProductRating()){
                    ProductsData temp=products[i];
                    products[i]=products[i+1];
                    products[i+1]=temp;
                }
            }
            }
            writeDataToFile(products,"./data/SortedByRating.csv");
    }

    public void printProducts(ProductsData []products){
        for(ProductsData data:products){
            System.out.println(data);
        }
    }

    public void writeDataToFile(ProductsData []products,String file){
        try{
            bufferedwriter=new BufferedWriter(new FileWriter(file,true));
            bufferedwriter.write(details.header());
            bufferedwriter.newLine();
            for(int index=0;index<products.length;index++){
                bufferedwriter.write(products[index].toString());
                bufferedwriter.newLine();
            }
            bufferedwriter.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}