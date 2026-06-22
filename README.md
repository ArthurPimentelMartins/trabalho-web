# Sistema Web de Controle de Estoque e Vendas

## Sobre o Projeto

Este projeto consiste em um sistema web desenvolvido para gerenciamento de estoque e vendas, permitindo o controle de clientes, produtos, usuários e operações de venda. A aplicação foi construída utilizando a arquitetura MVC (Model-View-Controller), proporcionando organização, manutenção facilitada e separação de responsabilidades entre as camadas do sistema.

## Funcionalidades

* Autenticação de usuários (Login e Controle de Sessão)
* Cadastro, consulta, edição e exclusão de clientes
* Cadastro, consulta, edição e exclusão de produtos
* Cadastro, consulta, edição e exclusão de usuários
* Cadastro, consulta, edição e exclusão de vendas
* Controle de acesso às páginas por meio de filtro de segurança
* Persistência de dados em banco de dados MySQL

## Tecnologias Utilizadas

* Java
* JSP (Java Server Pages)
* Servlets
* JDBC
* MySQL
* Maven
* HTML/CSS

## Arquitetura

O sistema segue o padrão MVC:

* **Model:** Responsável pelas entidades, regras de negócio e acesso aos dados.
* **View:** Composta pelas páginas JSP responsáveis pela interface com o usuário.
* **Controller:** Implementado por meio de Servlets que recebem e processam as requisições.

Fluxo da aplicação:

Usuário → JSP → Servlet → Service → DAO → Banco de Dados

## Banco de Dados

A aplicação utiliza o MySQL para armazenamento das informações, realizando operações de CRUD (Create, Read, Update e Delete) para todas as entidades do sistema.

## Objetivo

O principal objetivo deste projeto é aplicar conceitos de desenvolvimento web com Java, utilizando boas práticas de programação, arquitetura MVC, integração com banco de dados e controle de acesso, simulando um ambiente real de gestão de estoque e vendas.

