
public class Jogador {
	private String nome;
	
	public boolean verificaJogada(int linha, int coluna, int jogador, Tabuleiro tabuleiro){
		return tabuleiro.marcarPosicao(linha, coluna, jogador);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
