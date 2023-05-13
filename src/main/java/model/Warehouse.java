package model;

import java.util.List;

/*Criado classe para armazens, cada armazem tem uma lista de produtos.
O construtor estabelce que pode ser criado um armazem sem produtos.
Getters e Setters permitem adicionar produtos ou mudar os dados fundamentais do armazem.
Talves fosse interessante criar metodos para manipulacao dos itens da lista para facilitar
a busca, insercao e remocao de itens ao inves de manipular a lista inteira.
*/
public class Warehouse {
    private String name;
    private String address;
    private List<Product> products;

    public Warehouse(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
