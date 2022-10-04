Implementação de API RESTful para publicação e leitura de arquivos feita em java spring-boot.

Funcionalidades:
	-Login de usuário
		-Cadastramento, login, perfil
	-Publicar artigo em um campo
		-Um ou mais campos
	-Comentar um artigo
	-Pesquisar artigos por campo
	-Avaliar artigo

Entidades:
	-Usuário
	-Artigo
	-Campo
	-Comentário
  
Organização:
  -Controller: exposição dos endpoints REST. 
  -DTO: entidades para conversão que não foram utilizadas até o momento.
  -Repository: Interface para banco de dados com JPA.
  -Service: Interfaces para a camada de regras da aplicação
      -Impl: Implementação das interfaces.
      
 Outros arquivos importantes:
  application.properties: Configuração do projeto
  pom.xml: Configuração maven do projeto.
  ArtigosApplication.java: Arquivo principal e ativação do cashing
