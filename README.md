<div align="center">

# Clinic Management API

API REST para gerenciamento completo de clínicas e consultórios médicos.

<br/>

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=flat-square&logo=flyway&logoColor=white)
![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow?style=flat-square)

</div>

---

## Sobre o Projeto

A **Clinic Management API** é uma solução backend voltada para a gestão de clínicas e consultórios. O sistema centraliza o cadastro de médicos e pacientes, o agendamento de consultas e, futuramente, integraração com WhatsApp e geração de chaves Pix para pagamentos.

---

## Funcionalidades

#### Implementadas

- [x] CRUD completo de **médicos** e **pacientes**
- [x] Validação de **CPF** (`@CPF` via Hibernate Validator) e **CRM** (formato `0000-UF` via `@Pattern`)
- [x] Gestão de **endereços** e **especialidades médicas**
- [x] Controle de migrações com **Flyway**

#### Roadmap

- [ ] Agendamento e gerenciamento de **consultas**
- [ ] **Integração com WhatsApp** — pré-cadastro de pacientes via bot
- [ ] **Pagamentos via Pix** — geração de cobrança e webhook de confirmação
- [ ] **Relatórios em PDF** — consultas, histórico do paciente e financeiro
- [ ] Acesso a relatórios pelo WhatsApp
- [ ] Migração do banco de dados para **PostgreSQL**

---

## Endpoints

### `Médicos`

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/medicos` | Cadastrar novo médico |
| `GET` | `/medicos` | Listar médicos ativos |
| `PUT` | `/medicos/{id}` | Atualizar dados do médico |

<details>
<summary><strong>POST</strong> /medicos — exemplo de requisição</summary>
<br/>

```json
{
  "nome": "Dr. João Silva",
  "email": "joao.silva@clinica.com",
  "crm": "1234-ES",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": "100",
    "bairro": "Centro",
    "cidade": "Vitória",
    "uf": "ES",
    "complemento": "Sala 5",
    "cep": "29000000"
  }
}
```

</details>

<br/>

### `Pacientes`

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/pacientes` | Cadastrar novo paciente |
| `GET` | `/pacientes` | Listar pacientes ativos |
| `PUT` | `/pacientes/{id}` | Atualizar dados do paciente |

<details>
<summary><strong>POST</strong> /pacientes — exemplo de requisição</summary>
<br/>

```json
{
  "nome": "Maria Oliveira",
  "email": "maria.oliveira@email.com",
  "telefone": "27999999999",
  "cpf": "12345678909",
  "endereco": {
    "logradouro": "Av. Brasil",
    "numero": "250",
    "bairro": "Jardim América",
    "cidade": "Vila Velha",
    "uf": "ES",
    "complemento": "Apto 16",
    "cep": "29100000"
  }
}
```

</details>

</details>

---

## Como Rodar Localmente

### Pré-requisitos

- [Java 21+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)

### Passo a passo

**1. Clone o repositório**

```bash
git clone https://github.com/mateusalvescosta/clinic-management-api.git
cd clinic-management-api
```

**2. Crie o banco de dados**

```sql
CREATE DATABASE clinic_management;
```

**3. Configure o `application.properties`**

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Preencha com suas credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinic_management
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```

**4. Execute a aplicação**

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## Tecnologias

| Tecnologia | Descrição |
|------------|-----------|
| Java 21 | Linguagem principal |
| Spring Boot | Framework backend |
| Spring Data JPA | Persistência de dados |
| Hibernate Validator | Validação de CPF, CRM, e-mail e telefone |
| Flyway | Controle de migrações do banco |
| MySQL | Banco de dados *(migração para PostgreSQL planejada)* |
| Maven | Gerenciamento de dependências |

---

## Estrutura do Projeto

O projeto está atualmente organizado por camada técnica, com migração planejada para arquitetura por domínio.

<details>
<summary>Estrutura atual — por camada</summary>
<br/>

```
src/main/java/com/mateusalvescosta/clinic_management_api/
├── controller/
│   ├── MedicoController.java
│   └── PacienteController.java
├── dto/
│   ├── request/
│   │   ├── CreateEnderecoRequest.java
│   │   ├── CreateMedicoRequest.java
│   │   ├── CreatePacienteRequest.java
│   │   ├── UpdateEnderecoRequest.java
│   │   ├── UpdateMedicoRequest.java
│   │   └── UpdatePacienteRequest.java
│   └── response/
│       ├── EnderecoSummaryResponse.java
│       ├── MedicoSummaryResponse.java
│       └── PacienteSummaryResponse.java
├── enumeration/
│   └── Especialidade.java
├── model/
│   ├── Endereco.java
│   ├── Medico.java
│   └── Paciente.java
├── repository/
│   ├── MedicoRepository.java
│   └── PacienteRepository.java
├── service/
│   ├── MedicoService.java
│   └── PacienteService.java
└── ClinicManagementApplication.java

src/main/resources/
├── db/migration/
│   ├── V1__create-table-medicos.sql
│   └── V2__create-table-pacientes.sql
├── application.properties.example
└── application.properties        ← não versionado
```

</details>

<details>
<summary>Estrutura planejada — por domínio</summary>
<br/>

```
src/main/java/com/mateusalvescosta/clinic_management_api/
├── medico/
│   ├── Medico.java
│   ├── MedicoController.java
│   ├── MedicoService.java
│   ├── MedicoRepository.java
│   ├── Especialidade.java
│   └── dto/
│       ├── CreateMedicoRequest.java
│       ├── UpdateMedicoRequest.java
│       └── MedicoSummaryResponse.java
├── paciente/
│   ├── Paciente.java
│   ├── PacienteController.java
│   ├── PacienteService.java
│   ├── PacienteRepository.java
│   └── dto/
│       ├── CreatePacienteRequest.java
│       ├── UpdatePacienteRequest.java
│       └── PacienteSummaryResponse.java
├── endereco/
│   ├── Endereco.java
│   └── dto/
│       ├── CreateEnderecoRequest.java
│       └── UpdateEnderecoRequest.java
├── consulta/              ← em breve
├── pagamento/             ← em breve
└── ClinicManagementApplication.java
```

</details>

---

## Autor

Feito por **Mateus Alves Costa**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat-square&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mateusalvescosta/)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=flat-square&logo=whatsapp&logoColor=white)](https://wa.me/5527999899995)
