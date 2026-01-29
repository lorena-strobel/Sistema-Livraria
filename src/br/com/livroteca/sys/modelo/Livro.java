package br.com.livroteca.sys.modelo;

public abstract class Livro {
	private int id;
	private String titulo;
	private double precobase;
	private int quantidadeEstoque;
	public Livro(int id, String titulo, double precobase, int quantidadeEstoque) {
        this.id = id;
		this.titulo = titulo;
		this.precobase = precobase;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecobase() {
		return precobase;
	}
	public void setPrecobase(double precobase) {
		this.precobase = precobase;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public abstract double calcularPrecoFinal();
	
	@Override
	public String toString() {
		return "\nID= " + id +
				"\nTitulo= " + titulo +
				"\nPreço Base= " + precobase +
				"\nQuantidade em estoque= " + quantidadeEstoque +
				"\nPreco final= " + calcularPrecoFinal();
	}
	public static double calcularValorTotalEstoque(Livro[] livros) {
		double total=0.0;
		for(Livro p: livros) {
			if(p!=null) {
			total += p.calcularPrecoFinal() * p.getQuantidadeEstoque();
		}
	}
		return total;
}
	

}
