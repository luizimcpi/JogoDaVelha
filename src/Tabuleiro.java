
public class Tabuleiro {
	private int tabuleiro [][] = new int[3][3];

	
	public boolean marcarPosicao(int linha, int coluna, int jogador){
		if(tabuleiro[linha][coluna] != 0){
			return false;
		}
		tabuleiro[linha][coluna] = jogador;
		return true;
	}
	
	public boolean existeVencedor(){
		//Verifica Vencedor nas Linhas
		for (int i = 0; i < tabuleiro.length; i++) {
			if(tabuleiro[i][0] != 0){
				if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] ){
					return true;
				}		
			}
		}
		//Verifica Vencedor nas Colunas
		for (int j = 0; j < tabuleiro.length; j++) {
			if(tabuleiro[0][j] != 0){
				if(tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[0][j] == tabuleiro[2][j] ){
					return true;
				}		
			}
		}
		//Verifica vencedor nas diagonais
		if(tabuleiro[0][0]!=0 && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]){
			return true;
		}
		if(tabuleiro[0][2]!=0 && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]){
			return true;
		}
		return false;
	}
	
	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int tabuleiro[][]) {
		this.tabuleiro = tabuleiro;
	}
}
