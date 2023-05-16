package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.lang.reflect.Field;

/*Usa os metodos http normais pra fazer um fetch e pegar o body da resposta
A partir do corpo, convertemos para JSON para podermos acessar os campos facilmente.
Usamos reflexion para lermos os campos da classe durante "execution time" e setarmos os campos
com os respectivos valores vindos do JSON se a key for igual ao atributo.
Ao inves de usar a classe modelo do exercicio 1, criei uma nova classe e dei override no metodo
toString para ficar mais facil a verificacao da resposta do teste.
*/
public class fetcher {
    public static void main(String[] args) {
        String url = "https://mockbin.org/bin/14df27ac-12bc-45b9-bd0c-93cb3b81fdfd";
        String body = fetchURLBody(url);
        JSONObject json = new JSONObject(body);
        Produto produto = new Produto();
        Class<?> cls = produto.getClass();
        Field fieldList[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldList.length; i++) {
            String name = fieldList[i].getName();
            if (json.has(name)) {
                fieldList[i].setAccessible(true);
                try {
                    fieldList[i].set(produto, json.get(name).toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(produto.toString());
    }

    public static String fetchURLBody(String urlString) {
        String responseBody = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseBody;
    }
}

class Produto{
    private String title;
    private String price;
    @Override
    public String toString() {
        return ("Title: "+title+"\nPrice: "+price);
    }
}
