package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venda venda = new Venda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Ver Total da Venda");
            System.out.println("3. Finalizar Venda");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.print("Digite o código do produto: ");
                    int codigoProduto = scanner.nextInt();
                    scanner.nextLine(); // Para consumir a linha extra

                    System.out.print("Digite a descrição do produto: ");
                    String descricaoProduto = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = scanner.nextDouble();

                    System.out.println("Escolha a categoria do produto:");
                    System.out.println("1. Alimentício");
                    System.out.println("2. Higiene");
                    System.out.println("3. Limpeza");
                    System.out.println("4. Hortifrúti");
                    System.out.println("5. Padaria");
                    int categoriaEscolhida = scanner.nextInt();
                    Categoria categoriaProduto = Categoria.values()[categoriaEscolhida - 1];

                    System.out.print("Digite a quantidade do produto: ");
                    double quantidadeProduto = scanner.nextDouble();

                    Produto produto = new Produto(codigoProduto, descricaoProduto, precoProduto, categoriaProduto);
                    Item item = new Item(codigoProduto, produto, quantidadeProduto);
                    venda.adicionarItem(item);
                    System.out.println("Produto adicionado à venda!");
                    break;

                case 2:

                    System.out.println("Total da venda: R$ " + venda.getTotal());
                    break;

                case 3:

                    System.out.println("Venda finalizada!");
                    System.out.println("Total final: R$ " + venda.getTotal());
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}