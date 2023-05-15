package util;

import org.json.JSONObject;
import org.json.XML;
/* Acredito que a ideia nao era usar uma biblioteca pronta de conversao, porem resolvi usar por simplicidade.
No caso de ter que fazer "na unha" seria necessario tratar a estrutura xml como uma arvore binaria e percorrer ela
usando um algoritmo de profundidade (depth first) e converter as tags para chaves do json.
* */
public class xml_json_conv {
    public static void main(String[] args){
        String xml_data = "<teste><maker>questao 6</maker><converter>XML</converter><para>JSON</para></teste>";
        JSONObject obj = XML.toJSONObject(xml_data);
        System.out.println(obj.toString());
    }
}
