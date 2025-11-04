import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Comparator;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%-10s | Category: %-10s | Price: %.2f", name, category, price);
    }
}

public class PracticeC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 85000, "Electronics"),
                new Product("Phone", 55000, "Electronics"),
                new Product("TV", 65000, "Electronics"),
                new Product("Shirt", 1500, "Clothing"),
                new Product("Jeans", 2000, "Clothing"),
                new Product("Blender", 3500, "Appliances"),
                new Product("Microwave", 7500, "Appliances")
        );

        // 1. Group by Category
        System.out.println("Products Grouped by Category:\n");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(p -> System.out.println("  " + p));
        });

        // 2. Most Expensive Product in Each Category
        System.out.println("\nMost Expensive Product in Each Category:\n");
        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        maxPriceByCategory.forEach((category, product) ->
                System.out.println(category + " -> " + product.orElse(null)));

        // 3. Average Price of All Products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.printf("\nAverage Price of All Products: %.2f\n", avgPrice);
    }
}
