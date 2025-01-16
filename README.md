# padawan-teste-v2

# Respostas Teste de Conceito

## 1) Para subir a Aplicação:
 Observações importantes:
* atualmente uso linux ubuntu como OS, os comandos podem variar para outros sistemas operacionais.
* Configurei o docker-compose para executar na porta 8080, mesmo que a porta padrão da aplicação seja 9099.

Primeiro podemos começar deletando o build anterior e criando um novo build JAR com o comando:

~~~
mvn clean install 
~~~
ou
```
./mvnw clean install
```
----------
Agora podemos subir a aplicação com o comando:
```
docker-compose up -d
```
### Aplicação executando!

## 2) O retorno do post:
### http://localhost:8080/generic-post
```
status: 200
```
body:
~~~
{
"planetAbreviado": "Coruscant",
"rankingMultiplicado": 37944,
"classeAbreviado": "Jedi"
}
~~~

## 3) O retorno se alterar o valor de "ranking" para 0

### erro ao processar o generico
O erro acontece pois quando este endpoint é chamado, ele chama a classe GenericoService e executa o metodo process.
O metodo recebe como parametro GenericoDTO (no caso os valores que foram passados por parametro no endpoint POST)
Faz operação de cortar a String e pegar apenas a primeira palavra das chaves "planet" e "classe",
multiplica o valor de "ranking", e depois usa este valor para realizar uma divisão, porém divisão por zero retorna uma exception.
Essa exception por sua vez é tratada pelo próprio GenericoController, que retorna um erro 500 ao chamar o endpoint GET.

## 4) Para alterar a porta que a aplicação sobe

Pode ser alterada em: 

### src/main/resources/application.properties

Alterando a porta para o valor desejado.

```
server.port=9099
```

Outra opção é alterar a porta no docker-compose.yml como fiz neste projeto.

## 5) O retorno do get:
O retorno do endpoint GET:

### [GET]
* #### localhost:9099/silvio/skills

##### Body Response:

```
{
    "Lord Silvio": [
        "resolve problems",
        "refactor code",
        "maintain code",
        "create queries",
        "eliminate bugs"
    ]
}
```

## 6) defini nome, status, mentor como atributo na classe Jedi

## 7) defini midichlorians como atributo  na classe Jedi

### Endpoints com Queries Native

### [GET]
* #### localhost:9099/jedi/listJedi

##### Body Response:
```
[
    [
        "Silvio Franco",
        "Jedi",
        "Yoda",
        9500
    ],
    [
        "Luke Skywalker",
        "Jedi",
        "Yoda",
        10000
    ]
]
```
-----------
### [GET]
* #### localhost:9099/jedi/jedisPower

##### Body Response:
```
[
    [
        "Silvio Franco",
        "Jedi",
        "Yoda",
        9500
    ],
    [
        "Luke Skywalker",
        "Jedi",
        "Yoda",
        10000
    ],
    [
        "Darth Vader",
        "Jedi Master",
        "Darth Sidious",
        10000
    ],
    [
        "Silvio Franco",
        "Jedi",
        "Yoda",
        9500
    ]
]
```
-----------
### [GET]
* #### localhost:9099/jedi/jedisByStatus

##### Body Response:
```
[
    [
        "Padawan",
        6
    ],
    [
        "Jedi",
        96
    ],
    [
        "Jedi Master",
        6
    ]
]
```


## Pontos a melhorar, tirar a carga do Start da aplicação, criar uma classe de cargaDB com um @Bean para popular o banco de dados com os jedis da aplicação. Criar um application-dev.properties para o ambiente de desenvolvimento e application.properties para o ambiente produção. e criar uma classe anotada como @Configuration para controlar qual o profile, desenvolvimento ou produção. Criar testes unitarios. Implementar Swagger.