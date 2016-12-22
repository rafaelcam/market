# Integração de Loja com API's do Moip

- market-web-view
- market-control-service
- market-moip-service

### Aplicação Web_`(market-web-view)`_

A interface dessa aplicação foi implementada utilizando Angular 2, HTML5 e CSS3 encapsulados em um projeto Java usando Spring Boot. Nela o usuário pode escolher seus produtos e finalizar sua compra.

Para a instalação do projeto é necessário baixar as dependências com o npm, compilar os arquivos TypeScript e construir o artefato Jar com o Maven.

Baixando as dependências do Angular 2 com `npm`:
```bash
#!/market-web-view/src/main/resources/public
$ npm install
```

Compilando arquivos TypeScript com `npm`:
```bash
#!/market-web-view/src/main/resources/public
$ npm start
```

Construindo artefato do projeto com `Maven`:
```bash
#!/market-web-view
$ mvn clean install
```

Sendo um projeto spring boot será gerado um `Jar` executável na pasta `target`. O projeto está configurado para subir na porta `8080`. Execute:
```bash
#!/market-web-view/target
$ java -jar market-web-view-0.0.1-SNAPSHOT.jar
```

Agora acesse `http://localhost:8080/`

### Serviço para controle de Compras`(market-control-service)`

Projeto java construido utilizando Spring Boot.

Todas as configurações necessárias para a execução do projeto estão no arquivo `application.yml` localizado no diretório `market-control-service/src/main/resources/application.yml`. Substitua as chaves `${}` pelos devidos valores.

```yml
# Configuração de porta do serviço
server:
  port: 8081

# Configuração de acesso ao Banco de Dados
spring:
  datasource:
    url: jdbc:mysql://${host_banco}:${porta_banco}/${schema_banco}?useSSL=false
    username: ${usuario}
    password: ${senha}
    driver-class: com.mysql.jdbc.Driver

  jpa:
    database-platform: org.hibernate.dialect.MySQL5Dialect
    show-sql: true
    generate-ddl: true
    hibernate:
      ddl-auto: update

# Configuração da url de acesso do serviço Moip
market:
  moip:
    service:
      url: http://${host_service_moip}:8082

# Configurações de requests
rest:
  timeout:
    connect: 20000
    read: 20000
```

O serviço está configurado para acessar o MySql, mas é possível acessar qualquer banco de dados, sendo necessário somente alterar as configurações.

Construindo artefato do projeto com `Maven`:
```bash
#!/market-control-service
$ mvn clean install
```

Sendo um projeto spring boot será gerado um `Jar` executável na pasta `target`. O projeto está configurado para subir na porta `8081`. Execute:
```bash
#!/market-control-service
$ java -jar market-control-service-0.0.1-SNAPSHOT.jar
```



