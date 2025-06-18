import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Classe que representa um processo
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

        // Cria uma lista de processos
        List<ProcessoPreemptivo> processos = new ArrayList<>();
        // Adiciona processos à lista com nome, tempo de execução, prioridade e tempo de chegada

        processos.add(new ProcessoPreemptivo("P1", 5, 3, 0));
        processos.add(new ProcessoPreemptivo("P2", 3, 1, 2));
        processos.add(new ProcessoPreemptivo("P3", 8, 4, 4));
        processos.add(new ProcessoPreemptivo("P4", 6, 2, 8));
        processos.add(new ProcessoPreemptivo("P5", 2, 5, 12));
        processos.add(new ProcessoPreemptivo("P6", 7, 1, 10));

        // Lista de processos prontos para executar, mas ainda aguardando
        List<ProcessoPreemptivo> esperandoExecucao = new ArrayList<>(); 
        ProcessoPreemptivo processoAtual = null;
        int tempoAtual = 0;

        System.out.println("Simulação de Escalonamento por Prioridade (Preemptivo):\n");

        while (!processos.isEmpty() || processoAtual != null || !esperandoExecucao.isEmpty()) {

            // Verifica chegada de novos processos
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

            // Seleciona o processo de maior prioridade (menor número)
            if (!esperandoExecucao.isEmpty()) {
                ProcessoPreemptivo maisPrioritario = null;
                for (ProcessoPreemptivo p : esperandoExecucao) {
                    if (maisPrioritario == null || p.prioridade < maisPrioritario.prioridade) {
                        maisPrioritario = p;
                    }
                }

                // Preemptivo: troca o processo atual se houver outro com prioridade maior
                if (processoAtual == null || maisPrioritario.prioridade < processoAtual.prioridade) {
                    if (processoAtual != null) {
                        System.out.println("Tempo " + tempoAtual + ": Processo " + processoAtual.nome + " foi pausado");
                        esperandoExecucao.add(processoAtual);
                    }
                    processoAtual = maisPrioritario;
                    esperandoExecucao.remove(maisPrioritario);
                    System.out.println("Tempo " + tempoAtual + ": Processo " + processoAtual.nome + " começou a executar");
                }
            }

            // Verifica se há um processo em execução, se sim ele libera a CPU para outro processo
            if (processoAtual != null) {
                processoAtual.tempoRestante--;
                if (processoAtual.tempoRestante == 0) {
                    System.out.println("Tempo " + (tempoAtual + 1) + ": Processo " + processoAtual.nome + " finalizado");
                    processoAtual = null;
                }
            }
            tempoAtual++;
        }
    }
}
