package br.com.livroteca.sys.app;
import br.com.livroteca.sys.modelo.*;
import br.com.livroteca.sys.teclado.Teclado;

public class CadastroLivrosApp {
	public static void main(String[] args) {
		Livro[] livros = new Livro[10];
		int op=0;
		do {
			System.out.println("\n--Sistema da livroteca digital--");
			System.out.println("1- Cadastrar");
			System.out.println("2- Alterar");
			System.out.println("3- Consultar");
			System.out.println("4- Excluir");
			System.out.println("5- Sair");
			op=Teclado.lerInteiro("Digite uma opção");
			switch(op) {
			case 1:
				cadastrar(livros);
				break;
			case 2:
				alterar(livros);
				break;
			case 3:
				consultar(livros);
				break;
			case 4:
				excluir(livros);
				break;
			case 5: 
				System.out.println("Encerrando o programa");
				System.exit(0);
			default:
				System.out.println("Opção inválida");
			}
		} while(op!=5);
	}
	private static void cadastrar(Livro[] livros) {
		Livro novolivro;
		int tipolivro=Teclado.lerInteiro("1 para Livro Físico ou 2 para Livro Digital");
		int id=Teclado.lerInteiro("Digite o Id do livro");
		String titulo=Teclado.lerString("Digite o nome do livro");
		double precobase=Teclado.lerDouble("Digite o preço do livro");
		int quantidadeEstoque=Teclado.lerInteiro("Digite a quantidade de livros");
		if(tipolivro==1) {
			double custoImpressao=Teclado.lerDouble("Digite o custo de impressão para o livro");
			novolivro=new LivroFisico(id, titulo, precobase, quantidadeEstoque, custoImpressao);
		}
		else {
			double percentualDesconto=Teclado.lerDouble("Digite o percentual de desconto para esse livro");
			novolivro=new LivroDigital(id, titulo, precobase, quantidadeEstoque, percentualDesconto);
		}
		for(int i=0;i<livros.length;i++) {
			if(livros[i]==null) {
				livros[i]=novolivro;
				System.out.println("Livro cadastrado com sucesso");
				break;
			}
		}
	}
	private static void alterar(Livro[] livros) {
		int encontrado=0;
		int id=Teclado.lerInteiro("Digite o ID do livro para exlcusão");
		for(int i=0;i<livros.length;i++) {
			if(livros[i]!=null && livros[i].getId()==id) {
				livros[i].setTitulo(Teclado.lerString("Digite o novo nome do livro"));
				livros[i].setPrecobase(Teclado.lerDouble("Digite o novo preço do livro"));
				livros[i].setQuantidadeEstoque(Teclado.lerInteiro("Digite a nova quantidade de livros no estoque"));
				System.out.println("Livro alterado com sucesso");
				encontrado=1;
				break;
			}
		}
		if(encontrado!=1) {
			System.out.println("Livro não encontrado");
		}
	}
	private static void consultar(Livro[] livros) {
		System.out.println("Exibindo livros cadastrados");
		for(int i=0;i<livros.length;i++) {
			if(livros[i]!=null) {
				System.out.println(livros[i]);
			}
		}
		System.out.println("Exibido valor total do estoque= " + Livro.calcularValorTotalEstoque(livros));
	}
	private static void excluir(Livro[] livros) {
		int encontrado=0;
		int id=Teclado.lerInteiro("Digite o ID do livro que deseja excluir");
		for(int i=0;i<livros.length;i++) {
			if(livros[i]!=null && livros[i].getId()==id) {
				livros[i]=null;
				System.out.println("Livro excluído com sucesso");
				encontrado=1;
				break;
			}
		}	
		if(encontrado!=1) {
			System.out.println("Livro não encontrado");
		}
	}
}
