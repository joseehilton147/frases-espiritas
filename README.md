# 🕊️ Frases Espíritas

Este projeto é uma aplicação fullstack que exibe frases espíritas de forma aleatória. O backend foi desenvolvido em **Spring Boot** e o frontend em **Next.js**, permitindo um carregamento rápido e eficiente das frases.

---

## 📌 Estrutura do Projeto

O projeto está organizado da seguinte maneira:

```
frases-espiritas/
│── backend/        # Backend desenvolvido em Spring Boot
│── frontend/       # Frontend desenvolvido em Next.js
│── .gitignore      # Arquivos ignorados pelo Git
│── README.md       # Documentação do projeto
│── docker-compose.yml  # Para rodar tudo junto via Docker
```

### **📂 Backend (`/backend`)**
**Tecnologias:**
- Java 17
- Spring Boot 3.4.2
- PostgreSQL
- Flyway (migrações do banco de dados)
- JPA/Hibernate
- Lombok

**Principais arquivos e pastas:**
- `src/main/java/com/jh/frasesespiritas/` → Código-fonte do backend
- `src/main/resources/application.properties` → Configuração do banco de dados
- `src/main/resources/db/migration/` → Arquivos de migração do Flyway
- `target/` → Pasta gerada após o build da aplicação


### **📂 Frontend (`/frontend`)**
**Tecnologias:**
- Next.js 14 (React)
- TypeScript
- Tailwind CSS
- Axios (para chamadas HTTP)

**Principais arquivos e pastas:**
- `src/app/page.tsx` → Página principal da aplicação
- `src/app/layout.tsx` → Layout global da aplicação
- `src/api/frases.ts` → Funções para consumir a API do backend
- `.next/` → Pasta gerada após o build do frontend

---

## 🛠️ Como Rodar o Projeto Localmente

### **🔹 Pré-requisitos**
Antes de começar, certifique-se de ter instalado:
- **Docker e Docker Compose** (para rodar tudo junto)
- **Java 17**
- **Node.js** (recomendado via `Volta`)
- **PostgreSQL** (caso queira rodar localmente sem Docker)
- **Maven**

### **🔹 Rodando com Docker (Recomendado)**
Se quiser rodar tudo com **Docker**, basta executar:

```sh
docker-compose up --build
```

Isso iniciará o **backend, frontend e banco de dados juntos**.

Para parar os containers:

```sh
docker-compose down
```

Caso queira resetar o banco de dados e subir tudo novamente:

```sh
docker-compose down -v
docker-compose up --build
```

---

## 🛠️ Endpoints da API
O backend fornece os seguintes endpoints REST:

| Método | Rota | Descrição |
|--------|------|------------|
| `GET` | `/frases/aleatoria` | Retorna uma frase aleatória |
| `POST` | `/frases` | Adiciona novas frases |
| `GET` | `/frases/pendentes` | Lista frases pendentes de aprovação |
| `PUT` | `/frases/{id}/aprovar` | Aprova uma frase pelo ID |
| `PUT` | `/frases/{id}/reprovar` | Reprova uma frase pelo ID |

---

## 🎨 Interface do Usuário
A interface foi inspirada no estilo minimalista de **shouldideploytoday.com**, exibindo apenas a frase e sua autoria. O usuário pode **clicar, pressionar Enter ou Espaço** para carregar uma nova frase.

**Personalizações:**
- Fundo azul (`bg-blue-400`)
- Fonte `Geist` + `Nunito`
- Texto centralizado, estilo de citação

---

## 📜 Licença
Este projeto está licenciado sob a **MIT License** – sinta-se livre para usá-lo e contribuir!

---

## 🤝 Contribuições
Se quiser contribuir, sinta-se à vontade para abrir um **Pull Request** ou relatar um **issue**!

Feito com 💙 por [@joseehilton147](https://github.com/joseehilton147) 🚀
