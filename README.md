# 🛍️ Products API

![CI Status](https://github.com/edgard-neo/products-api/actions/workflows/ci.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-17-orange)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)

API RESTful para gerenciamento de produtos com Spring Boot 3, Docker e CI/CD.

---

## 🚀 Tecnologias

- **Backend:** Java 17, Spring Boot 3.2.1, Spring Data JPA
- **Database:** PostgreSQL 16
- **Docs:** Swagger/OpenAPI
- **Tests:** JUnit 5, Mockito, JaCoCo
- **DevOps:** Docker, Docker Compose, GitHub Actions

---

## ✨ Funcionalidades

- ✅ CRUD completo de produtos
- ✅ Validação automática de dados
- ✅ Tratamento global de exceções
- ✅ Documentação interativa (Swagger)
- ✅ Testes unitários (100% service layer)
- ✅ Hot reload em desenvolvimento
- ✅ CI/CD pipeline

---

## 📦 Pré-requisitos

- [Docker](https://www.docker.com/) 20.10+
- [Docker Compose](https://docs.docker.com/compose/) 2.22+

---

## 🏃 Quick Start

### 1. Clone o repositório

```bash
git clone https://github.com/edgard-neo/products-api.git
cd products-api
```

### 2. Suba a aplicação

```bash
# Desenvolvimento (com hot reload)
docker compose watch

# Ou sem hot reload
docker compose up
```

### 3. Acesse

- **API:** http://localhost:8080
- **Swagger:** http://localhost:8080/swagger-ui/index.html
- **Docs JSON:** http://localhost:8080/v3/api-docs

---

## 📚 Endpoints

| Método   | Endpoint         | Descrição      |
| -------- | ---------------- | -------------- |
| `POST`   | `/products`      | Criar produto  |
| `GET`    | `/products`      | Listar ativos  |
| `GET`    | `/products/{id}` | Buscar por ID  |
| `PUT`    | `/products/{id}` | Atualizar      |
| `DELETE` | `/products/{id}` | Deletar (soft) |

### Exemplo de Request

```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mouse Gamer",
    "description": "RGB 7 botões",
    "price": 149.90
  }'
```

### Exemplo de Response

```json
{
  "id": 1,
  "name": "Mouse Gamer",
  "description": "RGB 7 botões",
  "price": 149.9,
  "active": true,
  "createdAt": "2026-01-23T10:30:00"
}
```

---

## 🧪 Testes

```bash
# Rodar testes
docker exec -it products-app mvn test

# Gerar relatório de cobertura
docker exec -it products-app mvn jacoco:report
```

Relatório: `target/site/jacoco/index.html`

---

## 📁 Estrutura

```
src/main/java/com/br/
├── controller/          # Endpoints REST
├── service/             # Regras de negócio
├── repository/          # Acesso ao banco
├── domain/              # Entidades JPA
├── dto/                 # Request/Response
├── mapper/              # Conversões DTO ↔ Entity
└── exception/           # Tratamento de erros
```

---

## 🐳 Comandos Docker

```bash
# Desenvolvimento
docker compose watch              # Com hot reload
docker compose up                 # Sem hot reload
docker compose down               # Parar

# Produção
docker compose -f docker-compose.prod.yml up --build -d

# Logs
docker compose logs -f app

# Acessar container
docker exec -it products-app sh

# Acessar PostgreSQL
docker exec -it products-db psql -U products -d products
```

---

## 🛠️ Desenvolvimento Local (Sem Docker)

### Requisitos

- Java 17+
- Maven 3.9+
- PostgreSQL 16+

### Setup

1. **Configure o banco:**

```sql
CREATE DATABASE products;
CREATE USER products WITH PASSWORD 'products';
GRANT ALL PRIVILEGES ON DATABASE products TO products;
```

2. **Configure `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/products
spring.datasource.username=products
spring.datasource.password=products
```

3. **Execute:**

```bash
mvn spring-boot:run
```

---

## 🔄 CI/CD

Pipeline automático via GitHub Actions:

- ✅ Build e compile
- ✅ Testes unitários
- ✅ Análise de segurança (OWASP)
- ✅ Build Docker image
- ✅ Cobertura de código

Configurado em `.github/workflows/ci.yml`

---

## 📋 Padrão de Commits

```
feat: nova funcionalidade
fix: correção de bug
docs: documentação
test: testes
refactor: refatoração
style: formatação
chore: manutenção
```
