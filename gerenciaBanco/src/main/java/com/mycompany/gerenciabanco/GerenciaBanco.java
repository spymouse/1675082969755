/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public GerenciaBanco(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente!");
        }
    }

    public void exibirDadosCliente() {
        System.out.println("\n--- Dados do Cliente ---");
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("CPF: " + cpf);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao Sistema Bancário!");
        
        // Cadastro do cliente
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        GerenciaBanco conta = new GerenciaBanco(nome, sobrenome, cpf);
        
        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    conta.exibirDadosCliente();
                    break;
                case 5:
                    System.out.println("Obrigado por usar nosso sistema bancário. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Realizar Depósito");
        System.out.println("3 - Realizar Saque");
        System.out.println("4 - Exibir Dados do Cliente");
        System.out.println("5 - Sair");
    }
}