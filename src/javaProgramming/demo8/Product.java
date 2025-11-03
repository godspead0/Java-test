package javaProgramming.demo8;

public class Product {
    private String productName;
    private double productPrice;
    private int productId;
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public void SetProductId(int productId) {
        this.productId = productId;
    }
    public void getProduct(Product product) {
        System.out.println(product.productName+" "+product.productPrice+" "+product.productId);
    }
}
