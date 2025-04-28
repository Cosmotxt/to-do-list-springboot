
# 📝 To-Do List API

Essa é uma API REST de lista de tarefas (**To-Do List**) desenvolvida com **Spring Boot**, onde é possível **criar, listar, atualizar e deletar tarefas**, com controle de status e datas importantes. O projeto também inclui **medidas de segurança**, utilizando o **Spring Security** e **JWT** para autenticação e autorização dos usuários.

Usei esse projeto para treinar os conceitos de CRUD e Spring Security.

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
- 🔒 **Segurança com JWT**: A API requer um token JWT válido para acessar as funcionalidades, garantindo que apenas usuários autenticados possam realizar operações de CRUD.

---

## 🔧 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
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

3. Configure o **Spring Security** para autenticação JWT. Certifique-se de incluir as dependências e configurações necessárias para gerar e validar o token JWT no projeto.

4. Rode o projeto com sua IDE

5. A API estará disponível em:  
   `http://localhost:8080`

---

## 📁 Estrutura da API

| Método | Rota         | Descrição                                |
|--------|--------------|------------------------------------------|
| GET    | /tasks       | Lista todas as tarefas (somente usuários autenticados) |
| POST   | /tasks       | Cria uma nova tarefa (somente usuários autenticados) |
| PUT    | /tasks       | Atualiza uma tarefa existente (somente usuários autenticados) |
| DELETE | /tasks/{id}  | Deleta uma tarefa (somente usuários autenticados) |
| POST   | /auth/login  | Realiza o login do usuário e gera um token JWT |

---

## 🔒 Autenticação e Segurança

- A autenticação é realizada utilizando **JWT**. Para acessar as funcionalidades da API, o usuário deve primeiro autenticar-se com a rota `/auth/login` fornecendo suas credenciais (usuário e senha).
- Após o login bem-sucedido, o usuário recebe um token JWT que deve ser incluído no cabeçalho de todas as requisições subsequentes.
- O Spring Security intercepta as requisições e valida o token JWT antes de permitir o acesso aos endpoints protegidos.

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
- **Segurança**: As rotas de CRUD (criação, leitura, atualização e exclusão de tarefas) estão protegidas por autenticação JWT. Para obter um token JWT, o usuário deve realizar o login na rota `/auth/login`.

---

## ✨ Autor

Feito com 💻 e ☕ por **Reni** —  
Projeto desenvolvido como exercício pessoal