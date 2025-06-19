import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Classe que representa um processo
class ProcessoNaoPreemptivo {
    String nome;
    int tempoExecucao;
    int prioridade;

    // Construtor da classe Processo
    public ProcessoNaoPreemptivo(String nome, int tempoExecucao, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }
}

public class EscalonamentoPorPrioridadeNaoPreemptivo {
    public static void main(String[] args) {
        // Cria uma lista de processos
        List<ProcessoNaoPreemptivo> processos = new ArrayList<>();

        // Adiciona processos à lista com nome, tempo de execução e prioridade
        processos.add(new ProcessoNaoPreemptivo("P1", 5, 2));
        processos.add(new ProcessoNaoPreemptivo("P2", 3, 1));
        processos.add(new ProcessoNaoPreemptivo("P17", 8, 4));
        processos.add(new ProcessoNaoPreemptivo("P6", 6, 3));
        processos.add(new ProcessoNaoPreemptivo("P7", 2, 5));
        processos.add(new ProcessoNaoPreemptivo("P22", 7, 6));
        processos.add(new ProcessoNaoPreemptivo("P8", 1, 1));

        // Ordena a lista de processos com base na prioridade (menor número = maior prioridade)
        processos.sort(Comparator.comparingInt(p -> p.prioridade));

        // Exibe a ordem de execução dos processos
        System.out.println("Ordem de execução dos processos (por prioridade):\n");

        int tempoAtual = 0; 

        // Percorre a lista de processos e simula a execução
        for (ProcessoNaoPreemptivo p : processos) {
            System.out.println("Executando " + p.nome + 
                               " | Prioridade: " + p.prioridade + 
                               " | Tempo de Execução: " + p.tempoExecucao + 
                               " | Início: " + tempoAtual + 
                               " | Fim: " + (tempoAtual + p.tempoExecucao));
            tempoAtual += p.tempoExecucao;
        }
    }
}
