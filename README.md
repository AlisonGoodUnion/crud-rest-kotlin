# Crud Rest Kotlin

* Dependências: 

        Spring Boot 2.2.10
        Kotlin
        Gradle
        MongoDB embedded
        JDK 11
        
Para testes pode ser utilizado o arquivo 

    /test/kotlin/com/example/demo/test/teste.http

###
POST http://localhost:8080/contas
Content-Type: application/json

```json
{
  "nome": "Fulano",
  "documento": "88888888888"
}
```

###
GET http://localhost:8080/contas
Content-Type: application/json

### - pode ser utilizado PATH para alterar parte do objeto.
PUT http://localhost:8080/contas/88888888888
Content-Type: application/json

```json
{
    "nome": "Fulano com sobrenome",
    "documento": "9",
    "saldo": 100.00
}
```

###
DELETE http://localhost:8080/contas/9
Content-Type: application/json
