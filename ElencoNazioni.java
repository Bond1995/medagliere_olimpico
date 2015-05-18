import java.util.*;

public class ElencoNazioni {

	private static final String INTESTAZIONE_MEDAGLIERE = "Classifica Nazioni:\n";
	private static final String CLASSIFICA = "%d - %s%n";
	private ArrayList<Nazione> elencoNazioni;
	
	public ElencoNazioni() {
		
		elencoNazioni = new ArrayList<Nazione>();
		
	}
	
	public void aggiungiNazione(Nazione nuovaNazione) {
		
		elencoNazioni.add(nuovaNazione);
		
	}
	
	public int getNumeroNazioni() {
		
		return elencoNazioni.size();
		
	}
	
	public boolean presente(String nomeCarcato) {
		
		for (Nazione n: elencoNazioni) 
			if (n.getNome().equals(nomeCarcato)) return true;
		
		return false;
		
	}
	
	public Nazione getNazione(String nomeCercato) {
		
		for (Nazione n: elencoNazioni)
			if (n.getNome().equals(nomeCercato)) return g;
		
		return null;
		
	}
	
	public void ordinaNazioni() {
		
		for (int i = elencoNazioni.size() - 1; i >= 0; i--)
			for (int j = 0; j < i; j++)
				if (elencoNazioni.get(j).miglioreDi(elencoNazioni.get(j + 1))) {
					
					Nazione temp = elencoNazioni.get(j);
					elencoNazioni.set(j, elencoNazioni.get(j + 1));
					elencoNazioni.set((j + 1), temp);
					
				}
		
	}
	
	@Override
	public String toString() {
		
		this.ordinaNazioni();
		
		StringBuilder builder = new StringBuilder(INTESTAZIONE_MEDAGLIERE);
		
		for (int i = 0; i < elencoNazioni.size(); i++)
			builder.append(String.format(CLASSIFICA, (i + 1), elencoNazioni.get(i).toString()));
		
		return builder.toString();
		
	}
	
}
