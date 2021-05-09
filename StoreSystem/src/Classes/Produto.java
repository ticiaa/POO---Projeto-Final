package Classes;

public class Produto {
    private String nome;
    private String codigo;
    private Double preco;
    private int quantidade;

    public Produto(String cod, String prodnome, double precounit, int quant) {
        this.codigo = cod;
        this.nome = prodnome;
        this.preco = precounit;
        this.quantidade = quant;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "➝ Código: " + codigo + " - Nome: " + nome + " - Preço: R$" + preco + " - Quantidade disponível: " + quantidade;
    }

	public boolean contains(String codigo3) {
		return false;
    }

}