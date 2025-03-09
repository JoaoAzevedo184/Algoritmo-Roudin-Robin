import Model.ListaProcessos;
import Model.Processo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int quantidadeProcessos , quantum;

        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();

        System.out.println("Deseja criar quantos processos?");
        quantidadeProcessos = teclado.nextInt();

        //tempo máximo que cada processo pode executar antes de ser interrompido
        System.out.println("Qual será o quantum(tempo máximo que cada processo pode executar antes de ser interrompido) dessa lista de processos?");
        quantum = teclado.nextInt();

        ListaProcessos listaProcesso = new ListaProcessos(quantum);
        for (int index = 0; index < quantidadeProcessos; index++) {
            if (index == 0) {
                listaProcesso.getList().add(new Processo("Processo " + index, 0, gerador.nextInt(25) + 1, null));
            } else {
                listaProcesso.getList()
                        .add(new Processo("Processo " + index, gerador.nextInt(25) + 1, gerador.nextInt(25) + 1, null));
            }
        }
        System.out.println("Os processos forma criados.");
        System.out.println("----------------------------- ");
        System.out.println("INICIANDO A EXECUÇÃO....");
        System.out.println("-----------------------------");

        System.out.println("-----------------------------");
        System.out.println("PRÉ - PROCESSAMENTO: ");

        listaProcesso.imprimir();
        listaProcesso.executarProcessos();

        System.out.println("++++++++++++++++++++++++++++++++ ");
        System.out.println("PÓS- PROCESSAMENTO: ");
        System.out.println(" ");
        listaProcesso.imprimir();

        System.out.println("-----------------------------");
        System.out.println("  PROCESSAMENTO CONCLUÍDO");
        System.out.println("   -O Tempo médio de espera foi de " + listaProcesso.calcularMediaEspera());
        System.out.println("-----------------------------");
    }
}