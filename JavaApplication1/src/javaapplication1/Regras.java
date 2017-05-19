import java.util.LinkedList;
import java.util.Random;

/**
 * Classe que continua o jogo
 * @author Bruno da Silva Andrade
 */

public class Regras {
	
	public int contador;
        public	int[] vetorcorreto = new int[3];	
	private int i,j;
	private LinkedList<String> resultado = new LinkedList<String>();
	private Random gerador = new Random();
	public int venceu=0;

	
	/**
	 * O m�todo construtor chama o m�todo Random() que � respons�vel por gerar um vetor aleat�rio com membros distintos.
	 */
	//construtor da classe que gera um vetor com valores corretos quando instanciado
	public Regras(){				
		Random();		
	}
	
	
	/**
	 * M�todo que confere se os valores inseridos pelo usu�rio correspondem aos valores corretos. Ap�s a confer�ncia
	 * s�o impressas dicas ao usu�rio conforme seus palpites.
	 * 
	 * @param palpite � um vetor de n�meros inteiros que cont�m os valores imaginados pelo jogador como corretos.
	 * 
	 */
	public void Tentar (int[] palpite){
		
		resultado.clear();
		
		resultado.add("Nano");
		resultado.add("Nano");
		resultado.add("Nano");
		
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				if(palpite[i]==vetorcorreto[j] && i==j)
				{
					resultado.remove("Nano");
					resultado.add("Fermi");
				}
					
				if(palpite[i]==vetorcorreto[j] && i!=j)
				{
					resultado.remove("Nano");
					resultado.add("Pico");
				}
			}
		}		
		
		System.out.println(resultado);
		
		if(resultado.get(0).equals("Fermi") && resultado.get(1).equals("Fermi") && resultado.get(2).equals("Fermi"))
			venceu=100;
		
		contador+=1;
	}
	
	/**
	 * M�todo que retorna quantas vezes o usu�rio inseriu palpites.
	 * @return contador � um atributo da classe que cont�m quantas vezes o usu�rio inseriu palpites.
	 *
	 */
	
	public int getTentativas(){
		return contador;
	}
	
	
	/**
	 * M�todo que gera um vetor com 3 valores inteiros e distintos aleat�riamente.
	 *
	 */
	
	public void Random(){				
		vetorcorreto[0] = gerador.nextInt(9);
		vetorcorreto[1] = gerador.nextInt(9);
		vetorcorreto[2] = gerador.nextInt(9);
		
		if(vetorcorreto[0]==vetorcorreto[1] || vetorcorreto[1]==vetorcorreto[2] ||vetorcorreto[0]==vetorcorreto[2])
		{
			Random();
		}
		else //funcao que imprimi os valores gerados
		{
		System.out.printf("%d %d %d ",vetorcorreto[0],vetorcorreto[1],vetorcorreto[2]);
		}

	}
	
}
