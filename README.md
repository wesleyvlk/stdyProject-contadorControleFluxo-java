# ContadorControleFluxo

Este é um repositório com dois projetos Java, ambos utilizam o padrão arquitetural MVC (Model-View-Controller) e o
padrão de projeto Singleton.

## CounterChallenge

O projeto **CounterChallenge** está localizado no pacote `com.dio.counterchallenge` e implementa uma contagem, onde é
solicitado que o usuário insira dois parâmetros e, em seguida, imprima todos os números inteiros entre eles.

A classe `CounterController` implementa a interface `CounterModel`. O método `counterView()` é o ponto de entrada para o
programa, onde o usuário é solicitado a inserir dois parâmetros e, em seguida, é chamado o método `counter()` para
imprimir a contagem.

O método `counter()` recebe os dois parâmetros e verifica se eles são válidos, lançando uma exceção
personalizada `InvalidParametersException` se não forem. Se os parâmetros forem válidos, é criado um
objeto `CounterFunction` que é uma interface funcional para contar os números entre os parâmetros. Em seguida, é chamado
o método `applyCount()` da interface, que retorna o número total de contagens. Por fim, um loop é implementado usando a
classe `IntStream` da biblioteca padrão do Java, que é usada para gerar uma sequência de inteiros entre `1` e `count` (
calculado como `parameterTwo - parameterOne`). O método `forEach()` da classe `IntStream` é usado para imprimir cada
número na sequência, formatando-o com a mensagem "Imprimindo o número: ".

## SelectionProcess

O projeto **SelectionProcess** está localizado no pacote `com.dio.selectionprocess` e é uma implementação simulada de um
processo seletivo de candidatos para preencher algumas vagas de emprego. Ele contém duas classes: `SelectionController`
e `SelectionView`.

A classe `SelectionController` contém a lógica do processo de seleção e implementa a interface `SelectionModel`. Ela
cria uma lista de candidatos com nomes pré-definidos e salários aleatórios. A classe também contém métodos para avaliar
o salário pretendido de um candidato, selecionar os candidatos mais adequados para as vagas disponíveis, mostrar os
candidatos selecionados e ligar para os candidatos selecionados.

A classe `SelectionView` é responsável por iniciar o processo de seleção, chamando os métodos apropriados da
classe `SelectionController`. No método `processSelection()`, são realizados quatro casos diferentes: avaliar o salário
pretendido de três candidatos aleatórios, selecionar os candidatos mais adequados, mostrar os candidatos selecionados e
ligar para os candidatos selecionados.

O processo de seleção em si é baseado em uma comparação entre o salário pretendido de cada candidato e um salário base
predefinido. Os candidatos com salários mais baixos que o salário base são considerados selecionados. Depois de
selecionados, os candidatos são contatados para confirmar sua disponibilidade e interesse na vaga.

## Como executar o código

Para executar os projetos Java, é necessário ter o JDK 8 ou superior instalado. Ambos os projetos possuem suas
classes `Main`, que estão localizadas no pacote`com.dio.counterchallenge` ou `com.dio.selectionprocess`, com o
método `main()` executavel.
