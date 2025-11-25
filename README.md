# Star Wars Planetas

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
```

### 4. Deploy

**Opção A - Tomcat Manual:**
```bash
# Copiar WAR para o Tomcat
cp target/planetas.war /caminho/para/tomcat/webapps/

# Iniciar Tomcat
cd /caminho/para/tomcat/bin
./startup.sh  # Linux/Mac
startup.bat   # Windows
```

**Opção B - IntelliJ IDEA:**

1. Run > Edit Configurations
2. Add New Configuration > Tomcat Server > Local
3. Configure Tomcat Home
4. Deployment > Add Artifact > planetas:war exploded
5. Run

### 5. Acessar aplicação
```
http://localhost:8080/planetas/
```

## Uso da Aplicação

### Adicionar Planeta

1. Preencha os campos: Nome, Clima, Terreno
2. Clique em "Adicionar"
3. O sistema busca automaticamente as aparições em filmes via SWAPI

### Buscar Planeta

- **Por nome:** Digite parte do nome e clique "Buscar"
- **Por ID:** Digite o ID numérico e clique "Buscar por ID"

### Exemplos de Planetas

Para testar, use planetas conhecidos:

- **Tatooine** - 5 aparições
- **Alderaan** - 2 aparições
- **Hoth** - 1 aparição
- **Naboo** - 4 aparições

## API SWAPI

A aplicação integra-se com a [SWAPI](https://swapi.dev/) para buscar automaticamente quantas vezes cada planeta aparece nos filmes.

Endpoint utilizado: `https://swapi.dev/api/planets/?search={nome}`

## Estrutura do Banco de Dados
```sql
CREATE TABLE planetas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    clima VARCHAR(255) NOT NULL,
    terreno VARCHAR(255) NOT NULL,
    aparicoes_filmes INTEGER
);
```

## Testes

O projeto possui testes unitários cobrindo as principais funcionalidades:

- `PlanetaTest` - Testes do modelo
- `ApiSwapiTest` - Testes de integração com SWAPI
- `PlanetaServicoTest` - Testes das regras de negócio
```bash
mvn test
```

## Estrutura de Arquivos
```
planetas/
├── src/
│   ├── main/
│   │   ├── java/br/starwars/
│   │   │   ├── bean/
│   │   │   ├── dao/
│   │   │   ├── modelo/
│   │   │   └── servico/
│   │   ├── resources/
│   │   │   └── META-INF/persistence.xml
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   ├── web.xml
│   │       │   └── beans.xml
│   │       └── index.xhtml
│   └── test/
│       └── java/br/starwars/
├── pom.xml
├── README.md
├── .gitignore
├── Questao2.txt
└── Contador.jsx
```

## Melhorias Futuras

- Adicionar paginação avançada
- Implementar cache para chamadas à SWAPI
- Adicionar mais filtros de busca
- Exportar dados para CSV/Excel
- Adicionar autenticação de usuários

## Autor

Thiago Grigoleti

## Licença

Este projeto é open source e está disponível sob a licença MIT.
