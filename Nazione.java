
public class Nazione {
	private String nomeNazione;
	private int medaglie[]= new int [3];
	
	public Nazione (String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}
	
	public  String getNome (){
		return nomeNazione;
	}
	
	public void aggiungiMedaglia(int i){
		medaglie[i] ++;
	}
	
	public int[] getMedaglie() {
		return medaglie;
	}
	
	public boolean meglioDi(Nazione altraNazione){
			int i = 0;
		do{
			if (this.medaglie[i]> altraNazione.getMedaglie()[i]){
				i++;
			}
			else 
				return false;
		}while (i<=2);
		return true;
	
	}
}
