package RWScenarios;

import java.util.*;
public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(product == null) throw new IllegalArgumentException("Product cannot be null");
        if(product.getPrice() < 0) throw new IllegalArgumentException("Price cannot be negative");
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public double calculateTotal(){
        double total = 0;
        for(Product p : products){
            total += p.getPrice();
        }
        return total;
    }

    public double applyDiscount(){
        double total = calculateTotal();
        if(total > 1000){
            total *= 0.9;
        }
        return total;
    }

    public List<Product> getProductsByCategory(String category){
        List<Product> result = new ArrayList<>();
        for(Product p : products){
            if(p.getCategory().equalsIgnoreCase(category)){
                result.add(p);
            }
        }
        return result;
    }

    public void clearCart(){
        products.clear();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products); // return a copy for encapsulation
    }

}
