# Integração de Loja com API's do Moip

- market-web-view
- market-control-service
- market-moip-service

### Aplicação Web

A interface dessa aplicação foram implementas utilizando Angular 2, HTML5 e CSS3 encapsulados em um projeto Java usando Spring Boot. Nela o usuário pode escolher seus produtos e finalizar sua compra.

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





