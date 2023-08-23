# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173164615-192ca98a-1a44-480e-9229-9f82f456eec8.png">

</p>

---
##  Primeiros Passos:

#### 🔹 Marque esse projeto com uma ⭐
#### 🔹 Siga as orientações do que temos neste repositório 📚
#### 🔹 Visite a página do desafio clicando aqui! [Link do Challenge](https://www.alura.com.br/challenges/oracle-one-back-end/hotelalura) 📃 
</br>

---
## 🖥️ Tecnologias Utilizadas:

- Java
- Eclipse
- MySql
- Biblioteca JCalendar
- Plugin WindowBuilder </br>
</br>

---
## Api Hotel Alura:

- Pasta de Controllers com três controllers, de usuário, de reserva e de hospede, onde é injetada a concecção do banco de dados e injetado os DAOs necessários para realização do CRUD.
- Pasta Donain com as pastas DAO e Model.
- Pasta DAO com os DAOs, de usuário, de reserva e de hospede, onde é feita a manipulação dos bancos de dados necessários.
- Pasta Model com as entidades, de usuário, de reserva e de hospede, que serviram de modelo para a manipulação dos dados.
- Pasta Connection com a conecção do MySql.
- Pasta Views com as Telas da Api. </br>
</br>

---
## 💻 Tela Inicial:

- Botão de login que ao ser clicado leva à janela de login.
- Botão Sair que pergunta ao usuário se ele realmente deseja sair do aplicativo. </br>
</br>

---
## 💻 Tela Login:

- Botão Entrar que verifica no banco de dados se o login existe e se a senha corresponde com a cadastrada. em seguida abre a Tela Menu Usuário.</br>
</br>

---
## 💻 Tela Menu Usuário:

- Botão Reserva que ao ser clicado vai para a Tela de Reservas.
- Botão Buscar que ao ser clicado leva para a Tela de Busca.
- Botão Sair que ao ser clicado volta para a Tela de Login.</br>
</br>

---
## 💻 Tela Resevas:

- Formulário com os campos, data de chegada, data de saida, valor e um select com opçoes de forma de pagamentos.
- Todos os Campos precisam ser preechidos para realizar o cadastro da Reserva.
- Campo data de chegada não pode ser inferior a data atual nem posterior a data de saida.
- o Valor da diaria está fixado a 100,00 e serar gerado automaticamente.
- Botão continuar faz a validação dos dados depois realiza o cadastro no banco de dados.
- Botão continuar também abre a tela Hospedes enviando o id da reserva.</br>
</br>

---
## 💻 Tela Hospedes:

- Formulário com os campos, nome, sobrenome, data de nascimento, nacionalidade, telefone e o identificador que foi fornecido na tela anterior.
- Todos os Campos precisam ser preechidos para realizar o cadastro do Hospede.
- Botão salvar faz a validação dos dados depois realiza o cadastro no banco de dados.
- Botão salvar também manda o usuário para a tema Menu Usuário. </br>
</br>

---
## 💻 Tela Busca:

- Possui duas Tabelas que inicialmente lista todos os Hopedes e todas as Resevas do banco de dados.
- Botão Buscar busca todos os hospedes pelo sobrenome e depois listas suas resevas em conjunto.
- Botão Editar faz a verificação dos dados e alterar um hospede ou uma reseva selecionada.
- Botão Deletar apaga um hospede ou reserva selecionado por seu indentificador.</br>
</br>

---