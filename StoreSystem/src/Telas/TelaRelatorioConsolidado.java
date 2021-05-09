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

        System.out.println("\nInforme a data a ser relatada (ENTER para da data de hoje): ");
        String dataConsolid = ler.nextLine();


        if(!dataConsolid.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}+$") && (!dataConsolid.isBlank())) {
            System.out.println("\nFormato de data inválido, recomeçando...");
            
        } else {
        if(dataConsolid.isBlank()) {
            dataConsolid = formataData.format(LocalDateTime.now());
            System.out.println("Data de Hoje: " + dataConsolid);
        } else
            System.out.println("Data: " + dataConsolid);

            
        }

        System.out.printf("\nVendas da Data: [%s]", dataConsolid);

        System.out.printf("\nConfirmar - [ENTER]       Reinício - [B]");
        String choice = ler.nextLine();

        if(choice.isBlank()) {
             System.out.printf("\n\n\n%-15.15s\t%-12.12s\t%-20.20s", "Produto","Quantidade", "Valor Total(R$)");
             System.out.printf("\n%s\n", "--------------------------------------------------");
            
             filtroConsolid(vendas, dataConsolid, formataData, formataDecimal);

            } else {
                if(choice.equalsIgnoreCase("b")) {
                    
                }
            }
        }
    
       

    public void filtroConsolid(List<Venda> vendas, String dataConsolid, DateTimeFormatter formataData, DecimalFormat formataDecimal) {
        List<Venda> vendasConsolFilter = 
             vendas.stream()
             .filter(c -> c.getData().isEqual(LocalDate.parse(dataConsolid, formataData)))
             .collect(Collectors.toList());

        vendasConsolFilter.forEach(c -> System.out.printf("%-15.15s\t%-12.12s\t%-20.20s\n", c.getProduto().getNome(), c.getQuant(), formataDecimal.format(c.getQuant() * c.getProduto().getPreco())));
        System.out.printf("%s\n", "--------------------------------------------------");
    }
}