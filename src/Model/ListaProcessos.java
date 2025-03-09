package Model;

import java.util.ArrayList;
import java.util.List;

// Classe que representa uma lista de processos e gerencia sua execução com base em um quantum
public class ListaProcessos {
    private Integer quantum; // Tempo máximo de execução por processo (quantum)
    private List<Processo> list = new ArrayList<Processo>(); // Lista de processos

    // Construtor da classe
    public ListaProcessos(Integer quantum) {
        this.quantum = quantum;
    }

    // Metodo para executar os processos usando o algoritmo Round Robin
    public void executarProcessos(){
        Integer timeProcessing = 0; // Tempo de processamento atual
        boolean pendingProcesses; // Indica se ainda há processos pendentes
        int index = 0; // Índice do processo atual
        do {
            pendingProcesses = false;
            // Verifica se o índice está dentro dos limites da lista
            if (index >= getList().size()) {
                index = 0; // Reseta o índice para o início da lista
            }

            // Executa o processo no índice atual, se ainda tiver tempo de execução
            if (getList().get(index).getBurstTime() > 0) {
                timeProcessing = executar(index); // Executa o processo e obtém o tempo usado

                // Atualiza o tempo de espera dos outros processos
                for (int i = 0; i < getList().size(); i++) {
                    if (i != index && getList().get(i).getBurstTime() > 0) {
                        getList().get(i).setWaitingTime(getList().get(i).getWaitingTime() + timeProcessing);
                    }
                }
            }

            // Verifica se ainda há processos pendentes (com tempo de execução restante)
            for (Processo p : getList()) {
                if (p.getBurstTime() > 0) {
                    pendingProcesses = true;
                    break;
                }
            }

            // Incrementa o índice para o próximo processo
            index++;
        }while (pendingProcesses); // Repete enquanto houver processos pendentes
    }

    // Metodo privado para executar um processo específico
    private Integer executar(int index) {

        // Se o tempo de execução do processo for maior ou igual ao quantum
        if (getList().get(index).getBurstTime() >= getQuantum()) {

            // Reduz o tempo de execução do processo pelo quantum
            getList().get(index).setBurstTime(getList().get(index).getBurstTime() - getQuantum());
            return getQuantum(); // Retorna o tempo usado (quantum)
        }

        // Se o tempo de execução do processo for zero
        if (getList().get(index).getBurstTime() == 0) {
            return 0; // Retorna 0, pois não há tempo de execução restante
        } else {
            // Caso contrário, executa o tempo restante do processo
            int burtsAux = getList().get(index).getBurstTime();
            getList().get(index).setBurstTime(0); // Define o tempo de execução como 0
            return burtsAux; // Retorna o tempo restante usado
        }
    }

    // Metodo para imprimir os detalhes de todos os processos na lista
    public void imprimir() {
        for (int index = 0; index < getList().size(); index++) {
            getList().get(index).imprimir();
        }
    }
    // Metodo para calcular o tempo médio de espera dos processos
    public Double calcularMediaEspera() {
        Double somatoriaEspera = 0.0;

        // Soma o tempo de espera de todos os processos
        for (int index = 0; index < getList().size(); index++) {
            somatoriaEspera += getList().get(index).getWaitingTime();
        }

        // Retorna a média do tempo de espera
        return somatoriaEspera / getList().size();
    }

    // Retorna a lista de processos
    public List<Processo> getList() {
        if (list == null) {
            list = new ArrayList<Processo>(); // Inicializa a lista se for null
        }
        return list;
    }

    public void setList(List<Processo> list) {
        this.list = list;
    }

    public Integer getQuantum() {
        return quantum;
    }

    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }
}
