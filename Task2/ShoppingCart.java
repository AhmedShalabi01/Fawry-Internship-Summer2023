import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List <Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    public void addItem(Product product) {
        items.add(product);
        System.out.println("Item added to the cart successfully.");
    }
    public void removeItem(Product product) {
        items.remove(product);
        System.out.println("Item removed from the cart successfully.");
    }

    public double getTotalCost() {

        double totalCost = 0;

        for (Product item : items) {
            totalCost += item.getProductPrice();
        }
        return totalCost;
    }
    public List <Product> getItems() {
        return items;
    }


}