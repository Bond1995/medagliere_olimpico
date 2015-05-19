public class Gara {
	private final static int NUMMEDAGLIE = 3;
	private String nome;
	private Nazione[] nazioniPremiate = new Nazione[NUMMEDAGLIE];
	private boolean eseguita = false;
	
	public Gara (String nome){
		
		this.nome= nome;
	}
	
	public void setEseguita(){
		
		eseguita = true;
		
	}
	
	public boolean giaPremiata (){
		
		return eseguita;
	}
	
	public void aggiungiPremiata (Nazione nazione, int i){
		
		nazioniPremiate[i] = nazione;
	}
	
	public Nazione[] getPremiate (){
		
		return nazioniPremiate;
	}
	
	public String getNome() {
		
		return nome;
		
	}
}
