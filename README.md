# Inventory-IT

Sistema web para gestão e alocação de equipamentos de TI em laboratórios.

## 🛠️ Tecnologias Utilizadas
* **Java 17+**
* **Jakarta Servlets & JSP**
* **JPA / Hibernate**
* **Banco de Dados H2** (Em memória)
* **Bootstrap 5** (Interface)

## 📌 Funcionalidades
* Mapeamento relacional `@ManyToOne` entre Equipamento e Laboratório.
* Cadastro de equipamentos com vinculação direta a laboratórios ativos.
* Listagem dinâmica utilizando JSTL (`<c:forEach>`) e componentes Bootstrap.

## 🚀 Como Executar
1. Importe o projeto no Eclipse.
2. Configure o servidor **Apache Tomcat 10+**.
3. Execute o projeto no servidor e acesse: `http://localhost:8080/inventory-it/novoEquipamento`
