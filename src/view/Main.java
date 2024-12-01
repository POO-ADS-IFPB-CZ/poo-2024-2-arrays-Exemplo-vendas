package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Venda venda = new Venda();

    public static void main(String[] args) {
        int opcao = 0;

        do{
            exibirMenu();
            opcao = scanner.nextInt();
            processarOpcao(opcao);
        }while (opcao!=5);

    }

    private static void exibirMenu() {
        System.out.println("\n>>>MENU DE VENDAS<<<");
        System.out.println("1. Exibir itens");
        System.out.println("2. Adicionar produto");
        System.out.println("3. Remover produto");
        System.out.println("4. Total das vendas");
        System.out.println("5. Sair");
    }

    private static void processarOpcao(int opcao) {
        if (opcao == 1){
            exibirItens();
            return;
        }
        if( opcao == 2){
            adicionarProduto();
            return;
        }
        if (opcao == 3){
            removerProduto();
            return;
        }
        if( opcao == 4){
            totalVenda();
            return;
        }
        if( opcao == 5){
            System.out.println("Encerrando programa...");
            return;
        }

        System.out.println("Opção inválida!");
    }

    private static void exibirItens() {
        System.out.println("\n>>Itens na Venda:");
        Item[] itens = venda.getItens();
        if (itens.length == 0) {
            System.out.println("Venda vazia");
            return;
        }
        for (Item item : itens) {
            System.out.printf("Código: %d | Nome: %s | Preço: %.2f | Quantidade: %.2f | Subtotal: %.2f%n",
                    item.getCodigo(), item.getProduto().getDescricao(), item.getProduto().getPreco(),
                    item.getQuantidade(), item.getSubtotal());
        }
    }

    private static void adicionarProduto() {
        Produto produto = lerProduto();
        System.out.print("Informe a quantidade do produto: ");
        double quantidade = scanner.nextDouble();
        Item item = new Item(venda.getItens().length + 1, produto, quantidade);
        venda.adicionarItem(item);
        System.out.println("Produto registrado com sucesso.");
    }

    private static Produto lerProduto() {
        System.out.print(">> Código do produto: ");
        int codigo = scanner.nextInt();

        System.out.print(">> Descrição do produto: ");
        String descricao = scanner.nextLine();
        scanner.nextLine();

        System.out.print(">> Preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.println(">> Categoria do produto | 1.ALIMENTICIO | 2.HIGIENE | 3.LIMPEZA | 4.HORTIFRUTI | 5.PADARIA: ");
        int categoriaEscolhida = scanner.nextInt();
        Categoria categoria = Categoria.values()[--categoriaEscolhida];

        return new Produto(codigo, descricao, preco, categoria);
    }

    private static void removerProduto() {
        System.out.print("Informe o código do produto que deseja remover: ");
        int codigo = scanner.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < venda.getItens().length; i++) {
            if (venda.getItens()[i].getProduto().getCodigo() == codigo) {
                venda.removerItem(i);
                encontrado = true;
                return;
            }
        }
    }

    private static void totalVenda() {
        System.out.printf("Total da venda: %.2f%n", venda.getTotal());
    }
}