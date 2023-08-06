public class Product
{
    private final String productName;
    private final double productPrice;
    public Product(String productN,double productP ) {
        this.productName = productN;
        this.productPrice = productP;
    }
    public String getProductName() {
        return productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
}
