package br.com.livroteca.sys.modelo;

public class LivroFisico extends Livro {
	private double custoImpressao;

	public LivroFisico(int id, String titulo, double precobase, int quantidadeEstoque, double custoImpressao) {
		super(id, titulo, precobase, quantidadeEstoque);
		this.custoImpressao = custoImpressao;
	}

	public double getCustoImpressao() {
		return custoImpressao;
	}

	public void setCustoImpressao(double custoImpressao) {
		this.custoImpressao = custoImpressao;
	}
	@Override
	public double calcularPrecoFinal() {
		return getPrecobase() + getCustoImpressao();
	}
	@Override
	public String toString() {
		return super.toString() + "\nCusto Impressao= " + custoImpressao;
	}
	

}
