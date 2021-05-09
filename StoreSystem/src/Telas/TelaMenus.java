package Telas;

public class TelaMenus {
    
    public void menuPrincipal() {
        System.out.println("\n------------ MENU PRINCIPAL -------------");
        System.out.println("[1] - Cadastrar produtos");
        System.out.println("[2] - Relatórios");
        System.out.println("[3] - Realizar Venda");
        System.out.println("[0] - Sair");
        System.out.println("-------------------------------------------\n");
    }

    public void cadastroMenu() {
        System.out.println("\n------------ CADASTRO DE PRODUTOS -------------");
        System.out.println("[1] - Consultar ");
        System.out.println("[2] - Incluir");
        System.out.println("[0] - Voltar");
        System.out.println("-------------------------------------------------\n");
    }

    public void relatoriosMenu() {
        System.out.println("\n------------ RELATÓRIOS -------------");            
        System.out.println("[1] - Produtos ");
        System.out.println("[2] - Vendas por período (detalhado)");
        System.out.println("[3] - Vendas por período (consolidado)");            
        System.out.println("[0] - Voltar ");
        System.out.println("---------------------------------------\n");
    }

    
}