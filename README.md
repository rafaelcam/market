# Integração de Loja com API's do Moip

- market-web-view
- market-control-service
- market-moip-service

Demostrativo: http://ec2-54-187-197-124.us-west-2.compute.amazonaws.com:8080/

## Aplicação Web`(market-web-view)`

A interface dessa aplicação foi implementada utilizando Angular 2, HTML5 e CSS3 encapsulados em um projeto Java usando Spring Boot. Nela o usuário pode escolher seus produtos e finalizar sua compra.

Primeiramente configure o endpoint do serviço controlador da loja:
```TypeScript
#!/market-web-view/src/main/resources/public/src/config/app.config.ts
export class AppConfig {
    public static get API_ENDPOINT(): string { 
    	return 'http://ec2-54-187-197-124.us-west-2.compute.amazonaws.com:8081/'; 
    }
}
```

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

## Serviço para controle de Compras`(market-control-service)`

Projeto java construido utilizando Spring Boot. Esse projeto é destinado ao controle da Loja, o serviço web o acessa para consultar produtos e criar um Pedido de Compra.

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
#!/market-control-service/target
$ java -jar market-control-service-0.0.1-SNAPSHOT.jar
```

Para cadastrar produtos de exemplo você pode utilizar o script localizado em `market-docs/Scripts/adiciona-produtos.sql`

## Serviço de integração com o Moip`(market-moip-service)`

Projeto java construido utilizando Spring Boot. Esse projeto é destinado a integração dos pedidos de compra cadastrados na loja e o Moip. Também contem recursos utilizados pelo serviço de WebHook do Moip possibilitando a integração em tempo real da autorização do pagamento.

Todas as configurações necessárias para a execução do projeto estão no arquivo `application.yml` localizado no diretório `market-moip-service/src/main/resources/application.yml`. Substitua as chaves `${}` pelos devidos valores.

```yml
# Configuração de porta do serviço
server:
  port: 8082

# Configurações comunicação com o Moip (Produção ou Sandbox)
moip:
  endpoint: ${endpoint_moip}
  token: ${token_moip}
  key: ${key_moip}

# Configurações dos requests
rest:
  timeout:
    connect: 20000
    read: 20000

# Configuração da url de acesso do serviço controlador da Loja
market:
  control:
    service:
      url: http://${host_service_control}:8081
```

Construindo artefato do projeto com `Maven`:
```bash
#!/market-moip-service
$ mvn clean install
```

Sendo um projeto spring boot será gerado um `Jar` executável na pasta `target`. O projeto está configurado para subir na porta `8081`. Execute:
```bash
#!/market-moip-service/target
$ java -jar market-control-service-0.0.1-SNAPSHOT.jar
```

### Recurso do WebHook

Esse serviço possui um recurso para atender ao webhook que notifica que o pagamento foi autorizado. o recurso recebe uma instância da entidade `Payment` como parâmetro e chama o serviço controlador da loja passando o número do pagamento autorizado.

```url
http://${host_service_moip}:8082/webhook/payment/authorized
```
