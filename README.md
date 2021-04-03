# desafioAZ
Desafio pela Empresa AZ

Para subir as duas aplicações é recomendavel que se utilize os programas Eclipse(recomendavel) para a api e o Visual Studio Code(recomendavel) para o app.
Também é necessário estar instalado o git no computador para baixar o projeto todo.

# Baixando o projeto
Para baixar o projeto basta rodar o comando no terminal em uma pasta:
  git clone https://github.com/DanielFeeney/desafioAZ.git
Após entrar na pasta do projeto, abra o terminal novamente e rode o comando:
  git init
E troque para branch desafio_Daniel_Feeney através do comando:
  git checkout desafio_Daniel_Feeney
  
# Rodando a api no Eclipse
Abra o Eclipse e escolha a pasta do projeto, desafioAZ, para ser a workspace.
Importe o projeto desafio-api para dentro do eclipse como maven. Caso o importe não funcione, crie um novo projeto java vazio de mesmo nome, clique com o botão direito no projeto e converta-o para maven.
Caso der erro no Java, clique com o botão direito no projeto e vá para o build path e clique no configure build path para abrir a janela de cofiguração. Selecione a biblioteca Java com erro e clique no botão edit ao lado direito. Escolha a biblioteca JavaSE-1.8(jdk1.8.0_191)(recomendável) e finaliza. Aplique as alterações e salve.
Clique com o botão direito no projeto e selecione a opção Run As e selecione Spring Boot App para rodar a aplicação. 
Ela irá rodar na porta 8081, a porta 8080 foi reservada para o App

# Rodando o app no Visual Studio Code
Abra o VS Code e selecione a pasta desafio-app para abrir.
Abra um novo terminal e digite o comando para baixar o node modules:
  npm install --save
Depois de baixado, rode o comando para rodar a aplicação:
  npm run server
Por padrão ele irá rodar na porta 8080, a porta 8081 esta reservada para a api.
