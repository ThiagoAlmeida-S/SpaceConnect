# 🌕 SpaceConnect API REST

API REST desenvolvida em **Spring Boot** para gerenciamento e monitoramento de uma base lunar.

O sistema realiza controle de sensores, reservatórios, climatização, alertas, tripulantes e consumo de energia.

---

# 🎯 Objetivo

O projeto tem como objetivo simular uma central inteligente de monitoramento espacial.

A API permite:

- Gerenciar sensores e recursos
- Registrar alertas
- Simular situações críticas
- Monitorar consumo energético
- Controlar climatização da base
- Persistir informações em banco de dados

---

# 👨‍🚀 Integrantes
- Nicolas Cipriano — RM562278
- Pedro de Castro  — RM561825
- Thiago Almeida — RM565365

---

# 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database
- Maven

---

# 🏗️ Arquitetura do Projeto

O projeto segue arquitetura em camadas:

## 📦 Model

Representa as entidades do banco de dados.

---

## 📦 DTO

Controla os dados recebidos e enviados pela API.

---

## 📦 Repository

Responsável pela comunicação com o banco de dados.

---

## 📦 Service

Contém a lógica de negócio e processamento.

---

## 📦 Controller

Responsável pelas rotas da API REST.

---

# 🛰️ Recursos Monitorados

O sistema possui gerenciamento para:

- Sensores
- Reservatórios
- Climatização
- Alertas
- Tripulantes
- Consumo de energia

---

# 🔄 Simulações

A API possui endpoints de simulação para:

- Sensores
- Reservatórios
- Climatização

Essas simulações alteram automaticamente os estados e leituras do sistema.

---

# 📡 Endpoints da API

## 🛰️ Sensores

- `GET /sensores`
- `GET /sensores/{id}`
- `POST /sensores`
- `PUT /sensores/{id}`
- `DELETE /sensores/{id}`
- `POST /sensores/simular/{id}`

---

## 💧 Reservatórios

- `GET /reservatorios`
- `GET /reservatorios/{id}`
- `POST /reservatorios`
- `PUT /reservatorios/{id}`
- `DELETE /reservatorios/{id}`
- `POST /reservatorios/simular/{id}`

---

## 🌡️ Climatização

- `GET /climatizacao`
- `GET /climatizacao/{id}`
- `POST /climatizacao`
- `PUT /climatizacao/{id}`
- `DELETE /climatizacao/{id}`
- `POST /climatizacao/simular/{id}`

---

## 🚨 Alertas

- `GET /alertas`
- `GET /alertas/{id}`
- `POST /alertas`
- `PUT /alertas/{id}`
- `DELETE /alertas/{id}`

---

## 👨‍🚀 Tripulantes

- `GET /tripulantes`
- `GET /tripulantes/{id}`
- `POST /tripulantes`
- `PUT /tripulantes/{id}`
- `DELETE /tripulantes/{id}`

---

## ⚡ Consumo de Energia

- `GET /consumo-energia`
- `GET /consumo-energia/{id}`
- `POST /consumo-energia`
- `PUT /consumo-energia/{id}`
- `DELETE /consumo-energia/{id}`

---

## 💾 Banco de Dados H2

O projeto utiliza o **H2 Database** em modo persistente (`file mode`), permitindo que os dados continuem salvos mesmo após reiniciar a aplicação.

### Configuração utilizada

```properties
spring.datasource.url=jdbc:h2:file:./database/spaceconnect
spring.datasource.username=admin
spring.datasource.password=admin




