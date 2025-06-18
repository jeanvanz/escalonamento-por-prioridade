import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class ProcessoPreemptivo {
    String nome;
    int tempoExecucao;
    int tempoRestante;
    int prioridade;
    int tempoChegada;

    public ProcessoPreemptivo(String nome, int tempoExecucao, int prioridade, int tempoChegada) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.tempoRestante = tempoExecucao;
        this.prioridade = prioridade;
        this.tempoChegada = tempoChegada;
    }
}

public class EscalonamentoPorPrioridadePreemptivo {

    public static void main(String[] args) {
        List<ProcessoPreemptivo> processos = new ArrayList<>();
        processos.add(new ProcessoPreemptivo("P1", 5, 3, 0));
        processos.add(new ProcessoPreemptivo("P2", 3, 1, 2));
        processos.add(new ProcessoPreemptivo("P3", 8, 4, 4));
        processos.add(new ProcessoPreemptivo("P4", 6, 2, 8));
        processos.add(new ProcessoPreemptivo("P5", 2, 5, 12));
        processos.add(new ProcessoPreemptivo("P6", 7, 1, 10));

        List<ProcessoPreemptivo> esperandoExecucao = new ArrayList<>();
        ProcessoPreemptivo processoAtual = null;
        int tempoAtual = 0;

        System.out.println("Simulação de Escalonamento por Prioridade (Preemptivo):\n");

        while (!processos.isEmpty() || processoAtual != null || !esperandoExecucao.isEmpty()) {

            Iterator<ProcessoPreemptivo> it = processos.iterator();
            while (it.hasNext()) {
                ProcessoPreemptivo p = it.next();
                if (p.tempoChegada == tempoAtual) {
                    esperandoExecucao.add(p);
                    System.out.println("Tempo " + tempoAtual + ": Processo " + p.nome + " chegou (Prioridade: "
                            + p.prioridade + ")");
                    it.remove();
                }
            }

            if (!esperandoExecucao.isEmpty()) {
                ProcessoPreemptivo maisPrioritario = null;
                for (ProcessoPreemptivo p : esperandoExecucao) {
                    if (maisPrioritario == null || p.prioridade < maisPrioritario.prioridade) {
                        maisPrioritario = p;
                    }
                }

                if (processoAtual == null || maisPrioritario.prioridade < processoAtual.prioridade) {
                    if (processoAtual != null) {
                        System.out.println(
                                "Tempo " + tempoAtual + ": Processo " + processoAtual.nome + " foi pausado");
                        esperandoExecucao.add(processoAtual);
                    }
                    processoAtual = maisPrioritario;
                    esperandoExecucao.remove(maisPrioritario);
                    System.out.println(
                            "Tempo " + tempoAtual + ": Processo " + processoAtual.nome + " começou a executar");
                }
            }

            if (processoAtual != null) {
                processoAtual.tempoRestante--;

                if (processoAtual.tempoRestante == 0) {
                    System.out
                            .println("Tempo " + (tempoAtual + 1) + ": Processo " + processoAtual.nome + " finalizado");
                    processoAtual = null;
                }
            }

            tempoAtual++;
        }
    }
}