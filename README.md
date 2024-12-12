Uma aplicação java que permite cadastrar treinadores e gerenciar dados de Pokémon encontrados. Utiliza JavaFX para a interface gráfica, JDBC para persistência de dados em um banco PostgreSQL, e RabbitMQ para comunicação assíncrona entre os produtores e consumidores.

Funcionalidades
	•	Cadastro de Treinadores e de Pokémons
	•	Exibições de cadastros em TableView.
	•	Integração com banco de dados PostgreSQL.
	•	Comunicação assíncrona com RabbitMQ:
	•	Produtor: Envia mensagens para uma fila sempre que um treinador é cadastrado.
	•	Consumidor: Processa mensagens da fila RabbitMQ.

Tecnologias Utilizadas
	•	JavaFX: Interface gráfica.
	•	PostgreSQL: Banco de dados.
	•	RabbitMQ: Mensageria.
	•	JDBC: Acesso ao banco de dados.
	•	Maven: Gerenciamento de dependências.

Configuração do Ambiente
	1.	Pré-requisitos:
	•	Java 17 ou superior.
	•	Maven.
	•	PostgreSQL configurado com a seguinte tabela: