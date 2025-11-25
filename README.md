 Star Wars Planetas

Aplicação Java web para gerenciar planetas do universo Star Wars, com integração à API SWAPI para buscar automaticamente o número de aparições em filmes.

## Funcionalidades

- Adicionar planeta (nome, clima, terreno)
- Listar todos os planetas
- Buscar por nome (busca parcial)
- Buscar por ID
- Remover planeta
- Integração automática com SWAPI para contagem de aparições em filmes

## Tecnologias Utilizadas

- **Java 11**


- **JSF 2.3** - Framework MVC
- **PrimeFaces 12.0** - Componentes UI
- **JPA/Hibernate 5.6** - Persistência
- **H2 Database** - Banco de dados em memória
- **CDI/Weld** - Injeção de dependências
- **Maven** - Gerenciamento de dependências
- **JUnit 4** - Testes unitários

## Arquitetura
```
br.starwars
├── modelo/
│   └── Planeta.java          (Entidade JPA)
├── dao/
│   └── PlanetaDao.java        (Acesso ao banco)
├── servico/
│   ├── PlanetaServico.java    (Regras de negócio)
│   └── ApiSwapi.java          (Integração SWAPI)
└── bean/
    └── PlanetaBean.java       (Controller JSF)
```

## Pré-requisitos

- Java JDK 11 ou superior
- Maven 3.6 ou superior
- Apache Tomcat 9 ou superior

## Como Executar

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/starwars-planetas.git
cd starwars-planetas
```

### 2. Compilar o projeto
```bash
mvn clean package
```

### 3. Executar testes
```bash
mvn test



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
http://localhost:8080/planetas/
```

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
