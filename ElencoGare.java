import java.util.*;

public class ElencoGare {

	private ArrayList<Gara> elencoGare;
	
	public ElencoGare() {
		
		elencoGare = new ArrayList<Gara>();
		
	}
	
	public void aggiungiGara(Gara nuovaGara) {
		
		elencoGare.add(nuovaGara);
		
	}
	
	public boolean presente(String nomeCarcato) {
		
		for (Gara g: elencoGare)
			if (g.getNome().equals(nomeCarcato)) return true;
		
		return false;
		
	}
	
	public Gara getGara(String nomeCercato) {
		
		for (Gara g: elencoGare)
			if (g.getNome().equals(nomeCercato)) return g;
		
		return null;
		
	}
	
}
