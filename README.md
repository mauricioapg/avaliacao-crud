# Projeto Avaliação
- Este projeto permite o agendamento de transferências financeiras.

## Tecnologias e ferramentas utilizadas

- Java 11
- Spring Boot 3.3
- Spring Data JPA
- OpenAPI 2.3
- Banco de Dados H2

## Intruções para executar o build

### MacOS
- Se ainda não tiver o Maven instalado, instale-o usando Homebrew:
  - brew install maven
    <br>
    <br>
- Abra o diretório do projeto onde o arquivo pom.xml está localizado e execute:
  - mvn clean install
    <br>
    <br>
- Execute o seguinte comando para rodar o projeto e mantê-lo em segundo plano:
  - nohup java -jar target/avaliacao-0.0.1-SNAPSHOT &

### Windows
- Se ainda não tiver o Maven instalado, faça o download  em: https://maven.apache.org/download.cgi e siga as instruções de instalação.
    <br>
    <br>
- Adicione o diretório bin do Maven ao PATH nas variáveis de ambiente do Windows.
  <br>
  <br>
- Abra o diretório do projeto onde o arquivo pom.xml está localizado e execute:
  - mvn clean install
    <br>
    <br>
- Execute o seguinte comando para rodar o projeto e mantê-lo em segundo plano:
  - start java -jar target/avaliacao-0.0.1-SNAPSHOT


## Resumo

- Após buildar o projeto, a documentação dos endpoints pode ser acessada no seguinte endereço: http://localhost:8080/swagger-ui/index.html#/
  <br>
  <br>
- A aplicação cria e armazenas as informações no banco de dados incorporado H2.
  <br>
  <br>
- Foram criados endpoints para fazer o CRUD completo de agendamentos de transferências financeiras.



