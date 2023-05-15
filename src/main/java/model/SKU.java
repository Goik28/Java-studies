package model;

import java.util.ArrayList;

/* Criado atributo "size" pelos exemplos dados, porem talvez seja interessante criar uma
outra classe para caracteristicas e atribuir como uma lista, seria uma solucao mais "generica".
Ha novamente uma lista de imagens, porem o construtor nao obriga seu uso.
Novamente, talvez fosse interessante a criacao de metodos para manipulacao da informacao contida
na lista e nao apenas da lista em si.
* */
public class SKU {
    private String barcode;
    private String size;
    private int quantity;
    private ArrayList<Image>images;

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

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
