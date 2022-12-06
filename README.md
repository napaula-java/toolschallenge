# toolschallenge

a Api toolschallenge é uma api Rest de pagamentos, as seguintes tecnologias foram usadas para seu desenvolvimento: Java 8, Spring Boot, Spring MVC, Spring Data JPA
e banco de dados em memória(h2). Utilizando protocolo HTTP, foram implementados as operações de consulta(verbo get), além de pagamento e estorno (utilizando post e patch).
Utilizou-se a interface repository herdando os métodos do JpaRepository para persistir os dados, além de DTOs para que não houvesse requisições desnecessárias para 
efetuar o pagamento e Enums para os Status. 
A Api ainda precisa de melhorias, como a implementação de testes unitários, os testes dos endpoints foram executados pelo postman.
