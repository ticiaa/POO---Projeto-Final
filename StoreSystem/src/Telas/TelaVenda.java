package Telas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;

import Classes.Produto;
import Classes.Venda;

public class TelaVenda {

    public void telaVendas(List<Produto> produtos, Scanner ler, List<Venda> vendas, DateTimeFormatter formataData, DecimalFormat formataDecimal) {

        String s;

        if (produtos.isEmpty()) {
            System.out.println("\nNÃO HÁ PRODUTOS CADASTRADOS!");

        } else {

        System.out.println("\n------------------- REALIZANDO VENDA ------------------\n");
        System.out.println("Insira o código do produto (ou ENTER para voltar): ");
        String codigo3 = ler.nextLine();

        if (codigo3.isBlank()) {
                    
        }
                
        boolean temcod = false;        

        for (Produto produto : produtos) {
                    
            if (produto.getCodigo().equalsIgnoreCase(codigo3)) {
                temcod = true;
                System.out.printf("Produto localizado: [%s] \nConfirmar - [ENTER]       Voltar - [B]\n", produto.getNome());
                s = ler.nextLine();
                        
                if(s.isBlank()) {
                    if(produto.getQuantidade() == 0) {
                        System.out.println("Produto com estoque zerado, impossível realizar venda.\nVoltando ao menu anterior...");
                    }
                } else {
                    if(s.equalsIgnoreCase("b")) {
                        break;
                    }
                }

                System.out.println("Data [dd/mm/aaaa] (ENTER para a data de hoje): ");
                String vdata = ler.nextLine();

                if(!vdata.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}+$") && (!vdata.isBlank())) {
                    System.out.println("\nFormato de data inválido, recomeçando....");
                    break;
                }

                if (vdata.isBlank()) {
                    vdata = formataData.format(LocalDateTime.now());
                    System.out.println("Data de Hoje: " + vdata);
                } else
                    System.out.println("\nData: " + vdata);

                System.out.println("\nQuantidade: ");
                int q = ler.nextInt();
                ler.nextLine();

                if(produto.getQuantidade() <= q) {
                    System.out.printf("Estoque insuficiente!\nSeu estoque possui [%d] unidades deste produto.\n(Pressione ENTER para reiniciar)", produto.getQuantidade());
                    ler.nextLine();
                } else {
                    produto.setQuantidade(produto.getQuantidade() - q);

                    double valorTotal = produto.getPreco() * q;

                    System.out.printf("\nValor Total: [R$ %s]", formataDecimal.format(valorTotal));
                    System.out.println("\nVenda realizada com sucesso!\n");
                }

                Venda venda = new Venda(LocalDate.parse(vdata, formataData), q, produto);
                vendas.add(venda);
            }

                }
                

                if(temcod == false) {
                    System.out.println("Este código não é compatível com nenhum produto. Tente novamente!");
                }
        }
    }
}