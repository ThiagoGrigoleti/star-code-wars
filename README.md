````markdown
# Star Wars Planetas

Aplicação Java web para gerenciar planetas do universo Star Wars, com integração à API SWAPI para buscar automaticamente o número de aparições em filmes.

## Funcionalidades

- **CRUD Completo:** Adicionar, listar, remover e buscar planetas.
- **Busca:** Pesquisa por nome (parcial) e por ID.
- **Integração Externa:** Conexão automática com a [SWAPI](https://swapi.dev/) para contagem de aparições em filmes.
- **Validações:** Impede a criação de planetas com nomes duplicados ou vazios.

## Tecnologias Utilizadas

- **Java 11**
- **Maven** - Gerenciamento de dependências e Build
- **Jetty (Maven Plugin)** - Servidor de aplicação leve para desenvolvimento
- **JSF 2.3** - Framework MVC
- **PrimeFaces 12.0** - Componentes UI
- **JPA / Hibernate 5.6** - Persistência de dados
- **H2 Database** - Banco de dados em memória
- **CDI / Weld** - Injeção de dependências
- **JUnit 4 & Mockito** - Testes unitários

## Arquitetura do Projeto
```text
br.com.thiago.starcodewars
├── model/
│   └── Planeta.java           (Entidade JPA)
├── repository/
│   └── PlanetaDao.java        (Acesso ao banco H2)
├── service/
│   ├── PlanetaServico.java    (Regras de negócio)
│   └── ApiSwapi.java          (Cliente HTTP para SWAPI)
└── bean/
    └── PlanetaBean.java       (Controller JSF/View)
````

## Pré-requisitos

  - Java JDK 11 instalado
  - Maven 3.6 ou superior instalado

## Como Executar (Recomendado)

Este projeto utiliza o plugin do **Jetty**, eliminando a necessidade de instalar e configurar um servidor Tomcat externamente.

### 1\. Clonar o repositório

```bash
git clone [https://github.com/seu-usuario/starwars-planetas.git](https://github.com/seu-usuario/starwars-planetas.git)
cd starwars-planetas
```

### 2\. Rodar a aplicação

Execute o comando abaixo na raiz do projeto. O Maven irá baixar as dependências e iniciar o servidor automaticamente:

```bash
mvn jetty:run
```

*Aguarde até aparecer a mensagem `[INFO] Started Jetty Server` no console.*

### 3\. Acessar no Navegador

Abra o link abaixo para acessar a interface de gerenciamento:

```
http://localhost:8080/planetas/planetas.xhtml
```

> **Nota:** Se você acessar apenas `/planetas/`, verá uma tela de boas-vindas. Navegue para `/planetas.xhtml` para ver o sistema funcional.

### 4\. Parar o Servidor

Para encerrar a execução, pressione `Ctrl + C` no terminal.

-----

## Executando Testes

Para rodar os testes unitários e validar as regras de negócio:

```bash
mvn test
```

## Estrutura do Banco de Dados

O banco H2 está configurado para rodar em memória.

  - **Tabela:** `planetas`
  - **Campos:** `id`, `nome`, `clima`, `terreno`, `aparicoes_filmes`

*Observação: Como o banco é em memória (`jdbc:h2:mem:starwars`), os dados cadastrados serão perdidos ao reiniciar a aplicação.*

## Deploy em Produção (Opcional - Tomcat)

Caso deseje fazer o deploy em um servidor de aplicação tradicional (Wildfly, Tomcat Standalone), gere o arquivo WAR:

```bash
mvn clean package
```

O arquivo `target/planetas.war` poderá ser implantado em qualquer container Servlet compatível.

## Autor

Thiago Grigoleti

## Licença

Este projeto é open source e está disponível sob a licença MIT.

```
```
