package RWScenarios;

import java.util.*;
public class Driver {

    public static void main(String[] args) {

        // Create products
        Product p1 = new Product(1, "Laptop", 75000, "Electronics");
        Product p2 = new Product(2, "Phone", 30000, "Electronics");
        Product p3 = new Product(3, "Shoes", 2500, "Fashion");
        Product p4 = new Product(4, "T-Shirt", 1200, "Fashion");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.addProduct(p4);

        // Calculate total
        double total = cart.calculateTotal();
        System.out.println("Total price: " + total);

        // Apply discount
        double discountedTotal = cart.applyDiscount();
        System.out.println("Total after discount: " + discountedTotal);

        // Get products by category
        List<Product> electronics = cart.getProductsByCategory("Electronics");
        System.out.println("\nElectronics products:");
        for (Product p : electronics) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        // Remove a product
        cart.removeProduct(p3);
        System.out.println("\nAfter removing Shoes, total: " + cart.calculateTotal());

        // Clear cart
        cart.clearCart();
        System.out.println("\nCart cleared. Total: " + cart.calculateTotal());
    }
}