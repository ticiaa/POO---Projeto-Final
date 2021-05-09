package Telas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Classes.Produto;
import Classes.Venda;

public class TelaRelatorioDetalhado {

    public void telaDetail(List<Produto> produtos, Scanner ler, List<Venda> vendas, DateTimeFormatter formataData, DecimalFormat formataDecimal) {

        String dataInicial, dataFinal;

        System.out.println("\nInforme o período de emissão:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Data inicial [dd/mm/aaaa] (ENTER para a data de hoje): ");
         dataInicial = ler.nextLine();

        if(!dataInicial.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}+$") && (!dataInicial.isBlank())) {
            System.out.println("\nFormato de data inválido, recomeçando...");
            
        }

        if(dataInicial.isBlank()) {
            dataInicial = formataData.format(LocalDateTime.now());
            System.out.println("Data de Hoje: " + dataInicial);
        } else
            System.out.println("\nData: " + dataInicial);
            System.out.println("\n--------------------------------------------------------------");

             System.out.println("Data final [dd/mm/aaaa] (ENTER para a data de hoje): ");
             dataFinal = ler.nextLine();

             if(!dataFinal.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}+$") && (!dataFinal.isBlank())) {
                System.out.println("\nFormato de data inválido, recomeçando...");
                
            }

             if(dataFinal.isBlank()) {
                 dataFinal = formataData.format(LocalDateTime.now());
                 System.out.println("Data de Hoje: " + dataFinal);
            } else
                System.out.println("\nData: " + dataFinal);

                if(dataInicial.compareTo(dataFinal) > 0) {
                    System.out.println("\nA data inicial deve ser maior que a data final.");
                    System.out.println("\nVoltando ao menu anterior...\n");
                                
                            }

                 System.out.printf("\n\nPeríodo de Emissão: %s a %s\n", dataInicial, dataFinal);

                 System.out.printf("%s\n", "--------------------------------------------------------------------------------------------------");
                 System.out.printf("\n%s\t%-15.15s\t%-20.20s\t%-12.12s\t%-15.15s\t%-20.20s\n", "Data", "Código","Produto", "Quantidade", "Valor Unit.(R$)", "Valor Total(R$)");
                 System.out.printf("%s\n", "--------------------------------------------------------------------------------------------------");
                                
                filtroVenda(vendas, dataInicial, dataFinal, formataData, formataDecimal);

                DoubleSummaryStatistics statics = vendas.stream()
                .collect(Collectors.summarizingDouble(p -> (p.getQuant() * p.getProduto().getPreco())));
                System.out.printf("Valor médio do período: R$ %.2f\n", statics.getAverage());
                                
    }

        public void filtroVenda(List<Venda> vendas, String dataInicial, String dataFinal, DateTimeFormatter formataData, DecimalFormat formataDecimal) {
                List<Venda> vendasFilter = 
                vendas.stream()
                .filter(p -> 
                p.getData().plusDays(1).isAfter(LocalDate.parse(dataInicial, formataData)) &&
                p.getData().plusDays(-1).isBefore(LocalDate.parse(dataFinal, formataData)))
                .collect(Collectors.toList());

                vendasFilter.forEach(p -> System.out.printf("%-10.10s\t%-15.15s\t%-20.20s\t%-12.12s\t%-15.15s\t%-20.20s\n", formataData.format(p.getData()), p.getProduto().getCodigo(),  p.getProduto().getNome(),  p.getQuant(), formataDecimal.format(p.getProduto().getPreco()), formataDecimal.format(p.getQuant() * p.getProduto().getPreco())));
                System.out.printf("%s\n", "--------------------------------------------------------------------------------------------------");
                                
        }

}