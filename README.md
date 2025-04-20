# 📝 To-Do List API

Essa é uma API REST de lista de tarefas (**To-Do List**) desenvolvida com **Spring Boot**, onde é possível **criar, listar, atualizar e deletar tarefas**, com controle de status e datas importantes.

Ideal para praticar os fundamentos de **CRUD**, mapeamento com **JPA/Hibernate**, e design de APIs limpas.

---

## 🚀 Funcionalidades

- ✅ **Cadastrar tarefa**
- 📄 **Listar todas as tarefas**
- 🛠️ **Atualizar título, descrição, status ou data de conclusão**
- 🗑️ **Deletar tarefa**
- 📅 Armazena **data de criação automática** e **data de conclusão opcional**
- 📌 Controle de status com `ENUM`:
  - `PENDENTE`
  - `EM_ANDAMENTO`
  - `CONCLUIDA`

---

## 🔧 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Hibernate
- Insomnia para testes de requisições

---

## 🛠️ Como rodar o projeto localmente

1. Clone o repositório:
```bash
git clone https://github.com/cosmotxt/to-do-list-springboot.git
```

2. Crie um banco MySQL com o nome `to_do_list` e configure seu `application.yml`:

```yaml
spring:
  application:
    name: To-do-List
app:
  datasource:
    url: jdbc:mysql://localhost:3306/to_do_list
    username: root
    password: sua_senha
```

3. Rode o projeto com sua IDE

4. A API estará disponível em:  
`http://localhost:8080`

---

## 📁 Estrutura da API

| Método | Rota         | Descrição                     |
|--------|--------------|-------------------------------|
| GET    | /tasks       | Lista todas as tarefas        |
| POST   | /tasks       | Cria uma nova tarefa          |
| PUT    | /tasks       | Atualiza uma tarefa existente |
| DELETE | /tasks/{id}  | Deleta uma tarefa             |

---

## 📦 Exemplo de JSON para criar uma tarefa

```json
{
  "titulo": "Arrumar o quarto",
  "descricao": "Lembrar de botar as roupas pra lavar",
  "status": "PENDENTE",
  "dataConclusao": null
}
```

---

## 🧠 Lógica extra

- A **data de criação** (`dataCriacao`) é definida automaticamente com `LocalDateTime.now()` no momento da criação.
- A **data de conclusão** por padrão será enviada como `null`, mas quando o status for atualizado para "CONCLUIDA", a data de conclusão será automaticamente configurada.
- O campo `status` só aceita valores válidos do `enum` (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`).
- O sistema trata erros de forma amigável com validação e exceções personalizadas.

---

## ✨ Autor

Feito com 💻 e ☕ por **Reni** —  
Projeto desenvolvido como exercício pessoal