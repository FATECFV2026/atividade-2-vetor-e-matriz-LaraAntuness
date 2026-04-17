import java.util.Arrays;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n1-Ex01  2-Ex02  3-Ex03  4-Ex04  5-Ex05  6-Ex06  0-Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(Arrays.toString(ex01()));
                    break;

                case 2:
                    System.out.println(Arrays.toString(ex02()));
                    break;

                case 3:
                    System.out.println(Arrays.toString(ex03()));
                    break;

                case 4:
                    int[] v = ex04();
                    System.out.println(Arrays.toString(v));
                    System.out.printf("Soma: %d\n", calcularSoma(v));
                    break;

                case 5:
                    exibirMatriz(ex05());
                    break;

                case 6:
                    int[][][] r = ex06();
                    exibirMatriz(r[0]);
                    exibirMatriz(r[1]);
                    exibirMatriz(r[2]);
                    break;
            }
        }
    }

    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextInt();
        } while (valor <= min || valor > max);
        return valor;
    }

    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) return null;

        int[] vetor = new int[10];
        vetor[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i - 1] * 2;
        }

        return vetor;
    }

    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) return null;

        int[] vetor = new int[10];
        vetor[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i - 1] - 1;
        }

        return vetor;
    }
    
    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) return null;

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }

        return vetor;
    }
    
    public static int[] sequenciaCresenteComSoma(int valorInicial) {

        int[] vetor = new int[10];
        vetor[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i - 1] + 1;
        }

        return vetor;
    }
    
    public static int calcularSoma(int[] vetor) {
        int soma = 0;

        for (int v : vetor) {
            soma += v;
        }

        return soma;
    }
    
    public static int[][] matrizIncrementais(int tamanho) {

        int[][] matriz = new int[tamanho][tamanho];
        int contador = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = contador++;
            }
        }

    return matriz;
    }
    
    public static int[][][] operacaoEntreMatrizes(int tamanho) {

        int[][] N = new int[tamanho][tamanho];
        int[][] Z = new int[tamanho][tamanho];
        int[][] soma = new int[tamanho][tamanho];

        int contador = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {

                N[i][j] = contador;
                Z[i][j] = contador;
                soma[i][j] = N[i][j] + Z[i][j];

                contador++;
            }
        }

        return new int[][][]{N, Z, soma};
    }

    public static int[] ex01() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (<=20): ", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(v);
    }
    
    public static int[] ex02() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaDecrescente(v);
    }
    
    public static int[] ex03() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (1<v<=1000): ", 1, 1000);
        return vetorDinamico(v);
    }
    
    public static int[] ex04() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaCresenteComSoma(v);
    }
    
    public static int[][] ex05() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return matrizIncrementais(v);
    }
    
    public static int[][][] ex06() {
        Scanner scanner = new Scanner(System.in);
        int v = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return operacaoEntreMatrizes(v);
    }
}
