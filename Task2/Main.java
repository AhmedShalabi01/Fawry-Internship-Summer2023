public class Main {

    public static void main(String[] args) {

        Product pro1 = new Product("Casio calculator fx-991ex",350.5);
        Product pro2 = new Product("Casio watch ltp 1308d analog, metallic",1859.5);
        Product pro3 = new Product("Casio ctk-1500 61-key piano look keyboard, black",5548.34);

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(pro1);
        cart.addItem(pro2);
        cart.addItem(pro3);
        cart.removeItem(pro3);

        OrderProcessing order = new OrderProcessing();
        order.placeOrder(cart);

    }
}
