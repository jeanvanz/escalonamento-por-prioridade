# Escalonamento por Prioridade

## :bust_in_silhouette: Integrantes do Grupo
- Bernardo Sozo Fattini
- Gabriel Brocco de Oliveira
- Gabriel Pradegan Orsatto
- Jean Folle Vanz
- Otávio Augusto Lorenzatto

## :pushpin: Objetivo 
O objetivo deste projeto é apresentar uma simulação de algoritmo de escalonamento por prioridade em Java. Ele é um algoritmo fundamental em sistemas operacionais, onde cada processo recebe uma prioridade, e o processo com a maior prioridade é executado primeiro.

## 📼 Link para o vídeo da equipe apresentando o trabalho

## ✍️ Como executar o projeto

Requisitos
    Java Development Kit (JDK) 8 ou superior instalado na máquina.

Você pode verificar se o JDK está instalado corretamente com o comando:

```bash
java -version
```
Se estiver tudo certo, siga os passos abaixo para clonar, compilar e executar o projeto:

```bash
git clone https://github.com/jeanvanz/escalonamento-por-prioridade.git
cd escalonamento-por-prioridade

```

Escalonamento por prioridade não-preemptivo

```bash
javac EscalonamentoPorPrioridadeNaoPreemptivo.java
java EscalonamentoPorPrioridadeNaoPreemptivo
```

Escalonamento por prioridade preemptivo

```bash
javac EscalonamentoPorPrioridadePreemptivo.java
java EscalonamentoPorPrioridadePreemptivo
```

ℹ️ Observação: Se você estiver utilizando o JDK 11 ou superior, pode rodar o programa diretamente com:
```bash
java EscalonamentoPorPrioridadeNaoPreemptivo.java
```
ou
```bash
java EscalonamentoPorPrioridadePreemptivo.java
```
Nesse caso, não é necessário compilar com javac previamente.

## 📝 Análise dos resultados


📌 Escalonamento por Prioridade Não Preemptivo

No código de escalonamento por prioridade não preemptivo, é adicionado os processos com (nome, tempo de execução e prioridade) a uma lista, após, com o uso do .sort, eh ordenado de forma crescente referente a prioridade (menor número = maior prioridade).

🧠 Observações da Execução:

- P2 e P6 foram executados primeiro, pois tinham prioridade mais alta.

- P4, P1, P3 e P5 seguiram na ordem decrescente de prioridade.

- Mesmo que P6 tenha chegado depois de outros processos, ele foi executado antes por ter a mesma prioridade que P2 (maior prioridade).

ℹ️ No modo não preemptivo, uma vez que um processo começa a executar, ele não pode ser pausado. Mesmo que um processo mais prioritário chegue durante sua execução, ele deve esperar até que o atual seja finalizado.


📌 Escalonamento por Prioridade Preemptivo 

Ja no escalonamento por prioridade preemptivo, os processos podem chegar dinamicamente ao sistema, nesse caso, foi criado uma lista apenas para uma forma de simulação com (nome, tempo de execução, prioridade e tempo de chegada), no escalonamento por prioridade, se le linha por linha, mas não que seja assim para executar esses processos, pois sao executados e em seguida vem algum processo com prioridade maior, o processo com prioridade menor fica esperando ate chegar no nível de sua prioridade, nesse caso:

🧠 Observações da Execução:

- O processo P1 foi pausado no tempo 2 pela chegada do P2, que possuía maior prioridade.

- Mais tarde, P4 foi pausado por P6, também por causa da prioridade superior.

- O escalonador tomou decisões em tempo real, reagindo às chegadas e reorganizando a CPU.

ℹ️ No modo preemptivo, o escalonador pode interromper um processo em execução caso um novo processo com prioridade mais alta chegue. Isso garante que tarefas críticas tenham resposta imediata, mesmo que outro processo esteja em execução.



## 🔎 Referências utilizadas
- Preemptive and Non-Preemptive Scheduling: https://www.geeksforgeeks.org/operating-systems/preemptive-and-non-preemptive-scheduling/
- Preemptive Priority CPU Scheduling Algorithm: https://www.geeksforgeeks.org/preemptive-priority-cpu-scheduling-algortithm/
- SO 3: Prioridades (Algoritmos de Escalonamento): https://www.youtube.com/watch?v=Nlg8tYzyH4Y


---
