import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class ProcessoNaoPreemptivo {
    String nome;
    int tempoExecucao;
    int prioridade;

    public ProcessoNaoPreemptivo(String nome, int tempoExecucao, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }
}

public class EscalonamentoPorPrioridadeNaoPreemptivo {
    public static void main(String[] args) {
        List<ProcessoNaoPreemptivo> processos = new ArrayList<>();
        processos.add(new ProcessoNaoPreemptivo("P1", 5, 3));
        processos.add(new ProcessoNaoPreemptivo("P2", 3, 1));
        processos.add(new ProcessoNaoPreemptivo("P3", 8, 4));
        processos.add(new ProcessoNaoPreemptivo("P4", 6, 2));
        processos.add(new ProcessoNaoPreemptivo("P5", 2, 5));
        processos.add(new ProcessoNaoPreemptivo("P6", 7, 1));

        processos.sort(Comparator.comparingInt(p -> p.prioridade));

        System.out.println("Ordem de execução dos processos (por prioridade):\n");
        int tempoAtual = 0;
        for (ProcessoNaoPreemptivo p : processos) {
            System.out.println("Executando " + p.nome + " | Prioridade: " + p.prioridade + " | Tempo de Execução: "
                    + p.tempoExecucao + " | Início: " + tempoAtual + " | Fim: " + (tempoAtual + p.tempoExecucao));
            tempoAtual += p.tempoExecucao;
        }
    }
}