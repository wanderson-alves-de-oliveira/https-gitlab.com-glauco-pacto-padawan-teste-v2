# Documentação do Teste de Conceito para Desenvolvedor Júnior

## Introdução
Este documento descreve o processo de análise de dados de personagens de Star Wars, incluindo informações como nome, status, mentor, contagem de midichlorians e conexão com a Força.

## Dados dos Personagens
Os dados analisados incluem os seguintes personagens:

- **Luke Skywalker**
  - Status: Knight
  - Mentor: Yoda
  - Midichlorians: 12000
  - Conexão com a Força: 7.5

- **Anakin Skywalker**
  - Status: Knight
  - Mentor: Obi-Wan Kenobi
  - Midichlorians: 18000
  - Conexão com a Força: 8.5

- **Obi-Wan Kenobi**
  - Status: Master
  - Mentor: N/A
  - Midichlorians: 15000
  - Conexão com a Força: 8.0

- **Yoda**
  - Status: Master
  - Mentor: N/A
  - Midichlorians: 20000
  - Conexão com a Força: 9.5

## Análise
Observamos que alguns personagens têm mentores listados, enquanto outros não. Isso ocorre porque personagens como Obi-Wan Kenobi e Yoda já alcançaram um nível de maestria onde não precisam mais de um mentor. Em contraste, personagens como Luke Skywalker e Anakin Skywalker ainda estão em fases de aprendizado e, portanto, têm mentores.

## Conclusão
A análise dos dados dos personagens de Star Wars nos permitiu entender melhor a hierarquia e o progresso dentro da Ordem Jedi. Personagens que não têm mentores listados já alcançaram um nível de maestria, enquanto aqueles que têm mentores ainda estão em fases de aprendizado.

## Como Usar os Endpoints
Para utilizar os endpoints, siga as instruções abaixo:

### Endpoints da API
### 1. **Criar Jedi**

- **URL:** `/jedis/create`
- **Método:** `POST`
- **Descrição:** Cria um novo Jedi com informações de nome, status e conexão com a força.
- **Corpo da Requisição:**

```json
{
  "nome": "Luke Skywalker",
  "status": "Master",
  "conexaoComAForca": 9.5
}
```
### 2. Obter Todos os Jedis

- **URL:** `/jedis/all`
- **Método:** `GET`
- **Descrição:** Obtém uma lista de todos os Jedi cadastrados..
- **Corpo da Requisição:**

```json
[
  {
    "nome": "Luke Skywalker",
    "status": "Master",
    "midichlorians": 12000,
    "conexaoComAForca": 9.5
  },
  {
    "nome": "Anakin Skywalker",
    "status": "Knight",
    "midichlorians": 10000,
    "conexaoComAForca": 8.5
  }
]
```

### 3. Obter Mestres e Aprendizes

- **URL:** `/jedis/masters-and-apprentices`
- **Método:** `GET`
- **Descrição:** Obtém uma lista de mestres e seus aprendizes Jedi.
- **Corpo da Requisição:**

```json
[
  {
    "mestre": "Yoda",
    "aprendiz": "Luke Skywalker"
  },
  {
    "mestre": "Obi-Wan Kenobi",
    "aprendiz": "Anakin Skywalker"
  }
]
```

### 4. Obter Jedis com Midichlorians Acima de 9000

- **URL:** `/jedis/masters-and-apprentices`
- **Método:** `GET`
- **Descrição:** Obtém todos os Jedi com midichlorians acima de 9000.
- **Corpo da Requisição:**

```json
[
  {
    "nome": "Luke Skywalker",
    "status": "Master",
    "midichlorians": 12000,
    "conexaoComAForca": 9.5,
    "mentor": "Yoda"
  }
]
```

### 4. Contar Jedis por Categoria (Status)

- **URL:** `/jedis/count-by-category`
- **Método:** `GET`
- **Descrição:** Obtém todos os Jedi com midichlorians acima de 9000.
- **Corpo da Requisição:**

```json
[
  {
    "status": "Master",
    "quantidade": 1
  },
  {
    "status": "Knight",
    "quantidade": 1
  }
]
```