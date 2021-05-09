package Telas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Classes.Produto;
import Classes.Venda;

public class TelaRelatorioConsolidado {
    
    public void telaConsol(List<Produto> produtos, Scanner ler, List<Venda> vendas, DateTimeFormatter formataData, DecimalFormat formataDecimal) {

        System.out.println("Informe a data a ser relatada (ENTER para da data de hoje): ");
        String dataConsolid = ler.nextLine();

        if(!dataConsolid.matches("^\\d[1-31]{2}-\\d[1-12]{2}-\\d{4}+$") && (!dataConsolid.isBlank())) {
            System.out.println("\nFormato de data inválido, recomeçando...");
            
        } else {
        
        if(dataConsolid.isBlank()) {
            dataConsolid = formataData.format(LocalDateTime.now());
            System.out.println("Data de Hoje: " + dataConsolid);
        } else
            System.out.println("Data: " + dataConsolid);

        for (Venda venda : vendas) {
            if(!venda.getData().equals(LocalDate.parse(dataConsolid, formataData))){
                System.out.println("\nNENHUMA VENDA FOI REALIZADA NESTA DATA!\n");
                break;
            }
        }

        System.out.printf("\nVendas da Data: [%s]", dataConsolid);

        System.out.printf("\nConfirmar - [ENTER]       Reinício - [B]");
        String choice = ler.nextLine();

        if(choice.isBlank()) {
             System.out.printf("\t%-15.15s\t%-12.12s\t%-20.20s", "Produto","Quantidade", "Valor Total(R$)");
             System.out.printf("\n%s\n", "----------------------------------------------------------------------------------------");
            
             filtroConsolid(vendas, dataConsolid, formataData, formataDecimal);
            } else {
                if(choice.equalsIgnoreCase("b")) {
                    
                }
            }
        }
    }   

    public void filtroConsolid(List<Venda> vendas, String dataConsolid, DateTimeFormatter formataData, DecimalFormat formataDecimal) {
        List<Venda> vendasConsolFilter = 
             vendas.stream()
             .filter(c -> c.getData().isEqual(LocalDate.parse(dataConsolid, formataData)))
             .collect(Collectors.toList());

        vendasConsolFilter.forEach(c -> System.out.printf("%-15.15s\t%-12.12s\t%-20.20s\n", c.getProduto().getNome(), c.getQuant(), formataDecimal.format(c.getQuant() * c.getProduto().getPreco())));
        System.out.printf("%s\n", "----------------------------------------------------------------------------------------");
    }
}