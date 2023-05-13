package model;

import java.util.List;

public class SKU {
    private String barcode;
    private String size;
    private int quantity;
    private List<Image>images;

    public SKU(String barcode, String size, int quantity) {
        this.barcode = barcode;
        this.size = size;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
