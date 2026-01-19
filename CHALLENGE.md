---
# 🧪 Desafio Técnico – Products API

## 📌 Contexto

Você foi contratado para desenvolver uma **API REST** responsável por gerenciar produtos de um sistema interno de uma empresa fictícia de e-commerce.

A aplicação deve ser construída em **Java com Spring Boot**, seguindo boas práticas de arquitetura, organização de código e versionamento.
---

## 🎯 Objetivo

Construir uma API REST que permita **criar, consultar, atualizar e remover produtos**, com persistência em banco de dados relacional e ambiente totalmente dockerizado.

---

## 🛠️ Stack Obrigatória

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker + Docker Compose
- Maven
- JUnit 5

---

## 📦 Entidade: Product

### Campos obrigatórios

| Campo       | Tipo          | Observações            |
| ----------- | ------------- | ---------------------- |
| id          | Long          | Gerado automaticamente |
| name        | String        | Obrigatório            |
| description | String        | Opcional               |
| price       | BigDecimal    | Maior que zero         |
| active      | Boolean       | Default = true         |
| createdAt   | LocalDateTime | Gerado automaticamente |

---

## 🔌 Endpoints Obrigatórios

### ➕ Criar produto

```
POST /products
```

**Request**

```json
{
  "name": "Teclado Mecânico",
  "description": "Switch blue",
  "price": 350.0
}
```

**Response (201)**

```json
{
  "id": 1,
  "name": "Teclado Mecânico",
  "description": "Switch blue",
  "price": 350.0,
  "active": true,
  "createdAt": "2026-01-18T20:30:00"
}
```

---

### 📄 Listar produtos

```
GET /products
```

---

### 🔍 Buscar produto por ID

```
GET /products/{id}
```

---

### ✏️ Atualizar produto

```
PUT /products/{id}
```

---

### ❌ Remover produto (soft delete)

```
DELETE /products/{id}
```

> Não remover do banco. Apenas marcar como `active = false`.

---

## 🧱 Regras de Negócio

- Nome não pode ser vazio
- Preço deve ser maior que zero
- Produto inativo não deve aparecer na listagem padrão
- Não pode criar produto com nome duplicado

---

## 🧩 Arquitetura Obrigatória

```text
controller  → dto → mapper → service → repository → entity
```

✔ DTOs separados em **request / response**
✔ Mapper manual (sem MapStruct)
✔ Exceptions customizadas
✔ `@ControllerAdvice` para tratamento global

---

## 🧪 Testes Obrigatórios

- Testes de Service
- Pelo menos 1 teste de Controller
- Banco em memória (H2) para testes

---

## 🐳 Docker

- Aplicação e banco devem subir com:

```bash
docker-compose up
```

---

## ⭐ Diferenciais (não obrigatórios, mas valorizam)

- Paginação
- Validações com Bean Validation
- Profiles (`dev` / `test`)
- Swagger/OpenAPI
- Migrations com Flyway

---

## 🧠 Como você deve encarar isso

> **Como se fosse um desafio real de empresa.**

Commits pequenos, código limpo, nomes claros.

---
