import ing.unibs.esercitazioni.mylib.*;

public class MedagliereMain {

	private static final String SALUTO = "Ciao e Benvenuto nel tuo Medagliere Olimpico!\n";
	private static final String ARRIVEDERCI = "Grazie e arrivederci!";
	private static final String TITOLO = "Elenco funzioni:\n";
	private static final String ERRORE_SCELTA = "Attenzione: e' stata scelta un'opzione inesistente!";
	private static final String MESS_NUOVA_NAZIONE = "Inserisci il nome della nuova nazione:";
	private static final String ERRORE_NAZIONE_DOPPIA = "Attenzione: la nazione inserita è già presente!";
	private static final String MESS_NUOVA_GARA = "Inserisci il nome della nuova gara:";
	private static final String ERRORE_GARA_DOPPIA = "Attenzione: la gara inserita è già presente!";
	private static final String MESS_INSERISCI_GARA = "Inserisci il nome della gara:";
	private static final String ERRORE_NAZIONE_NON_PRESENTE = "Attenzione: la nazione inserita non è presente in elenco!";
	private static final String ERRORE_GARA_NON_PRESENTE = "Attenzione: la gara inserita non è presente in elenco!";
	private static final String RICHIESTA_NUOVO_RISULTATO = "La gara inserita ha già un risultato. Vuoi sovrascriverlo?";
	private static final String MESS_NAZIONE_ORO = "Inserisci la nazione a cui assegnare la medaglia d'oro:";
	private static final String MESS_NAZIONE_ARGENTO = "Inserisci la nazione a cui assegnare la medaglia d'argento:";
	private static final String MESS_NAZIONE_BRONZO = "Inserisci la nazione a cui assegnare la medaglia di bronzo:";
	
	
	public static final String[] VOCI = {"Esci", "Aggiungi nazione", "Aggiungi gara", "Inserisci risultato", "Visualizza medagliere"};
	
	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		MyMenu menu = new MyMenu(TITOLO, VOCI);
		ElencoNazioni mieNazioni = new ElencoNazioni();
		ElencoGare mieGare = new ElencoGare();
		
		int scelta = 0;
		
		do {
			
			scelta = menu.scegliVoce();
			if (scelta != 0) eseguiScelta(scelta, mieNazioni, mieGare);
			
		} while (scelta != 0);
		
		System.out.println(ARRIVEDERCI);
		
	}
	
	private static void eseguiScelta(int scelta, ElencoNazioni mieNazioni, ElencoGare mieGare) {
		
		switch (scelta) {
		
		case 1: addNazione(mieNazioni); break;
		
		case 2: addGara(mieGare); break;
		
		case 3: addRisultato(mieNazioni, mieGare); break;
		
		case 4: showMedagliere(mieNazioni); break;
		
		default: System.out.println(ERRORE_SCELTA);
		
		}
		
	}
	
	private static void addNazione(ElencoNazioni mieNazioni) {
		
		System.out.println(MESS_NUOVA_NAZIONE);
		String nomeNazione = MyUtil.leggiStringaConSpazi();
		
		if (mieNazioni.presente(nomeNazione)) System.out.println(ERRORE_NAZIONE_DOPPIA);
		else {
			
			Nazione nuovaNazione = new Nazione(nomeNazione);
			mieNazioni.aggiungiNazione(nuovaNazione);
			
		}
		
	}
	
	private static void addGara(ElencoGare mieGare) {
		
		System.out.println(MESS_NUOVA_GARA);
		String nomeGara = MyUtil.leggiStringaConSpazi();
		
		if (mieGare.presente(nomeGara)) System.out.println(ERRORE_GARA_DOPPIA);
		else {
			
			Gara nuovaGara = new Gara(nomeGara);
			mieGare.aggiungiGara(nuovaGara);
			
		}
		
	}
	
	private static void addRisultato(ElencoNazioni mieNazioni, ElencoGare mieGare) {
		
		System.out.println(MESS_INSERISCI_GARA);
		String nomeGara = MyUtil.leggiStringaConSpazi();
		boolean scelta = true;
		
		if (!mieGare.presente(nomeGara)) System.out.println(ERRORE_GARA_NON_PRESENTE);
		else {
			
			if (mieGare.getGara(nomeGara).haRisultato)
				scelta = MyUtil.yesOrNo(RICHIESTA_NUOVO_RISULTATO);
			
			if (scelta) {
				
				Nazione nazioneOro = trovaNazione(MESS_NAZIONE_ORO, mieNazioni);
				Nazione nazioneArgento = trovaNazione(MESS_NAZIONE_ARGENTO, mieNazioni);
				Nazione nazioneBronzo = trovaNazione(MESS_NAZIONE_BRONZO, mieNazioni);
				
				Gara gara = mieGare.getGara(nomeGara);
				gara.aggiungiRisultato(nazioneOro, nazioneArgento, nazioneBronzo);
				nazioneOro.aggiungiMedaglia(0);
				nazioneArgento.aggiungiMedaglia(1);
				nazioneBronzo.aggiungiMedaglia(2);
				
			}
			
		}
		
	}
	
	private static Nazione trovaNazione(String messaggio, ElencoNazioni mieNazioni) {
		
		System.out.println(messaggio);
		String nazione = null;
		
		do {
			
			nazione = MyUtil.leggiStringaConSpazi();
			if (!mieNazioni.presente(nazione)) System.out.println(ERRORE_NAZIONE_NON_PRESENTE);
		
		} while (!mieNazioni.presente(nazione));
		
		return mieNazioni.getNazione(nazione);
		
	}
	
	private static void showMedagliere(ElencoNazioni mieNazioni) {
		
		System.out.println(mieNazioni.toString());
		
	}
	
}
