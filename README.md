# API-Ecommerce-StarStore

A StarStore é uma API REST da loja de Star Wars para realizar transações e-commerce. Nela os usuários poderão se cadastrar, comprar produtos de sua preferência utilizando cartão de crédito e verificar seu histórico de compra. 

Este projeto foi desenvolvido de acordo com as especificações deste [link](https://docs.google.com/document/d/1p6N-VP1GoxnDoOfu1OxrgsuQsKF0ztR9WdGGkm2yGuE/edit?usp=sharing), como entrega final do minicurso de Rests-Api.

## Instalação

Para ter acesso a API basta clonar o repositório:

```sh
git clone https://github.com/joanasoaresd/API-Ecommerce-StarStore.git
```
Após clonar, você pode entrar no projeto pela sua IDE(eclipse, intelliJ..) e executar com o run StarstoreApplication.

## Módulos
O projeto foi divido em quatro módulos, sendo estes 'users', 'payments', 'products', 'cart', cada um contendo os relacionamentos de acordo com suas especificações. 

### Users

O Módulo de usuários possui os métodos de login, criar usuários, buscar usuários especifico(por id), atualizar os dados do seu perfil e listar todos usuários. Dessa forma, o usuário pode se autenticar para ter acesso aos recursos oferecidos pela API e/ou atualizar seus dados de cadastro. O administrador, por sua vez, pode listar todos os usuários e/ou procurar um usuário especifico.

### Payments

O Módulo de pagamentos possui os métodos de realizar pagamento, listar todos os pagamentos e pegar um pagamento de um cliente especifico(por idCliente). Dessa forma, o usuário autenticado poderá realizar pagamentos e encontrar o pagamento que por ele foi realizado, já o administrador poderá listar todos os pagamentos realizados pelos usuários.

### Products

O Módulo de produtos possui os métodos de listar todos os produtos, criar produto e pegar um produto especifico (por id). Dessa forma, o usuário poderá ter acesso a lista de produtos e pegar um produto especifico, além de ter acesso a cadastrar um produto.

### ~~Cart~~ Order

O Módulo de carrinho, que na verdade ficou definido como de pedidos(por questões de desenvolvimento) está em andamento e não foi possível entregar no prazo do projeto. Order é dividido em duas entidades sendo estas, 'ItemOrder' onde fica o item referente a quantidade do seu pedido e 'Order' onde ficam os dados da compra.

## Swagger

Com o Swagger você pode ter acesso a documentação da API Starstore, a partir do link: [Swagger](https://joanasoaresd.github.io/API-Ecommerce-StarStore/)


## Equipe

#### Clebson Augusto fonseca 
:email: clebson.augusto@dcx.ufpb.br
:octocat: [GitHub](http://github.com/clebsonf)
:link: [LinkedIn](https://www.linkedin.com/in/fclebson/)

#### Joana Darck Soares Da Silva 
:email: joana.darck@dcx.ufpb.br
:octocat: [GitHub](http://github.com/joanasoaresd)
:link: [LinkedIn](https://www.linkedin.com/in/joanasoaresd/)
