package Program;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Produto;
import Classes.Venda;
import Telas.TelaCadastro;
import Telas.TelaConsulta;
import Telas.TelaMenus;
import Telas.TelaProdutos;
import Telas.TelaRelatorioConsolidado;
import Telas.TelaRelatorioDetalhado;
import Telas.TelaVenda;

public class App {
    public static void main(String[] args) {

        TelaMenus tela = new TelaMenus();
        TelaConsulta consul = new TelaConsulta();
        TelaCadastro incluir = new TelaCadastro();
        TelaProdutos verprod = new TelaProdutos();
        TelaRelatorioDetalhado relatDetail = new TelaRelatorioDetalhado();
        TelaRelatorioConsolidado relatConsol = new TelaRelatorioConsolidado();
        TelaVenda vendatela = new TelaVenda();

        int opc = -1;

        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        Scanner ler = new Scanner(System.in);

        DecimalFormat formataDecimal = new DecimalFormat("0.00");
        formataDecimal.applyPattern("#,##0.00");
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

        do {
            tela.menuPrincipal();
            opc = ler.nextInt();
            ler.nextLine();

            switch (opc) {

                default:
                    System.out.println("Esta opção não existe!\n");
                    break;
            
                case 0:
                    return;

                case 1:
                    int opcao = -1;

                    do {
                        tela.cadastroMenu();
                        opcao = ler.nextInt();
                        ler.nextLine();

                        switch (opcao) {

                        default:
                            System.out.println("Esta opção não existe!\n");
                            break;

                        case 0:
                            break;

                        case 1:
                            consul.telaConsulta(produtos, ler);
                            break;

                        case 2:
                            incluir.telaCadastro(produtos, ler);
                            break;
                    }

                    } while (opcao != 0);

                break;

            case 2:

            int opcao2 = -1;

                do {
                    tela.relatoriosMenu();
                    opcao2 = ler.nextInt();
                    ler.nextLine();

                    switch (opcao2) {

                    default:
                        System.out.println("Esta opção não existe!\n");
                        break;

                    case 0:
                    break;

                    case 1:
                        if (produtos.isEmpty()) {
                            System.out.println("\nNÃO HÁ PRODUTOS CADASTRADOS!\n");
                            break;
                        }   
            
                        verprod.telaProdutos(produtos, ler, formataDecimal);
                        break;
                        
                    case 2:

                    System.out.println("\n--------------- RELATÓRIOS DE VENDA - DETALHADO --------------");

                    if(produtos.isEmpty()) {
                        System.out.println("\nNÃO HÁ PRODUTOS CADASTRADOS!\n");
                        break;           
                    }
            
                    if(vendas.isEmpty()) {
                        System.out.println("\nNENHUMA VENDA REALIDADA!\n");
                        break;
                    }
                        relatDetail.telaDetail(produtos, ler, vendas, formataData, formataDecimal);
                         break;

                    case 3:
                        System.out.println("\n--------------- RELATÓRIOS DE VENDA - CONSOLIDADO --------------");

                        if(produtos.isEmpty()) {
                            System.out.println("\nNÃO HÁ PRODUTOS CADASTRADOS!\n");
                            break;           
                        }
                
                        if(vendas.isEmpty()) {
                            System.out.println("\nNENHUMA VENDA REALIZADA!\n");
                            break;
                        }

                        relatConsol.telaConsol(produtos, ler, vendas, formataData, formataDecimal);
                        break;
                    }

                } while (opcao2 != 0);

                break;

            case 3:
                vendatela.telaVendas(produtos, ler, vendas, formataData, formataDecimal);
                break;
        }
                } while (opc != 0);

        ler.close();
    
    
    }
}