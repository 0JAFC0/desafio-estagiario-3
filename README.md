# desafio-estagiario-3

Instruções para execução do projeto
Se quiser executar o projeto localmente é bem simples, porem é necessario que tenha algumas ferramentas instaladas.
* Baixe e instale o git clicando [aqui](https://git-scm.com/downloads).
* Baixe e instale o JDK17 clicando [aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
* Baixe e instale o IDE Java de sua escolha e preferencia(Eu indico o [VSCode](https://code.visualstudio.com/Download)).
    
Apos instalar todos os programas solicitados (ou se ja tiver os mesmos) siga os passos seguintes:
  1. Clone o referido repositorio, executando o seguinte comando a seguir via bash do terminal git utilizando o protocolo HTTPS:
  ```
    git clone https://github.com/0JAFC0/desafio-estagiario-3
  ```
  caso queira clonar utilizando SSH pode utilizar o comando abaixo:
  ```
    git clone git@github.com:0JAFC0/desafio-estagiario-3.
  ```
  2. Abra o arquivo na sua IDE e espere o maven baixar as dependencias:
  3. ATENÇÂO: é Realmente Importante não esquecer de configurar as variaveis do application.properties 
  ```
  tes
  ```
## O que foi feito?
      1. [x] Organização de package seguindo o padrão MVC que é um padrão ja estabelicido no mercado.
      2. [x] Tipo generico do veiculo contendo os atributos (id, placa, nome, marca).
      3. [x] Models dos tipos de veiculos herdando da classe generica.
      4. [x] Repositorys dos tipos de veiculos.
      5. [x] Serviços dos tipos de veiculos.
      6. [x] Endpoint para adicionar um Veículo de Passeio.
      7. [x] Endpoint para adicionar um Veículo de Carga.
      8. [x] Endpoint para consultar um Veículo de Passeio.
      9. [x] Endpoint para consultar um Veículo de Carga.
      10. [x] Endpoint para alterar um Veículo de Passeio.
      11. [x] Endpoint para alterar um Veículo de Carga.
      12. [x] Endpoint para remover um Veículo de Passeio.
      13. [x] Endpoint para remover um Veículo de Carga.
      14. [x] Swagger e documentar os EndPoints.
      15. [x] Implementar testes unitarios do serviço.
      16. [x] Custom Exception Handler para fazer tratamento de exceções customizadas e tambem algumas exceções customizadas.
      17. [] Implementar ModelMapper para converção de DTOs de responses e requests.
### Desafio Técnico

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
