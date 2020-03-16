# API Rest 

### Tecnologias Empregadas no Desenvovlimento da API
Refêrencia de tecnologias utilizadas na construção do projeto:

* [Java 8](https://www.java.com)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Apache Maven](https://maven.apache.org/guides/index.html)
* [Swagger](https://swagger.io/)
* [Docker](https://www.docker.com/)
* [MySQL](https://www.mysql.com/)

### Guia de Construção da API
Na pasta raiz do projeto, execute o comando maven para realizar o build da api e gerar o pacote .jar 

<code>
    mvn clean install
</code>


### Guia de Implantação
Para inciar o serviço da api e do banco de dados execute o comando docker na pasta raíz do projeto:

<code>
    docker-compose up
</code>

### Documentação da API

Para ter acesso a documentação da API gerada pelo Swagger é só acessar o endereço: http://[IP_SERVER]:8080/swagger-ui.html