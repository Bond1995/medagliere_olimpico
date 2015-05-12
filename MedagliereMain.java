import ing.unibs.esercitazioni.mylib.*;

public class MedagliereMain {

	public static final String SALUTO = "Ciao e Benvenuto nel tuo Medagliere Olimpico!\n";
	public static final String ARRIVEDERCI = "Grazie e arrivederci!";
	public static final String TITOLO = "Elenco funzioni:\n";
	public static final String ERRORE_SCELTA = "Attenzione: e' stata scelta un'opzione inesistente!";
	
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
	
	public static void eseguiScelta(int scelta) {
		
		switch (scelta) {
		
		case 1: addNazione(mieNazioni); break;
		
		case 2: addGara(mieGare); break;
		
		case 3: addRisultato(mieNazioni, mieGare); break;
		
		case 4: showMedagliere(mieNazioni); break;
		
		default: System.out.println(ERRORE_SCELTA);
		
		}
		
	}
	
	public static void addNazione(ElencoNazioni mieNazioni) {
		
		System.out.println(MESS_NUOVA_NAZIONE);
		String nomeNazione = MyUtil.leggiStringaConSpazi();
		
		if (mieNazioni.contiene(nomeNazione)) System.out.println(ERRORE_NAZIONE_DOPPIA);
		else {
			
			Nazione nuovaNazione = new Nazione(nomeNazione);
			mieNazioni.aggiungiNazione(nuovaNazione);
			
		}
		
	}
	
	public static void addGara(ElencoGare mieGare) {
		
		System.out.println(MESS_NUOVA_GARA);
		String nomeGara = MyUtil.leggiStringaConSpazi();
		
		if (mieGare.contiene(nomeGara)) System.out.println(ERRORE_GARA_DOPPIA);
		else {
			
			Gara nuovaGara = new Gara(nomeGara);
			mieGare.aggiungiGara(nuovaGara);
			
		}
		
	}
	
	public static void addRisultato(ElencoNazioni mieNazioni, ElencoGare mieGare) {
		
		System.out.println(MESS_INSERISCI_GARA);
		String nomeGara = MyUtil.leggiStringaConSpazi();
		
		if (!mieGare.contiene(nomeGara)) System.out.println(ERRORE_GARA_NON_PRESENTE);
		else {
			
			Nazione nazioneOro = assegnaMedaglia(MESS_NAZIONE_ORO, mieNazioni);
			Nazione nazioneArgento = assegnaMedaglia(MESS_NAZIONE_ARGENTO, mieNazioni);
			Nazione nazioneBronzo = assegnaMedaglia(MESS_NAZIONE_BRONZO, mieNazioni);
			
			Gara gara = mieGare.getGara(nomeGara);
			gara.aggiungiRisultato(nazioneOro, nazioneArgento, nazioneBronzo);
			nazioneOro.aggiungiOro();
			nazioneArgento.aggiungiArgento();
			nazioneBronzo.aggiungiBronzo();
			
		}
		
	}
	
	public static Nazione assegnaMedaglia(String messaggio, ElencoNazioni mieNazioni) {
		
		System.out.println(messaggio);
		String nazione = null;
		
		do {
			
			nazione = MyUtil.leggiStringaConSpazi();
			if (!mieNazioni.contiene(nazione)) System.out.println(ERRORE_NAZIONE_NON_PRESENTE);
		
		} while (!mieNazioni.contiene(nazione));
		
		return mieNazioni.getNazione(nazione);
		
	}
}
