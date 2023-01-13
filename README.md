# desafio-estagiario-3

## Descrição

Sistema desenvolvido para o desafio técnico em Desenvolvimento Java do programa de estagio Evoluir da RPE Tech.

Este é um sistema para controlar e gerenciar o cadastro de todos os veículos da empresa, independentemente do seu porte.

Caso queira a descrição completa do desafio clique [aqui](https://gitlab.com/rangeldiego/desafio-estagiario-3)

## Instruções para execução do projeto
Se quiser executar o projeto localmente é bem simples, porem é necessario que tenha algumas ferramentas instaladas.

* Baixe e instale o Git clicando [aqui](https://git-scm.com/downloads).
* Baixe e instale o JDK17 clicando [aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
* Baixe e instale o IDE Java de sua escolha e preferência(Eu indico o [VSCode](https://code.visualstudio.com/Download)).
* Baixe e instale o Postgresql clicando [aqui](https://www.postgresql.org/download/).
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
  2. Depois de ter clonado o projeto abra ele na IDE escolhida, depois disto execute o comando abaixo para executar o Docker Composer onde ele vai subir o conteiner da API REST e o Banco de dados.
```
  docker compose up --build --detach
```
3. Após o container docker inicializar clique no link abaixo para acessar a documentação e saber os Endpoints e models.

   [Link para a documentação](http://localhost:8080/swagger-ui/)

Caso queira outra alternativa para rodar o projeto sem o Docker e o Docker composer siga as etapas abaixo: 
1. abra a pasta do projeto na sua IDE.
2. depois crie um banco de dados com o nome ``db-gestao`` através do [PGADMIN](https://www.pgadmin.org/download/) ou de qualquer outro gerenciador de banco de dados, eu tenho preferência pelo [DBeaver](https://dbeaver.io/download/).
3. depois configure as variaveis do application-dev.properties com as configurações especificas, sendo essas o ``spring.datasource.username`` onde você vai substituir o ``postgres`` pelo username do seu banco de dados Postgresql que por padrão quando o banco é instalado ele vem com esse mesmo nome, depois configure a senha no campo ``spring.datasource.password`` onde você vai substituir o ``123456`` trocando pela senha do seu banco onde você criou a ``db-gestao``.
4. Verifique se a porta do seu banco de dados é a mesma do application.properties a que esta la é 5432 caso não seja substitua pela sua.
5. Depois disto troque o profile spring ``spring.profiles.active`` de ``prod`` para ``dev`` 
6. Depois dessas configurações execute o seguinte comando ``mvn spring-boot:run`` espere o maven baixar as dependências.

## O que foi feito?

Este projeto foi organizado em pequenas tarefas, onde utilizei o Padrão MVC para organizar as pastas. Também utilizei o DTO (Data Transfer Object), que é responsável por fazer o transporte dos dados. Para a conversão das entidades em DTOs e vice-versa, utilizei o ModelMapper. Criei um serviço para centralizar a lógica de conversão e diminuir a quantidade de código repetido. Também criei dois métodos, um para converter objetos e outro para converter objetos em uma lista.
1. [x] Organização de package seguindo o padrão MVC que é um padrão ja estabelicido no mercado.
2. [x] Tipo genérico do veiculo contendo os atributos (id, placa, nome, marca).
3. [x] Models dos tipos de veículos herdando da classe de Veiculo.
4. [x] Repositorys dos tipos de veículos.
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
16. [x] Swagger para documentar os EndPoints e os models.
17. [x] Implementar testes unitários dos métodos dos serviços de VeiculoDeCargaService e VeiculoDePasseioService utilizando o Mockito.
18. [x] Custom Exception Handler para fazer tratamento de exceções customizadas e também algumas exceções customizadas.
19. [x] Implementar ModelMapper para conversão de DTOs de responses e requests para entidades e vice-versa.

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

