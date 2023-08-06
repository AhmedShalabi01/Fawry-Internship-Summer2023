
public class OrderProcessing {
    public void placeOrder(ShoppingCart cart) {

        System.out.println("------ Order Details ------");

        for (Product item: cart.getItems()) {
            System.out.println(item.getProductName() + " --> " + item.getProductPrice() + " $" );
        }
        System.out.println("The total cost is : " + cart.getTotalCost());
    }
}
