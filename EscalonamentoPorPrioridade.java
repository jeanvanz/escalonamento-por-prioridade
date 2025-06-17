import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Processo {
    String nome;
    int tempoExecucao;
    int prioridade;

    public Processo(String nome, int tempoExecucao, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }
}

public class EscalonamentoPorPrioridade {
    public static void main(String[] args) {
        List<Processo> processos = new ArrayList<>();
        processos.add(new Processo("P1", 5, 2));
        processos.add(new Processo("P2", 3, 1));
        processos.add(new Processo("P17", 8, 4));
        processos.add(new Processo("P6", 6, 3));
        processos.add(new Processo("P7", 2, 5));
        processos.add(new Processo("P22", 7, 6));
        processos.add(new Processo("P8", 1, 1));

        processos.sort(Comparator.comparingInt(p -> p.prioridade));

        System.out.println("Ordem de execução dos processos (por prioridade):\n");
        int tempoAtual = 0;
        for (Processo p : processos) {
            System.out.println("Executando " + p.nome + " | Prioridade: " + p.prioridade + " | Tempo de Execução: "
                    + p.tempoExecucao + " | Início: " + tempoAtual + " | Fim: " + (tempoAtual + p.tempoExecucao));
            tempoAtual += p.tempoExecucao;
        }
    }
}