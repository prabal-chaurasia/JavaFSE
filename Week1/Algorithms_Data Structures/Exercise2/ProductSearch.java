import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class ProductSearch {
    Product[] products;

    public ProductSearch(Product[] products) {
        this.products = Arrays.copyOf(products, products.length);
    }

    public Product linearSearch(String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public Product binarySearch(String name) {
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));
        int left = 0;
        int right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0)
                return sortedProducts[mid];
            if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] arr = {
                new Product(1, "Shoes", "Footwear"),
                new Product(2, "Watch", "Accessories"),
                new Product(3, "Laptop", "Electronics"),
                new Product(4, "Shirt", "Clothing")
        };

        ProductSearch search = new ProductSearch(arr);

        Product result1 = search.linearSearch("Laptop");
        System.out.println("Linear Search Result: " + result1);

        Product result2 = search.binarySearch("Laptop");
        System.out.println("Binary Search Result: " + result2);
    }
}
