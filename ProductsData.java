public class ProductsData {
    private String pid;
    private String productName;
    private String brand;
    private String productUrl;
    private float retailPrice;
    private float discountedPrice;
    private float productRating;

    public ProductsData(){

    }
    public ProductsData(String pid,String productName,String brand,
    String productUrl,float retailPrice,float discountedPrice,float productRating){
        this.pid=pid;
        this.productName=productName;
        this.brand=brand;
        this.productUrl=productUrl;
        this.retailPrice=retailPrice;
        this.discountedPrice=discountedPrice;
        this.productRating=productRating;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getProductUrl() {
        return productUrl;
    }
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
    public float getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }
    public float getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public float getProductRating() {
        return productRating;
    }
    public void setProductRating(float productRating) {
        this.productRating = productRating;
    }

    @Override
    public String toString(){
        return ""+pid+","+productName+","+brand+","
                +productUrl+","+retailPrice+","+discountedPrice+","+productRating;
    }
    
}