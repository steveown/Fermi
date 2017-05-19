import java.util.Scanner;
/**
 * Classe principal que roda o jogo de Fermi
 * @author Bruno da Silva Andrade
 */
public class JogoFermi {
	private static int[] vetorpalpite = new int[3];
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Metodo main que gerencia o jogo.
	 */
	public static void main (String[] args){
		
		String parar;		
			
		Regras novojogo = new Regras();
				
				
		//Looping com o jogo
		while(true)
		{
			System.out.println("");
			System.out.println("Digite sua tentativa (3 valores distintos):");
			Receber();
			
			novojogo.Tentar(vetorpalpite);
			
			if(novojogo.venceu==100)
			{
				System.out.println("Voc� venceu!");
				break;
			}
			System.out.println("");
			System.out.println("PRESS ANYTHING TO CONTINUE OR 1 TO STOP");
			parar  = scan.next();
			if (parar.equals("1"))
				break; 
		}			
		
		
		//Impressao do numero de tentativas		
		System.out.println("Numero de tentativas "+novojogo.getTentativas());			
	}
	
	
	public static void Receber(){
		int i;
		
		for(i=0;i<3;i++)
		{
			vetorpalpite[i] = scan.nextInt();
		}
		
		if(vetorpalpite[0]==vetorpalpite[1] || vetorpalpite[1]==vetorpalpite[2] ||vetorpalpite[0]==vetorpalpite[2])
		{
			System.out.println("Os valores devem ser distintos. Digite novamente:");
			Receber();
		}
	}
}
