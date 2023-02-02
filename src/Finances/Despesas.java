package Finances;

import java.util.ArrayList;
import java.util.Scanner;

public class Despesas {
    // Armazena todas as despesas adicionadas pelo usuário
    private static final ArrayList<Double> expenses = new ArrayList<Double>();
    // Leitor de entrada do usuário
    private static final Scanner scan = new Scanner(System.in);
    // Saldo atual
    private static double balance = 0.0;

    public static void main(String[] args) {
        // Variável para armazenar a opção escolhida pelo usuário
        int option = 0;

        // Loop principal para exibir o menu até que o usuário escolha sair (opção 6)
        while (option != 6) {
            System.out.println("\nSistema de Controle de Despesas");
            System.out.println("1 - Adicionar despesa");
            System.out.println("2 - Adicionar saldo");
            System.out.println("3 - Ver despesas");
            System.out.println("4 - Ver saldo");
            System.out.println("5 - Pagar conta");
            System.out.println("6 - Ver relatório de despesas");
            System.out.println("7 - Sair");
            System.out.print("\nEscolha uma opção: ");
            option = scan.nextInt();

            // Escolha a ação a ser executada baseada na opção escolhida pelo usuário
            switch (option) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    addBalance();
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    payBill();
                    break;
                case 6:
                    viewExpenseReport();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, escolha novamente.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("\nDigite o valor da despesa: ");
        double expense = 0.0;
        expense = scan.nextDouble();
        expenses.add(expense);
        balance -= expense;
        System.out.println("Despesa adicionada com sucesso.");
    }

    private static void addBalance() {
        System.out.print("\nDigite o valor a ser adicionado: ");
        double amount = scan.nextDouble();
        balance += amount;
        System.out.println("Saldo adicionado com sucesso.");
    }

    private static void viewExpenses() {
        System.out.println("\nDespesas:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + " - " + expenses.get(i));
        }
    }

    private static void viewBalance() {
        System.out.println("---------------------------------");
        System.out.println("\nSaldo atual: " + balance);
        System.out.println("---------------------------------");
    }

    private static void payBill() {
        System.out.print("\nDigite o número da despesa a ser paga: ");
        int billNumber = scan.nextInt();
// Verifica se a despesa escolhida existe
        if (billNumber > 0 && billNumber <= expenses.size()) {
            balance += expenses.get(billNumber - 1);
            expenses.remove(billNumber - 1);
            System.out.println("Conta paga com sucesso.");
        } else {
            System.out.println("Despesa inválida.");
        }
    }

    private static void viewExpenseReport() {
        double totalExpenses =0;
        System.out.println("\nRelatório de Despesas");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + " - " + expenses.get(i));
            totalExpenses += expenses.get(i);
        }
        System.out.println("Total de despesas: " + totalExpenses);
    }
}
