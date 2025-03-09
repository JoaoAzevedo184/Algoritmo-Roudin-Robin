package Model;

import java.util.Objects;

// Classe que representa um processo em um sistema de escalonamento
public class Processo implements Comparable<Processo> {
    private String nome;               // Nome do processo
    private Integer arrivelTime;       // Tempo de chegada do processo
    private Integer burstTime;         // Tempo de execução do processo
    private Integer waitingTime;       // Tempo de espera do processo

    // Construtor da classe
    public Processo(String nome, Integer arrivelTime,Integer burstTime, Integer waitingTime) {
        this.nome = nome;
        this.arrivelTime = arrivelTime;
        this.burstTime = burstTime;
        if(waitingTime == null){
            this.waitingTime = 0;
        }
        else{
            this.waitingTime = waitingTime;
        }
    }
    // Metodo para imprimir os detalhes do processo
    public void imprimir() {
        System.out.println("*******************");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Tempo de Chegada: " + this.getArrivelTime());
        System.out.println("Tempo de Execução: " + this.getBurstTime());
        System.out.println("Tempo de Espera: " + this.getWaitingTime());
        System.out.println("*******************");

    }
    // Metodo da interface Comparable para comparar processos com base no tempo de chegada
    public int compareTo(Processo processo) {
        if (this.getArrivelTime() < processo.getArrivelTime()) {
            return -1; // Este processo chegou antes
        } else if (this.getArrivelTime() > processo.getArrivelTime()) {
            return 1; // Este processo chegou depois
        }
        return 0; // Os processos chegaram ao mesmo tempo
    }

    // Metodo para verificar a igualdade entre dois processos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // São a mesma instância
        if (obj == null) return false; // O objeto comparado é null
        if (getClass() != obj.getClass()) return false; // Classes diferentes

        // Cast para Processo
        Processo other = (Processo) obj;
        // Compara os atributos dos processos
        if (arrivelTime == null) {
            if (other.arrivelTime != null)
                return false;
        } else if (!arrivelTime.equals(other.arrivelTime))
            return false;
        if (burstTime == null) {
            if (other.burstTime != null)
                return false;
        } else if (!burstTime.equals(other.burstTime))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (waitingTime == null) {
            if (other.waitingTime != null)
                return false;
        } else if (!waitingTime.equals(other.waitingTime))
            return false;
        return true;
    }

    // Metodo para gerar um código hash único para o processo
    @Override
    public int hashCode() {
        final int PRIMO = 31; // Número primo(convençao da comunidade) usado para calcular o hash
        int codigoHash = 1;
        codigoHash = PRIMO * codigoHash +((arrivelTime == null)? 0: arrivelTime.hashCode());
        codigoHash = PRIMO * codigoHash +((burstTime == null)? 0: burstTime.hashCode());
        codigoHash = PRIMO * codigoHash +((nome == null)? 0: nome.hashCode());
        codigoHash = PRIMO * codigoHash +((waitingTime == null)? 0: waitingTime.hashCode());
        return codigoHash;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getArrivelTime() {
        return arrivelTime;
    }

    public void setArrivelTime(Integer arrivelTime) {
        this.arrivelTime = arrivelTime;
    }

    public Integer getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(Integer burstTime) {
        this.burstTime = burstTime;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }
}