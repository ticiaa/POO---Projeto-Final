package Telas;

import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;
import java.util.List; 
import Classes.Produto;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TelaProdutos {

    public void telaProdutos(List<Produto> produtos, Scanner ler, DecimalFormat formataDecimal) {
        
        System.out.printf("\n%s\n\n\n", "--------------------------- RELATÓRIOS - PRODUTOS ---------------------------");
        System.out.printf("%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s", "Código","Produto", "Valor Unit.(R$)", "Estoque");
        System.out.printf("\n%s\n", "-------------------------------------------------------------------------");

        for(Produto produto : produtos) {
            System.out.printf("%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s\n", produto.getCodigo(), produto.getNome(), formataDecimal.format(produto.getPreco()), produto.getQuantidade());
        }

        DoubleSummaryStatistics stats = produtos.stream().
        collect(Collectors.summarizingDouble(Produto::getPreco));
        System.out.printf("%s\n", "-------------------------------------------------------------------------");
        System.out.printf("Maior Valor: R$ %.2f\tMenor Valor: R$ %.2f\tValor Médio: R$ %.2f\n", stats.getMax(), stats.getMin(), stats.getAverage());

        
    }
}