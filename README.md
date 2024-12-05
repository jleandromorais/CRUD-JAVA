
# 📘 Projeto de Cadastro Escolar 🏫

---

## 📋 **Sobre o Projeto**
Este projeto é um sistema de cadastro escolar desenvolvido em **Java** com integração ao banco de dados **MySQL**. Ele permite gerenciar alunos e professores, oferecendo funcionalidades para cadastrar, atualizar, remover e visualizar registros. 

---

## 🚀 **Funcionalidades**

### 👩‍🎓 **Alunos**
- 📌 Cadastrar Aluno
- 📝 Atualizar Aluno
- ❌ Remover Aluno
- 📂 Visualizar Todos os Alunos
- 🎓 Calcular Média Geral dos Alunos

### 👨‍🏫 **Professores**
- 📌 Cadastrar Professor
- 📝 Atualizar Professor
- ❌ Remover Professor
- 📂 Visualizar Todos os Professores
- 💰 Alterar Salário do Professor

---

## 🛠️ **Tecnologias Utilizadas**
- **Java** ☕
- **MySQL** 🗄️

---

## ⚙️ **Pré-requisitos**
Antes de começar, você precisará ter as seguintes ferramentas instaladas em seu computador:
- **Java 8** ou superior
- **MySQL Server**
- **IDE** para desenvolvimento em Java (como IntelliJ, Eclipse, ou VSCode)

---

## ▶️ **Como Executar o Projeto**

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-projeto.git
   ```

2. **Abra o projeto na sua IDE favorita.**

3. **Configure o banco de dados**:
   - Crie um banco no MySQL.
   - Atualize as configurações no arquivo `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://127.0.0.1:3306/seu_banco
     spring.datasource.username=root
     spring.datasource.password=1+1 #Geografia123 1+1
     ```

4. **Execute a classe principal**:
   - Encontre a classe `Aplicacao.java` no pacote `src/main/java/com/escola/`.
   - Execute a aplicação clicando no botão de **Run** da IDE.

---

## 📝 **Estrutura do Projeto**
```
src/
 ├── main/
 │   ├── java/
 │   │   └── com/
 │   │       └── escola/
 │   │           ├── controller/     # Controladores
 │   │           ├── model/           # Modelos (Entidades)
 │   │           ├── repository/      # Repositórios (acesso ao BD)
 │   │           └── service/         # Regras de Negócio
 │   └── resources/
 │       └── application.properties   # Configurações do BD
 └── test/
     └── java/
         └── com/escola/              # Testes Unitários
```

---

## 🎉 **Contribuições**
Fique à vontade para contribuir! Sugestões e melhorias são sempre bem-vindas. 😊

---

## 📜 **Licença**
Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais informações.

---

## 🧑‍💻 **Desenvolvedor**
**Leandro Morais**  
[LinkedIn](www.linkedin.com/in/leandro-morais-luz) | [GitHub](jleandromorais)

---

🚀 **Bons estudos e desenvolvimento!** 👨‍🎓👩‍💻
