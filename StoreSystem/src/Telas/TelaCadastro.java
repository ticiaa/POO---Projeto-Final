package Telas;

import Classes.Produto;
import java.util.List;
import java.util.Scanner;

public class TelaCadastro {

    public void telaCadastro(List<Produto> produtos, Scanner ler) {

            

            System.out.println("\n------------ INSERINDO NOVO PRODUTO -------------");
            System.out.println("\nInsira o código do produto (ou ENTER para voltar): ");
            String cod = ler.nextLine();
            
            if (!cod.matches("^\\d+$")) {
                System.out.println("\nO código do produto é um serial numérico, por favor, tente novamente inserindo apenas números!");
                
            } else {
                if (cod.isBlank()) {
                           
                } else {
                    System.out.println("Nome do Produto: ");
                    String prodnome = ler.nextLine();
                    System.out.println("Preço Unitário: ");
                    double precounit = ler.nextDouble();
                    System.out.println("Quantidade: ");
                    int quant = ler.nextInt();
                    ler.nextLine();
                    System.out.println("PRODUTO CADASTRADO COM SUCESSO!");

                    Produto produto = new Produto(cod, prodnome, precounit, quant);
                    produtos.add(produto);
                }
            }

    }
}