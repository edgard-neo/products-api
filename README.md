# API de Produtos com Spring Boot

## O que é isso?

Uma API REST pra gerenciar produtos. Basicamente um CRUD completo, mas feito do jeito certo - com camadas separadas, DTOs, Docker e PostgreSQL.

A ideia era sair do "Java puro" e aprender Spring Boot de verdade, entendendo como as coisas se conectam: controller recebe requisição, service processa lógica, repository acessa banco. Tudo organizado e testado.

## O que dá pra fazer

- Criar produtos
- Buscar produto específico
- Listar todos os produtos
- Atualizar informações
- Deletar produtos

Nada revolucionário, mas é a base que você precisa saber bem antes de fazer coisas mais complexas.

## Como tá organizado

```
.
├── docker-compose.yml    # Configuração dos containers
├── Dockerfile           # Build da aplicação
├── pom.xml             # Dependências Maven
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── br
    │               └── Application.java
    └── test
        └── java
            └── com
                └── br
                    └── ApplicationTest.java
```

Por enquanto tá bem enxuto. A estrutura vai crescendo conforme vou adicionando features (controller, service, repository, etc).

O fluxo que vou seguir é: **Controller → Service → Repository**

E os dados vão passar por **Mapper** pra converter entre DTO e Entity.

## Por que fiz assim

**DTOs separados:** A entidade do banco não é a mesma coisa que vai e volta na API. Isso dá mais controle e segurança.

**Mapper manual:** Por enquanto fiz na mão mesmo. Mais pra frente posso usar MapStruct, mas quis entender o processo primeiro.

**Docker pra tudo:** Rodando tudo em container. Facilita demais - não precisa instalar PostgreSQL na máquina, só dar `docker compose up` e pronto.

**Camadas bem definidas:** Cada classe tem uma responsabilidade. Controller não acessa Repository direto, Service não retorna Entity, etc.

## Tecnologias

- **Java 17** - a versão LTS atual
- **Spring Boot** - framework que facilita muito a vida
- **Spring Data JPA** - pra não escrever SQL na mão
- **PostgreSQL** - banco relacional de verdade
- **Docker** - pra subir tudo fácil
- **JUnit 5** - testes automatizados

## Como rodar

Precisa só do Docker instalado.

```bash
# Sobe tudo (aplicação + banco)
docker compose up --build

# A API fica em:
# http://localhost:8080
```

Pronto. O Docker Compose cria o banco PostgreSQL e já conecta com a aplicação automaticamente.

## Variáveis de ambiente

O Docker já configura tudo, mas pra referência:

```
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/products
SPRING_DATASOURCE_USERNAME=products
SPRING_DATASOURCE_PASSWORD=products
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

## Testes

Fiz testes na camada de service pra validar a lógica de negócio.

```bash
mvn test
```

## O que aprendi fazendo isso

- Como estruturar uma aplicação Spring Boot direito
- A importância de separar DTOs de Entidades
- Como funciona o Spring Data JPA (é mágico, mas entendi a mágica)
- Docker Compose pra subir aplicação + banco junto
- Injeção de dependência na prática
- Como testar serviços com JUnit

## Próximos passos

- Adicionar paginação e ordenação (página com 1000 produtos não faz sentido)
- Implementar autenticação com Spring Security
- Fazer testes de integração (não só unitários)
- Adicionar validações com Bean Validation
- Documentar com Swagger/OpenAPI
- Fazer deploy em alguma cloud (Render, Railway, etc)

## Observações

Esse é meu projeto base pra aprender Spring Boot do jeito certo. Comecei com a estrutura mínima (só o Application.java) e vou adicionando as camadas conforme vou estudando cada parte.

A ideia é não sair copiando código de tutorial, mas entender cada pedaço antes de adicionar. Por isso tá começando pequeno - controller, service, repository, DTOs, tudo vem aos poucos.

A curva de aprendizado do Spring é meio íngreme no começo (muita "mágica" acontecendo), mas quando você entende o fluxo fica bem mais tranquilo.

## Endpoints (quando implementar)

```
POST   /api/products          # Criar produto
GET    /api/products/{id}     # Buscar por ID
GET    /api/products          # Listar todos
PUT    /api/products/{id}     # Atualizar
DELETE /api/products/{id}     # Deletar
```

Por enquanto ainda tô montando a estrutura base.
