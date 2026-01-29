package br.com.livroteca.sys.modelo;

public class LivroDigital extends Livro {
	private double percentualDesconto;

	public LivroDigital(int id, String titulo, double precobase, int quantidadeEstoque, double percentualDesconto) {
		super(id, titulo, precobase, quantidadeEstoque);
		this.percentualDesconto = percentualDesconto;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	@Override
	public double calcularPrecoFinal() {
		return getPrecobase() - (getPrecobase()*percentualDesconto/100);
	}
	@Override
	public String toString() {
		return super.toString() + "\nPercentual de desconto=" + percentualDesconto + "%";
	}
	

}
