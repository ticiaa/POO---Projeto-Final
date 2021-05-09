package Classes;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

public class Venda {
    private LocalDate data;
    private Produto produto;
    private int quant;

    public Venda(){
    }


    public Venda(Produto produto) {
        this.produto = produto;
    }

    public Venda(LocalDate localDate, int q, Produto produto) {
        this.data = localDate;
        this.quant = q;
        this.produto = produto;
    }

    public LocalDate getData() {
        return this.data;
    }
    public void setData(LocalDate localDate){
        this.data = localDate;
    }
    public Produto getProduto() {
        return this.produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQuant() {
        return this.quant;
    }
    public void setQuant(int q) {
        this.quant = q;
    }

    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Venda) {
            Venda venda = (Venda)obj;
            return this.data.equals((Object)venda.getData()) && this.produto.equals(venda.getProduto());
        }

        return false;
    }
    
    public String toString() {
        return String.format((String)"\t%-15.15s\t%-12.12s\t%-20.20s", this.data, this.quant, this.getProduto().getPreco() * getQuant());
    }

    public int compareTo(Venda venda) {
        return this.data.compareTo((ChronoLocalDate)venda.getData());
    }

    public void add(List<Venda> vendas) {
    }



    
}
