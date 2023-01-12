# desafio-estagiario-3

Instruções para execução do projeto
Se quiser executar o projeto localmente é bem simples, porem é necessario que tenha algumas ferramentas instaladas.
* Baixe e instale o git clicando [aqui]().
* Baixe e instale o JDK17 clicando [aqui]([0JAFC0/desafio-estagiario-rpe](https://git-scm.com/downloads)).
* Baixe e instale o IDE Java de sua escolha e preferencia(Eu indico o [VSCode]()).
    
Apos instalar todos os programas solicitados (ou se ja tiver os mesmos) siga os passos seguintes:
  1. Clone o referido repositorio, executando o seguinte comando a seguir via bash do terminal git:
  ```

  ```
  2. Abra o arquivo na sua IDE e espere o maven baixar as dependencias:
  3. ATENÇÂO: é Realmente Importante não esquecer de configurar as variaveis do application.properties 
  ```

  ```
## O que foi feito?
      1. [x] Tipo generico do veiculo contendo os atributos (id, placa, nome, marca).
      2. [x] Models dos tipos de veiculos herdando da classe generica.
      3. [x] Repositorys dos tipos de veiculos.
      4. [x] Serviços dos tipos de veiculos.
      5. [x] Endpoint para adicionar um Veículo de Passeio.
      6. [x] Endpoint para adicionar um Veículo de Carga.
      7. [x] Endpoint para consultar um Veículo de Passeio.
      8. [x] Endpoint para consultar um Veículo de Carga.
      9. [x] Endpoint para alterar um Veículo de Passeio.
      10. [x] Endpoint para alterar um Veículo de Carga.
      11. [x] Endpoint para remover um Veículo de Passeio.
      12. [x] Endpoint para remover um Veículo de Carga.
      13. [x] Swagger e documentar os EndPoints.
      14. [] Implementar testes unitarios.
      16. [x] Custom Exception Handler para fazer tratamento de exceções customizadas e tambem algumas exceções customizadas.
      15. [] Implementar ModelMapper para converção de DTOs de responses e requests.
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
