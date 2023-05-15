package model;
import java.util.ArrayList;

/* Criacao do Produto pelo construtor exige uma lista de sku.
Como foi criado setter e getter de forma generica, e recomendado a criacao de metodos para
manipulacao do conteudo das listas, e nao apenas da lista em si.
Caso houver campos que nao devam ser manipulados, adicionar o identificador "final".
* */
public class Product {
    private String name;
    private String description;
    private String brand;
    private String department;
    private ArrayList<SKU> skus;
    private ArrayList<Image>images;

    public Product(String name, String description, String brand, String department, ArrayList<SKU> skus, ArrayList<Image> images) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.department = department;
        this.skus = skus;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<SKU> getSkus() {
        return skus;
    }

    public void setSkus(ArrayList<SKU> skus) {
        this.skus = skus;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
