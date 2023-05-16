## 3- Implemente consultas utilizando PL/SQL para realizar extração das seguintes informações:
### a. Listar pedidos de um determinado “pessoa física ou jurídica destinatário” contendo:
 Dados do Destinatário, Pedido, Data de Criação, Valor Total, Data Prevista de Entrega.
 Possibilitar inclusive que sejam filtrados por: E-mail Destinatário e/ou Telefone;

“SELECT r.firstName, r.lastName, r.email, r.phone, r.type, r.federalTaxPayerId,
r.stateInscription, o.orderId, o.createdAt, o.estimatedDeliveryDate, SUM(ol.price *
ol.quantity) AS invoiceTotal
FROM orders o
JOIN recipients r ON o.recipientId = r.recipientId
JOIN volume v ON o.orderId = v.orderId
JOIN invoice i ON v.volumeId = i.volumeId
WHERE o.recipientId = [id da pessoa fisica ou juridica destinatario] OR r.email = [e-mail]
OR r.phone = [telefone]
GROUP BY o.orderId”

### b. A partir de um número de pedido, realizar a listagem de todos os Volumes que serão transportados;

“SELECT *
FROM Volume
WHERE orderId = [número do pedido]”

### c. A partir de um número de pedido, realizar a listagem de todos os Produtos que serão transportados;

“SELECT o.orderId, SUM(v.itemQuantity) AS totalItemQuantity
FROM orders o
JOIN volumes v ON o.orderId = v.orderId
WHERE o.orderId = [número do pedido]
GROUP BY o.orderId;“

### d. Totalizar todos os pedidos por EMITENTE, aplicando uma agregação para apresentar a quantidade de
pedidos, o valor total e o ticket médio de cada venda;

“SELECT o.senderId, COUNT(DISTINCT o.orderId) as order_quantity, SUM(i.total) as
total_invoice, AVG(i.total / COUNT(DISTINCT o.orderId)) as medium_ticket
FROM Orders o
JOIN Volumes v ON o.orderId = v.orderId
JOIN Invoice i ON v.invoiceId = i.invoiceId
GROUP BY o.senderId”

### e. Totalizar a quantidade de volumes transportados por TRANSPORTADORA, apresentando a quantidade total
transportada e volumes e quantidade de produtos;

“SELECT o.carrier, COUNT(v.volumeId) AS totalVolumes, SUM(v.itemQuantity) AS
totalItems
FROM `order` o
JOIN volume v ON o.orderId = v.orderId
GROUP BY o.carrier”

###  f. Totalizar todos os produtos vendidos, apresentando seu código, descrição, total de quantidade e total de valores;

O JSON fornecido não continha informações referentes a produtos individuais
vendidos, descrições, códigos etc.

### g. Listar pedidos de uma determinada “pessoa jurídica emitente”, contendo:
Dados do Emitente, Pedido, Data de Criação, Valor Total, Data Prevista de Entrega.
Possibilitar inclusive que sejam filtrados por: Emitente e/ou Transportadora.
Além disso, deve-se aplicar uma paginação para que sejam retornados apenas 10 pedidos.

“SELECT o.orderId, o.createdAt, i.total, o.estimatedDeliveryDate, s.*
FROM Order o
JOIN Sender s ON o.owner = s.id
JOIN Volume v ON o.orderId = v.orderId
JOIN Invoice i ON v.name = i.number
WHERE s.id = [pessoa juridica emitente] OR o.carrier = [transportadora]
ORDER BY o.createdAt DESC
LIMIT 10;”