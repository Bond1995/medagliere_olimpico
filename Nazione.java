package ing.unibs.esercitazioni.medagliere;

public class Nazione {
	
	private static final int NUMMEDAGLIE = 3;
	private String nomeNazione;
	private int medaglie[]= new int [NUMMEDAGLIE];
	private static final String MEDAGLIE_NAZIONE = "%s\t: N. ori: %d\tN. argenti: %d\tN. bronzi: %d";
	
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
			
			if (this.medaglie[i] > altraNazione.getMedaglie()[i])
				return true;
			else if (this.medaglie[i] < altraNazione.getMedaglie()[i]) 
				return false;
			else i++;
			
		} while (i < 3);
		
		return true;
	
	}
	
	@Override
	public String toString(){
		
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(MEDAGLIE_NAZIONE, nomeNazione, medaglie[0], medaglie[1], medaglie[2]));
		return builder.toString();
		
	}
}
