
public class Impressora {
	
	public void imprimirTabuleiro(int[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			imprimirLinha(i,tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
		}
	}
	
	private void imprimirLinha(int linha, int valorA, int valorB, int valorC) {
		String valorTextoA = " ";
		String valorTextoB = " ";
		String valorTextoC = " ";

		if(valorA == 1){
			valorTextoA = "X";
		}else if(valorA == 2){
			valorTextoA = "O";
		}
		if(valorB == 1){
			valorTextoB= "X";
		}else if(valorB == 2){
			valorTextoB = "O";
		}
		if(valorC == 1){
			valorTextoC = "X";
		}else if(valorC == 2){
			valorTextoC = "O";
		}
		
		if(linha == 0){
			System.out.println("     0          1          2     ");
		}
		System.out.println("           |          |          ");
		System.out.println("           |          |          ");
		if(linha == 0){
			System.out.println("0    " +valorTextoA +"     |    "  +valorTextoB+"     |    "  +valorTextoC+"       ");
		}else if(linha == 1){
			System.out.println("1    " +valorTextoA +"     |    "  +valorTextoB+"     |    "  +valorTextoC+"       ");
		}else{
			System.out.println("2    " +valorTextoA +"     |    "  +valorTextoB+"     |    "  +valorTextoC+"       ");
		}
		
		System.out.println("           |          |          ");
		if(linha == 2){
			System.out.println("           |          |          ");
		}else{
			System.out.println(" __________|__________|__________");
		}
	}
	
	public final static void limparTela(){
		for(int i = 0; i < 100; i++){
		       System.out.println("");
		}
    }

}
