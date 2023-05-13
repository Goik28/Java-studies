package model;
import java.util.List;
public class Product {
    private final String name;
    private final String description;
    private final String brand;
    private final String department;
    private final List<SKU>skus;
    private final List<Image>images;

    public Product(String name, String description, String brand, String department, List<SKU> skus, List<Image> images) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.department = department;
        this.skus = skus;
        this.images = images;
    }
}
