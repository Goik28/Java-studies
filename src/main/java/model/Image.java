package model;

//Criado classe de imagens para facilitar a criacao e leitura de imagens para os produtos e SKUs.
public class Image {
    private String url;
    private String alt;

    public Image(String url, String alt) {
        this.url = url;
        this.alt = alt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
