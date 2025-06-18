import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Classe que representa um processo
class Processo {
    String nome;      
    int tempoExecucao;
    int prioridade;

    // Construtor da classe Processo
    public Processo(String nome, int tempoExecucao, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }
}

public class EscalonamentoPorPrioridadeNaoPreemptivo {
    public static void main(String[] args) {
        // Cria uma lista de processos
        List<Processo> processos = new ArrayList<>();

        // Adiciona processos à lista com nome, tempo de execução e prioridade
        processos.add(new Processo("P1", 5, 2));
        processos.add(new Processo("P2", 3, 1));
        processos.add(new Processo("P17", 8, 4));
        processos.add(new Processo("P6", 6, 3));
        processos.add(new Processo("P7", 2, 5));
        processos.add(new Processo("P22", 7, 6));
        processos.add(new Processo("P8", 1, 1));

        // Ordena a lista de processos com base na prioridade (menor número = maior prioridade)
        processos.sort(Comparator.comparingInt(p -> p.prioridade));

        // Exibe a ordem de execução dos processos
        System.out.println("Ordem de execução dos processos (por prioridade):\n");

        int tempoAtual = 0; 

        // Percorre a lista de processos e simula a execução
        for (Processo p : processos) {
            System.out.println("Executando " + p.nome + 
                               " | Prioridade: " + p.prioridade + 
                               " | Tempo de Execução: " + p.tempoExecucao + 
                               " | Início: " + tempoAtual + 
                               " | Fim: " + (tempoAtual + p.tempoExecucao));
            tempoAtual += p.tempoExecucao;
        }
    }
}
