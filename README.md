# Teste de Conhecimento Dev Jr

Este projeto é um sistema de gerenciamento de Jedis, desenvolvido como parte de um teste técnico. Ele implementa funcionalidades para cadastro, consulta e organização de Jedis, utilizando **Java**, **Spring Boot**, **Hibernate** e **PostgreSQL**.

---

## 📋 Funcionalidades

1. **Cadastro de Jedis**
   - Adicionar novos Jedis com os seguintes atributos:
     - **Nome**
     - **Status** (Padawan, Jedi ou Mestre Jedi)
     - **Mentor**
     - **Quantidade de Midichlorians**
   - Validações para garantir a consistência dos dados.

2. **Consultas**
   - **Listar todos os Mestres Jedis e seus Aprendizes**.
   - **Retornar Jedis com mais de 9000 Midichlorians**.
   - **Contar Jedis agrupados por categoria** (Padawan, Jedi, Mestre Jedi).

3. **Listagem Completa**
   - Listar todos os Jedis cadastrados no sistema.

---

## 🛠️ Tecnologias Utilizadas

- **Java 11**
- **Spring Boot**
- **Hibernate** (para mapeamento objeto-relacional)
- **PostgreSQL** (banco de dados)
- **Bean Validation** (para validações)
- **Maven** (gerenciamento de dependências)
- **Postman** (para testar a API)
---

## 📁 Estrutura do Projeto

A arquitetura do projeto segue o padrão **MVC** (Model-View-Controller), com separação clara das responsabilidades entre as camadas:

- **Controller:** Gerencia os endpoints da API.
- **Service:** Contém a lógica de negócios.
- **Repository:** Interface para interação com o banco de dados.
- **Entity:** Representa as tabelas do banco de dados.
- **DTO:** Transfere dados entre as camadas com validações integradas.
---

## 🚀 Como Executar

### **Pré-requisitos**

- JDK 11 ou superior instalado.
- PostgreSQL configurado e em execução.
- Maven instalado.

### **Configuração do Banco de Dados**

1. Crie um banco de dados chamado `padawan` no PostgreSQL:

   ```sql
   CREATE DATABASE padawan;

2. Atualize as credenciais no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/padawan
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
---

## Como Executar o Projeto 🎉

1. Clone este repositório:
   ```bash
   git clone <https://github.com/lucasbor1/TesteDevJr.git>
   ```
   
2. Navegue até a raiz do projeto no terminal:
   ```bash
   cd padawan-teste-v2
   ```

3. Execute o programa com o comando:
   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em:
   ```bash
   http://localhost:9099
   ```
---

## 📄 Endpoints Disponíveis

### 1. Cadastro de Jedis
- **Descrição:** Adiciona um Jedi ao sistema.
- **Método:** `POST`
- **Endpoint:** `/jedi/add`
- **Body Exemplo:**

```json
{
    "name": "Luke Skywalker",
    "status": "jedi",
    "mentor": "Obi-Wan Kenobi",
    "midichlorians": 12000
}

```
### 2. Listagem Completa de Jedis
- **Descrição:** Lista todos os Jedis cadastrados no sistema.
- **Método:** `GET`
- **Endpoint:** `/jedi/list`
  
### 3. Detalhes de um Jedi
- **Descrição:** Retorna os detalhes de um Jedi específico pelo `id`.
- **Método:** `GET`
- **Endpoint:** `/jedi/{id}`
- **Parâmetro:** 
  - `id` (path): O ID do Jedi a ser consultado.
 
    
### 4. Atualização de Jedi
- **Descrição:** Atualiza os dados de um Jedi específico.
- **Método:** `PUT`
- **Endpoint:** `/jedi/update/{id}`
- **Body Exemplo:**
```json
{
    "name": "Luke Skywalker",
    "status": "jedi",
    "mentor": "Obi-Wan Kenobi",
    "midichlorians": 13000
}
```
### 5. Exclusão de Jedi
- **Descrição:** Exclui um Jedi do sistema.
- **Método:** `DELETE`
- **Endpoint:** `/jedi/delete/{id}`
- **Parâmetro:**
  - `id` (path): O ID do Jedi a ser excluído.
 
    
### 6. Mestres e Aprendizes
- **Descrição:** Retorna todos os Mestres Jedis e seus aprendizes.
- **Método:** `GET`
- **Endpoint:** `/jedi/masters-and-apprentices`

  
### 7. Jedis com Midichlorians Acima de 9000
- **Descrição:** Retorna todos os Jedis com mais de 9000 Midichlorians.
- **Método:** `GET`
- **Endpoint:** `/jedi/above-midichlorians`

### 8. Contagem por Categoria
- **Descrição:** Retorna a quantidade de Jedis agrupados por categoria (Padawan, Jedi, Mestre Jedi).
- **Método:** `GET`
- **Endpoint:** `/jedi/count-by-category`
