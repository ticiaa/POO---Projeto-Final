package Telas;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import Classes.Produto;

public class TelaConsulta {

    public void telaConsulta(List<Produto> produtos, Scanner ler) {

        if (produtos.isEmpty()) {
            System.out.println("\nNÃO HÁ PRODUTOS CADASTRADOS!");
            
        } else {

        System.out.println("\nDigite o nome do produto (ou ENTER para mostrar todos): ");
        String psqnome = ler.nextLine();

            System.out.println("\n--------------- PRODUTOS EM ESTOQUE --------------");

            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase("")) {
                    produtos.stream().sorted(Comparator.comparing(Produto::getNome));
                    System.out.println(produto);
                    break;
                } else {
                    produtos.stream().filter(p -> p.getNome().contains(psqnome))
                    .collect(Collectors.toList()).forEach(System.out::println);
                    break;
                }
            }
        }
    }
}
    