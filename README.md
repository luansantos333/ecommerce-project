# Sistema de E-commerce

Este projeto é um sistema de e-commerce que permite o gerenciamento de usuários, produtos e pedidos. O sistema oferece funcionalidades para navegação em um catálogo de produtos, gerenciamento de carrinho de compras, e registro de pedidos.

## Funcionalidades

### Cadastro de Usuários

- **Usuários**: Cada usuário possui os seguintes dados:
  - Nome
  - Email
  - Telefone
  - Data de nascimento
  - Senha de acesso

- **Tipos de Usuário**:
  - **Cliente**: Usuário padrão com acesso ao catálogo de produtos e ao carrinho de compras.
  - **Administrador**: Usuário com acesso à área administrativa para gerenciar usuários, produtos e categorias.

- **Cadastro e Navegação**:
  - Usuários não identificados podem se cadastrar no sistema, navegar no catálogo de produtos e no carrinho de compras.
  - Clientes podem atualizar seu cadastro, registrar pedidos e visualizar seus próprios pedidos.

### Cadastro de Produtos

- **Produtos**: Cada produto possui os seguintes dados:
  - Nome
  - Descrição
  - Preço
  - Imagem

- **Catálogo de Produtos**:
  - Os produtos são apresentados em um catálogo filtrável pelo nome do produto.
  - Detalhes do produto estão disponíveis para visualização.

### Carrinho de Compras

- **Gerenciamento do Carrinho**:
  - Adicione e remova itens do carrinho de compras.
  - Altere as quantidades de cada item no carrinho.

### Pedidos

- **Registro de Pedidos**:
  - Ao encerrar o pedido, ele é salvo no sistema com o status "aguardando pagamento".
  - Dados do pedido:
    - Instante em que foi salvo
    - Status do pedido
    - Lista de itens, incluindo produto e quantidade

- **Status do Pedido**:
  - Aguardando pagamento
  - Pago
  - Enviado
  - Entregue
  - Cancelado

- **Pagamento**:
  - O instante do pagamento é registrado quando o pedido é pago.

### Área Administrativa

- **Funcionalidades para Administradores**:
  - Acesso ao cadastro e gerenciamento de usuários.
  - Acesso ao cadastro e gerenciamento de produtos.
  - Acesso ao cadastro e gerenciamento de categorias.

## Tecnologias Utilizadas

- [Insira aqui as tecnologias e ferramentas utilizadas, como Java, Spring Boot, Hibernate, etc.]

## Instruções para Instalação

1. Clone o repositório:

   ```
   git clone https://github.com/usuario/repo.git

    Navegue até o diretório do projeto:
    cd nome-do-projeto

Configure o ambiente (insira detalhes sobre configuração de banco de dados, variáveis de ambiente, etc.).

Compile e execute o projeto:

bash

    mvn install
    mvn spring-boot:run

