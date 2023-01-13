# desafio-estagiario-3

Instruções para execução do projeto
Se quiser executar o projeto localmente é bem simples, porem é necessario que tenha algumas ferramentas instaladas.
* Baixe e instale o git clicando [aqui](https://git-scm.com/downloads).
* Baixe e instale o JDK17 clicando [aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
* Baixe e instale o IDE Java de sua escolha e preferencia(Eu indico o [VSCode](https://code.visualstudio.com/Download)).
* Baixe e instale o Docker clicando [aqui](https://www.docker.com/products/docker-desktop/).
  

Após instalar todos os programas solicitados (ou se já tiver os mesmos) siga os passos seguintes:
  1. Clone o referido repositorio, executando o comando a seguir via bash do terminal git utilizando o protocolo HTTPS:
  ```
    git clone https://github.com/0JAFC0/desafio-estagiario-3
  ```
  Caso deseje clonar utilizando SSH pode utilizar o comando abaixo:
  ```
    git clone git@github.com:0JAFC0/desafio-estagiario-3.
  ```
  2. Depois de ter clonado o projeto abra ele na IDE escolhida, depois disto execute o comando abaixo para executar o Docker-Composer onde ele vai subir o conteiner da API REST e o Banco de dados.
```
  docker compose up --build --detach
```
**Caso queira acessar a documentação. copie e cole a url abaixo**
  ```
    http://localhost:8080/swagger-ui/
  ```
Caso queira outra alternativa para rodar o projeto sem o Docker e o Docker composer siga as etapas abaixo: 
1. abra a pasta do projeto na sua IDE.
2. depois crie um banco de dados com o nome ``db-gestao`` atraves do PGADMIN ou de qualquer outro gerenciador de banco de dados, eu tenho preferencia pelo DBeaver.
3. depois configure as variaveis do application-dev.properties com as configurações especificas, sendo essas o ``spring.datasource.username`` onde você vai substituir o ``postgres`` pelo username do seu banco de dados Postgresql que por padrão quando o banco é instalado ele vem com esse mesmo nome, depois configure a senha no campo ``spring.datasource.password`` onde você vai substituir o ``123456`` trocando pela senha do seu banco onde você criou a ``db-gestao``.
4. Depois disto troque o profile spring ``spring.profiles.active`` de ``prod`` para ``dev``
5. Depois dessas configurações execute o seguinte comando ``mvn spring-boot:run`` espere o maven baixar as dependencias.

## O que foi feito?
Este projeto foi organizado em pequenas tarefas onde utilizei do Padrão MVC para organizar as pasta. 
1. [x] Organização de package seguindo o padrão MVC que é um padrão ja estabelicido no mercado.
2. [x] Tipo generico do veiculo contendo os atributos (id, placa, nome, marca).
3. [x] Models dos tipos de veiculos herdando da classe generica.
4. [x] Repositorys dos tipos de veiculos.
5. [x] Serviços dos tipos de veiculos.
6. [x] Endpoint para salvar um Veículo de Passeio. 
(/api/veiculo/passeio)
7. [x] Endpoint para salvar um Veículo de Carga. 
(/api/veiculo/carga)
8. [x] Endpoint para consultar um Veículo de Passeio. 
(/api/veiculo/passeio/findById/{id})
(/api/veiculo/passeio/findByPlaca/{placa})
9. [x] Endpoint para consultar um Veículo de Carga. 
(/api/veiculo/carga/findById/{id})
(/api/veiculo/carga/findByPlaca/{placa})
10. [x] Endpoint para pegar todos os veiculos de passeio
(/api/veiculo/passeio)
11. [x] Endpoint para pegar todos os veiculos de carga
(/api/veiculo/carga)
12. [x] Endpoint para alterar um Veículo de Passeio. 
(/api/veiculo/passeio)
13. [x] Endpoint para alterar um Veículo de Carga. 
(/api/veiculo/carga)
14. [x] Endpoint para remover um Veículo de Passeio. 
(/api/veiculo/passeio/deleteById/{id})
(/api/veiculo/passeio/deleteByPlaca/{placa})
15. [x] Endpoint para remover um Veículo de Carga. 
(/api/veiculo/carga/deleteById/{id})
(/api/veiculo/carga/deleteByPlaca/{placa})
16. [x] Swagger e documentar os EndPoints.
17. [x] Implementar testes unitarios do serviço.
18. [x] Custom Exception Handler para fazer tratamento de exceções customizadas e tambem algumas exceções customizadas.
19. [x] Implementar ModelMapper para converção de DTOs de responses e requests.

## Ferramentas utilizadas
 - **Java 17**
 - **SpringBoot**
 - **Spring Starter Test**
 - **JPA**
 - **Postgresql**
 - **Lombok**
 - **ModelMapper**
 - **Swagger**
 - **Docker**
 - **Docker Composer**

## Desafio Técnico

  - Resumo do problema: Hoje na empresa estamos com muitos veículos de diferentes portes, e todo esse controle de cadastro está sendo através de papel físico. Com isso precisamos de uma sistema para manter o cadastro de todos esses veículos.


  - Dicionário:
    ```
    * Veículo de Passeio: Veículo utilizado para alguns funcionários visitarem seus clientes.
      Atributos: Placa, Nome, Marca, Número de Passageiros
        
    * Veículo de Carga: Veículo utilizado para fazer entregas de mercadorias.
      Atributos: Placa, Nome, Marca, Capacidade, Quantidade de Carroceria
    ```

  Objetivo do Desafio: Desenvolver uma api que tenha uma função de CRUD para manter os cadastros de veículos.


  - Pré-requisitos:
    ```
    * Utilização de banco de dados Oracle, MySQL, H2, Postgres ou qualquer outro banco relacional.
    * Java 17+
    * Maven
    * Swagger
    ```

  - O que esperamos como escopo:
    ```
    * Endpoint para adicionar um Veículo de Passeio
    * Endpoint para adicionar um Veículo de Carga
    * Endpoint para consultar um Veículo de Passeio
    * Endpoint para consultar um Veículo de Carga
    * Endpoint para alterar um Veículo de Passeio
    * Endpoint para alterar um Veículo de Carga
    * Endpoint para remover um Veículo de Passeio
    * Endpoint para remover um Veículo de Carga
    ```

  - Não precisa desenvolver:
    ```
    * Front
    ```

  - Extra/Bônus (Não Obrigatório)
    ```
    * Implementar testes unitários
    ```
  
  - O que vamos avaliar:
    ```
    * Organização de código;
    * Funcionamento;
    * Boas práticas;
    ```
