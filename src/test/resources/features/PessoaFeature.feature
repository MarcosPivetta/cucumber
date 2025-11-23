# language: pt
Funcionalidade: Pessoa recurso de teste
# Esse arquivo contem os cenarios de teste para o recurso Pessoa
# Para esse não precisamos de uma conexão de banco de dados para armazenar e encontrar pessoas.
# As pessoas gerenciadas precisam ser armazenadas na memoria.

  #Primeiro cenario para inicializar uma lista de pessoas
  Cenario: Inicializar uma lista de pessoas
    Dado que eu tenho um metodo estatico que inicializa uma lista de pessoas
    Quando eu conecto posso ver o tanho da lista inicializada de pessoas
    Entao o tamanho da lista e igual a 3

  # Criar uma nova pessoa com entradas aleatorias
  Cenario: Criar uma nova pessoa
    Dado a lista de pessoas contendo 3 pessoas ja armazenadas
    Quando eu crio uma nova pessoa com entradas aleatorias
    Entao obtenho o ID da nova pessoa e a lista contem mais que 3 pessoas

  # Criar uma criacao em massa de pessoas
  Esquema do Cenario: Criar uma lista de  pessoas
    Dado a lista de pessoas contendo 3 pessoas ja armazenadas
    Quando eu crio uma nova pessoa com nome <nome>, sobrenome <sobrenome>, e idade <idade>
    Entao eu obtenho o ID da nova pessoa e a lista contem mais que 3 pessoas

    Exemplos:
      | nome   | sobrenome | idade |
      | Carlos | Silva     | 28    |
      | Ana    | Souza     | 34    |
      | Pedro  | Oliveira  | 22    |

  # Atualizar uma pessoa existente
  Esquema do Cenario: Atualizar uma pessoa por ID
    Dado a lista de pessoas contendo 3 pessoas ja armazenadas
    Quando eu atualizo uma pessoa com <id> and <nome> and <sobrenome> and <idade>
    Entao eu obtenho a pessoa atualizada

    Exemplos:
      | id | nome    | sobrenome | idade |
      | 1  | Carlos  | Silva     | 30    |
      | 2  | Ana     | Souza     | 25    |
      | 3  | Pedro   | Oliveira  | 27    |

  # Deletar uma pessoa existente
  Cenario: Deletar uma pessoa
    Dado a lista de pessoas contendo 3 pessoas ja armazenadas
    Quando eu removo uma pessoa com id 1
    Entao a pessoa com id fornecido e removida da lista e o tamanho da lista e 2