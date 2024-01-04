# VUUTR - Very Useful Tools To Remember

## Descrição:

Uma API REST e banco de dados para a aplicação VUTTR (Very Useful Tools to Remember). A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags. Você pode verificar o desafio com mais detalhes acessando o [link oficial](https://bossabox.notion.site/Back-end-0b2c45f1a00e4a849eefe3b1d57f23c6) disponibilizado pela própria BossaBox.

## Tecnologias Utilizadas:

- [Spring Framework](https://spring.io/projects/spring-boot) 🍃
  - [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html) 🕸️
  - [Spring Data JPA](https://spring.io/projects/spring-data) 🎲
  - [Spring Validation](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html) ✅
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html) 🔐
- [Maven](https://maven.apache.org/guides/index.html) 🪶
- [Docker](https://docs.docker.com/) 🐳
- [PostgreSQL](https://www.postgresql.org/docs/) 🐘
- [Flyway](https://flywaydb.org/postgresql) 🐦
- [Lombok](https://projectlombok.org/) 🌶
- [JWT Auth](https://jwt.io/introduction) 🎡
- [Springdoc](https://springdoc.org/) 📄

## Como executar a aplicação:

### Requisitos:

- Possuir o [Docker](https://docs.docker.com/engine/install/) instalado.

### Como executar:

- Clonar o repositório:

```bash
$ git clone git@github.com:gusmaomatheus/bossabox-code-challenge.git
``` 

- Acessar o diretório baixado:

```bash
$ cd C:\local_onde_salvou\bossabox-code-challenge
``` 

- Criar a imagem da aplicação:

```bash
$ docker-compose up -d
``` 

- Executar a imagem:

```bash
$ docker run -p 3000:3000 vuttr
``` 

### Como se autenticar na aplicação:

- Primeiro você deve possuir alguma ferramente que facilite o envio de requisições HTTP para a aplicação, como: [Postman](https://www.postman.com/downloads/), [Insomnia](https://insomnia.rest/download), [Bruno](https://www.usebruno.com/downloads). (obs: usei o Bruno para as seguintes prints de exemplo)


- Após isso você deve enviar uma requisição para o endpoint de register (`localhost://3000:vuttr/auth/register`):
      
```json
{
  "username": "admin",
  "password": "password",
  "role": "ADMIN"
}
```

obs: lembrando que para requisições dos tipos POST, PUT e DELETE, o role do usuário deve ser ADMIN, para todas as outras o cargo pode ser tanto COMMON quanto ADMIN.

- Depois, no endpoint de login (`localhost://3000:vuttr/auth/login`), você deve enviar uma requisição também:

```json
{
  "username": "admin",
  "password": "password"
}
```

- Se as credenciais estiverem certas, o retorno esperado será o seguinte:

```json
{
  "status": "OK",
  "message": "Successful logging in to user 'user'",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzZXIiLCJleHAiOjE3MDQzNDk4Mjd9.4WDtWJURcOFgpdUIQWa9MUvOy8BuCbaXyFh4nkz_38s"
}
```

- Após isso, você deve usar esse token em todas as requisições que você fazer nos endpoints `http://localhost:3000/vuttr/tools/**`

![Exemplo](https://imgur.com/vv9vFLA.png)

## Documentação:

A API contém documentação completa criada utilizando o Springdoc da OpenAPI (anteriormente Swagger), abordando todos os detalhes necessários para entender o seu funcionamento. A documentação pode ser acessada em http://localhost:3000/swagger-ui/index.html