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
            venda.adicionarItem(new Item(1, new Produto(1, "Arroz", 6.20, Categoria.ALIMENTICIO), 3));
            venda.adicionarItem(new Item(2, new Produto(4, "Presunto", 24.99, Categoria.ALIMENTICIO), 1));
            venda.adicionarItem(new Item(3, new Produto(8, "Desinfetante", 15.73, Categoria.LIMPEZA), 2));
            venda.adicionarItem(new Item(4, new Produto(12, "Pão francês", 0.50, Categoria.PADARIA), 8));
            System.out.printf("Total: %.2f%n", venda.getTotal());
            System.out.println("Informe o código do item que deseja remover:");
            int indice = scanner.nextInt();
            boolean verificador = venda.removerItem(--indice);
            while(!verificador) {
                System.out.println("Informe um item válido:");
                indice = scanner.nextInt();
                verificador = venda.removerItem(--indice);
            }
            System.out.printf("Total: %.2f%n", venda.getTotal());

    }
}