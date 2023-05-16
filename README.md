# Take home test da Maker

## Java test - Respostas

1- As classes criadas com base no estudo de caso estão em /src/main/java/example/model/*.

2- O Lombok é uma biblioteca de utilidades que serve para reduzir a quantidade de código repetitivo em uma aplicação.
Ele também adiciona suporte para anotações e geração de códigos comuns.

3-Os próximos passos para tornar as classes criadas gerenciáveis em um banco de dados relacional usando um framework de
persistência são:
* Criar os esquemas e os modelos de entidades para as tabelas (usando o framework).
* Criar as tabelas no banco de dados (usando o framework).
* Criar a interface de repositório e o controlador para ler e gravar os objetos (usando o framework).

4- Foi criada uma interface de repositório e um controlador com duas rotas em seus respectivos pacotes.
Infelizmente, inicializei o projeto de forma incorreta, sem as dependências necessárias para verificar
se a solução está funcionando corretamente.

5- Foi criada uma classe chamada "Fetcher.java" dentro do mesmo projeto em /src/main/java/util.
Em vez de usar o modelo de classe proposto no exercício 1, acabei criando uma classe genérica para verificar se a
reflexão funcionaria. No entanto, usar reflexão para tentar analisar uma classe a partir de um JSON não parece
uma abordagem adequada.

6- Foi criada uma classe chamada "Xml_Json_Conv.java" dentro do mesmo projeto em /src/main/java/util.

## SQL test - Respostas

1- A estrutura se refere a uma ordem de despacho de mercadoria.
Ela contém campos de conexão com outros objetos através dos campos com final "id" (parentOrderId, clientId, channelId etc).
Também possui informações sobre o status da própria ordem, custo de frete (shipping costs),
informações de gerenciamento do armazém responsável (fulfillmentId e campos scheduled),
responsável pelo transporte dos volumes (carrier) e informações para notificação de atualizações da ordem (notify),
entre outros. As principais entidades dentro dessa ordem são:
* Remetente da mercadoria (sender): dados gerais e endereço.
* Destinatário da mercadoria (recipient): dados gerais e endereço.
* Volumes transportados (array de volumes): contém medidas e peso, provavelmente para cálculo de frete (shipping nos dados principais da ordem). Também contém dados de rastreamento para acompanhamento pelo cliente e custo do pedido (invoice) para fiscalização.
* Histórico de transporte (transportationHistory): contém dados sobre mudanças de status e histórico de datas de interações.
* Interações (interactions): parece conter dados sobre o status de integração com várias APIs.

2- Veja a imagem mysqlTest-Maker.png no repositório.

3- Consulte o arquivo queries.sql neste repositório.

4- Derivar um diagrama de entidade-relacionamento a partir de um JSON é uma tarefa complicada, pois o JSON representa apenas o que o criador da consulta inicial deseja mostrar, ocultando possíveis campos e relações importantes. A única análise que posso fazer com base nos campos desse JSON é que há vários campos de ID com formato de "string",