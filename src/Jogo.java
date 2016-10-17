import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

	private static Scanner leitorTeclado;

	public static void main(String[] args) throws IOException {
		Tabuleiro tabuleiro;
		Impressora impressora;
		Jogador jogador; 
		Jogador jogador2;
		String nomeJogador1="";
		String nomeJogador2="";
		leitorTeclado = new Scanner(System.in);
		Random gerador = new Random();
		GeradorArquivo geradorArquivo = new GeradorArquivo();
		int linha = 0;
		int coluna = 0;
		int rodadas = 0;
		boolean jogador1Venceu = false;
		
		System.out.println("Jogo Iniciado...");
		System.out.println("Deseja jogar contra o Computador... S-Sim N-Nao");
		String opcao = leitorTeclado.nextLine();
		
		if(JogoKeys.SIM.equalsIgnoreCase(opcao)){
			tabuleiro = new Tabuleiro();
			impressora = new Impressora();
			jogador = new Jogador();
			jogador2 = new Jogador();

			System.out.println("Digite seu nome: ");
			nomeJogador1 = leitorTeclado.nextLine();
			jogador.setNome(nomeJogador1);
			jogador2.setNome("Computador");
			System.out.println("Ola "+ jogador.getNome());
			
			System.out.println("Computador iniciara jogando...");
			linha = gerador.nextInt(3);
			coluna = gerador.nextInt(3);
			while (!tabuleiro.existeVencedor()) {
				rodadas++;
				if (rodadas > 4) {
					System.out.println("Deu velha !!! ");
					jogador1Venceu = true;
					break;
				}
				while(!jogador2.verificaJogada(linha, coluna, 2, tabuleiro)){
					linha = gerador.nextInt(3);
					coluna = gerador.nextInt(3);
				}
				impressora.imprimirTabuleiro(tabuleiro.getTabuleiro());
				if(tabuleiro.existeVencedor()){
					System.out.println("Computador venceu... Escrevendo no arquivo...");
					geradorArquivo.escreveArquivo(jogador2);
					jogador1Venceu = true;
					break;
				}
				
				System.out.println("Computador jogou...");
				System.out.println("Sua vez...");
				System.out.println("Digite a linha que deseja jogar de 0 a 2: ");
				linha = leitorTeclado.nextInt();
				System.out.println("Digite a coluna que deseja jogar de 0 a 2: ");
				coluna = leitorTeclado.nextInt();
				while(!jogador.verificaJogada(linha, coluna, 1, tabuleiro)){
					System.out.println("Campo ja preenchido favor escolher outra posicao");
					System.out.println("Digite a linha que deseja jogar de 0 a 2: ");
					linha = leitorTeclado.nextInt();
					System.out.println("Digite a coluna que deseja jogar de 0 a 2: ");
					coluna = leitorTeclado.nextInt();
				}
				Impressora.limparTela();
			}
			if(!jogador1Venceu){
				System.out.println("Jogador Venceu... Escrevendo no arquivo...");
				geradorArquivo.escreveArquivo(jogador);
			}
		}else if(JogoKeys.NAO.equalsIgnoreCase(opcao)){
			tabuleiro = new Tabuleiro();
			impressora = new Impressora();
			jogador = new Jogador();
			jogador2 = new Jogador();
			
			System.out.println("Digite o nome do jogador 1: ");
			nomeJogador1 = leitorTeclado.nextLine();
			jogador.setNome(nomeJogador1);
			System.out.println("Digite o nome do jogador 2: ");
			nomeJogador2 = leitorTeclado.nextLine();
			jogador2.setNome(nomeJogador2);
			
			impressora.imprimirTabuleiro(tabuleiro.getTabuleiro());
			System.out.println("Jogador 1 iniciara jogando...");
			System.out.println("Jogador 1 - Digite a linha que deseja jogar de 0 a 2: ");
			linha = leitorTeclado.nextInt();
			System.out.println("Jogador 1 - Digite a coluna que deseja jogar de 0 a 2: ");
			coluna = leitorTeclado.nextInt();
			while (!tabuleiro.existeVencedor()) {
				Impressora.limparTela();
				impressora.imprimirTabuleiro(tabuleiro.getTabuleiro());
				
				if(rodadas > 0){
					System.out.println("Jogador 2 jogou...");
					System.out.println("Jogador 1 Sua vez...");
					System.out.println("Jogador 1 - Digite a linha que deseja jogar de 0 a 2: ");
					linha = leitorTeclado.nextInt();
					System.out.println("Jogador 1 - Digite a coluna que deseja jogar de 0 a 2: ");
					coluna = leitorTeclado.nextInt();
				}

				rodadas++;
				if (rodadas > 4) {
					System.out.println("Deu velha !!! ");
					jogador1Venceu = true;
					break;
				}
				
				
				while(!jogador.verificaJogada(linha, coluna, 1, tabuleiro)){
					System.out.println("Campo ja preenchido favor escolher outra posicao");
					System.out.println("Jogador 1 - Digite a linha que deseja jogar de 0 a 2: ");
					linha = leitorTeclado.nextInt();
					System.out.println("Jogador 1 - Digite a coluna que deseja jogar de 0 a 2: ");
					coluna = leitorTeclado.nextInt();
				}
				Impressora.limparTela();
				impressora.imprimirTabuleiro(tabuleiro.getTabuleiro());
				
				if(tabuleiro.existeVencedor()){
					System.out.println("Jogador 1 venceu... Escrevendo no arquivo...");
					geradorArquivo.escreveArquivo(jogador);
					jogador1Venceu = true;
					break;
				}
				
				System.out.println("Jogador 1 jogou...");
				System.out.println("Jogador 2 Sua vez...");
				System.out.println("Jogador 2 - Digite a linha que deseja jogar de 0 a 2: ");
				linha = leitorTeclado.nextInt();
				System.out.println("Jogador 2 - Digite a coluna que deseja jogar de 0 a 2: ");
				coluna = leitorTeclado.nextInt();
				while(!jogador2.verificaJogada(linha, coluna, 2, tabuleiro)){
					System.out.println("Campo ja preenchido favor escolher outra posicao");
					System.out.println("Jogador 2 - Digite a linha que deseja jogar de 0 a 2: ");
					linha = leitorTeclado.nextInt();
					System.out.println("Jogador 2 - Digite a coluna que deseja jogar de 0 a 2: ");
					coluna = leitorTeclado.nextInt();
				}
			}
			if(!jogador1Venceu){
				System.out.println("Jogador 2 Venceu... Escrevendo no arquivo...");
				geradorArquivo.escreveArquivo(jogador2);
			}
		}else{
			System.out.println("Opcao invalida jogo encerrado...");
		}
	}
}
