import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GeradorArquivo {
	
	public void escreveArquivo(Jogador jogador){
		String diretorioProjeto = System.getProperty("user.dir");
		File arquivo = new File(diretorioProjeto+".txt");
		 
		try {
			//Se o arquivo nao existir cria o arquivo
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			 
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			 
			bw.write("Nome do jogador: " + jogador.getNome() + " - Data: " + this.getDataDoDia() + " - Hora: "+this.getHora());
			 
			bw.newLine();
			 
			bw.close();
			fw.close();
			
			System.out.println("Arquivo gravado com sucesso...");
			System.out.println("=======================FIM DO JOGO==========================");
			 
		 
		} catch (IOException ex) {
		ex.printStackTrace();
		}
	}
	
	
	private String getDataDoDia() {
		return new SimpleDateFormat(JogoKeys.DATA_PADRAO).format(new Date());
	}
	
	private String getHora(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime(); 
		String dataFormatada = sdf.format(hora);
		return dataFormatada;
	}
	
	
	
}
