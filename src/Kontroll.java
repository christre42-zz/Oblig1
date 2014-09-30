

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Random;

/*
 * Skrevet av:
 * ===========
 * Christian Rennemo - 138043
 * Ståle Andre Volden - 138041
 */

public class Kontroll {
	
	Random tilfeldigOrd = new Random();
	
	int tilfeldigTall = 0;
	
	ArrayList<String> Ord = new ArrayList<String>();
	
	public void meny() {
		Boolean fortsett = true;
		final String[] ALTERNATIVER = {"Enkle dikt","Avanserte dikt","Avslutt"};
		
		while(fortsett) {
			int valg = JOptionPane.showOptionDialog(null,"Dine valg:", "Dikt",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,ALTERNATIVER,ALTERNATIVER[0]);
			
			switch(valg) {
			case 0: EnkleDikt();
			break;
			case 1: AvansertDikt();
			break;
			case 2: System.exit(0);  // avslutter programmet
			default:
				fortsett = false;
			} // Switch done
		} // While done			
	}  // Meny-method done
	
	
	/*
	 * Her kommer DEL 1 - LETTE DIKT
	 * 
	 */
	
	public void EnkleDikt() {
		Boolean fortsett = true;
		final String[] ALTERNATIVER = {"Registrer ord","Skriv dikt","Tilbake"};
		while(fortsett) {
			int valg = JOptionPane.showOptionDialog(null,"Dine valg:", "Enekelt dikt",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,ALTERNATIVER,ALTERNATIVER[0]);
			switch(valg) {
			case 0: LeggTilOrd();
			break;
			case 1: SkrivDikt();
			break;
			case 2: meny();
			default:
				fortsett = false;
			} // Switch done
		} // While done
	}  // EnkeltDikt-method done
	
	
	public void LeggTilOrd() {
		String ord = JOptionPane.showInputDialog("Skriv inn et ord: ");
		Ord.add(ord);
	}
	
	
	public void SkrivDikt() {
		int antOrd = Ord.size();
 		
		// Sjekker at det er nok ord til å skrive et dikt
		if (antOrd < 4) {
			JOptionPane.showMessageDialog(null, String.format("Du må regisrere flere ord før du kan generere et dikt."));
		} else {
			
			String uttekst = "";
			int i = 0;
			// fire linjer med fire ord på hver = 16 ord, derfor x < 16
			for(int x = 0; x < 16; x++) {
				tilfeldigTall = (int)(Math.random()*antOrd);
					if (i < 3) {
					String randomOrd = Ord.get(tilfeldigTall);
					uttekst = uttekst + randomOrd + " ";
					i++;
				} else {
					// etter 3 ord så legger vi til et ord til pluss et linjeskift
					String randomOrd = Ord.get(tilfeldigTall);
					uttekst = uttekst + randomOrd + "\n";
					i = 0;	
				}
			} //next
			
			// Skriver ut diktet
			JOptionPane.showMessageDialog(null, uttekst);
		} // else
		
	} //Skriv dikt()
	
	
	
	/*
	 * Her presenterer vi alternative løsninger til del 1
	 * ==================================================
	 * 
	 * 
	 * Til metoden SkrivDikt()
	 * =======================
	 * Vi kunne benyttes oss av kun en for-loop der vi bruker Random(), istedenfor math.random.
	 * 
	 *   for (int i = 0; i < 4; i++) {
	 *   String randomOrd = Ord.get(tilfeldigOrd.nextInt(Ord.size())) + " " + Ord.get(tilfeldigOrd.nextInt(Ord.size())) + " " + Ord.get(tilfeldigOrd.nextInt(Ord.size())) + " " + Ord.get(tilfeldigOrd.nextInt(Ord.size()));
	 *   uttekst = uttekst + randomOrd + "\n";
	 *   }
	 *   
	 *   
	 *   
	 * Til metoden SkrivDikt() - Alternativ løsing II
	 * ===============================================
	 * Vi vurderte også å benytte oss av en for-loop i en for-loop
	 * 
	 * for(int x = 0; x < 16; x++) {
	 * 		for (int i = 0; i < 4; i++) {
	 * 			// her finner til 4 tilfeldige ord til 1linje om gangen
	 * 		} // next i
	 * 		// også legger vi til en linje
	 * 		uttekst+= "\n"
	 * } // next x
	 * 
	 */
	
	
	
	/*
	 *  DEL 1 - LETTE DIKT er ferdig *  
	 */
	//===========================================================================================================================
	/*
	 * DEL 2 - Avanserte dikt begynner her 
	 */
	
	
	// Oppretter en liste til hver av de forskjellige ordtypene:
	ArrayList<String> Verb = new ArrayList<String>();
	ArrayList<String> Artikkel = new ArrayList<String>();
	ArrayList<String> Substantiv = new ArrayList<String>();
	ArrayList<String> Adjektiv = new ArrayList<String>();
	
	public void AvansertDikt() {
		Boolean fortsett = true;
		final String[] ALTERNATIVER = {"Registrer ord","Skriv dikt","Tilbake"};
		
		while(fortsett) {
			int valg = JOptionPane.showOptionDialog(null,"Dine valg:", "Avanserte dikt",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,ALTERNATIVER,ALTERNATIVER[0]);
			
			switch(valg) {
			case 0: RegistrerVanskligeOrd();
			break;
			case 1: SkrivAvansertDikt();
			break;
			case 2: meny();
			break;
			default:
				fortsett = false;
			} // Switch done
		} // While done
	}  // AvansertDikt-method done	
	
	
	public void RegistrerVanskligeOrd() {
		Boolean fortsett = true;
		final String[] ALTERNATIVER = {"Registrer Verb","Registrer Artikler","Registrer Substantiv","Registrer Adjektiv","Tilbake"};
		while(fortsett) {
			int valg = JOptionPane.showOptionDialog(null,"Dine valg:", "Legg til vanskelige ord",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,ALTERNATIVER,ALTERNATIVER[0]);
			switch(valg) {
			case 0: LeggTilVerb();
			break;
			case 1: LeggTilArtikler();
			break;
			case 2: LeggTilSubstantiv();
			break;
			case 3: LeggTilAdjektiv();
			break; 
			case 4: AvansertDikt();
			default:
				fortsett = false;
			} // Switch done
		} // While done
	} // Reg ord ferdig
	
	
	public void LeggTilVerb() {
		String verb = JOptionPane.showInputDialog("Skriv inn et verb(eks: løpe): ");
		Verb.add(verb);
		RegistrerVanskligeOrd();
	}
	
	public void LeggTilArtikler() {
		String artikkel = JOptionPane.showInputDialog("Skriv inn en artikkel(eks: \"den\"): ");
		Artikkel.add(artikkel);
		RegistrerVanskligeOrd();
	}
	
	public void LeggTilSubstantiv() {
		String substantiv = JOptionPane.showInputDialog("Skriv inn et substantiv(eks: boken): ");
		Substantiv.add(substantiv);
		RegistrerVanskligeOrd();
	}
	
	public void LeggTilAdjektiv() {
		String adjektiv = JOptionPane.showInputDialog("Skriv inn et adjektiv(eks: grønne): ");
		Adjektiv.add(adjektiv);
		RegistrerVanskligeOrd();
		
	}
	
	
	public void SkrivAvansertDikt() {
		int antOrd = Artikkel.size() * Substantiv.size() * Verb.size() * Adjektiv.size();
		
		// Så lenge alle listene inneholder minst ett ord kan du skrive et dikt
	if (antOrd  < 1) {
			JOptionPane.showMessageDialog(null, String.format("Du må regisrere flere ord før du kan generere et dikt."));
		} else {
		
			String uttekst = "";
			int teller = 0;
					
	/*
	 * Info om valg av loop mm.
	 * ========================
	 * I del 1 brukte vi Math.Random til å finne et tilfeldig tall.
	 * I del 2 har vi valg å bruke Random() til å finne et tilfeldig tall
	 * 
	 *  Her skriver vi bare tilfeldigOrd = new Random()
	 *  
	 *  også: tilfeldigOrd.nextInt(Array.Størrelse());
	 *  
	 *  Denne lager et nytt tilfeldig tall hver gang vi kaller random, vi syns den passet bedre inn i dette tilfellet enn Math.Random
	 *  ettersom Math.Random må opprettes på nytt hvergang vi skal bruke den "(tilfeldigTall = (int)(Math.random()*antOrd);)", for å få et nytt tall. 
	 *  Og det virket tungvint å legge alt i masse looper kun for å benytte Math.Random
	 * 
	 */

				for (int i = 0; i < 4; i++) {
					
					if (teller < 3) {
						String randomOrd = Artikkel.get(tilfeldigOrd.nextInt(Artikkel.size())) + " " + Adjektiv.get(tilfeldigOrd.nextInt(Adjektiv.size())) + " " + 
								Substantiv.get(tilfeldigOrd.nextInt(Substantiv.size())) + " " + Verb.get(tilfeldigOrd.nextInt(Verb.size()));
								uttekst = uttekst + randomOrd + "\n";	
								teller+= 1;
					} else {
						// her legger vi til ord i annen rekkefølge, hvis det er fjerde og siste linje i diktet
						String randomOrd = Verb.get(tilfeldigOrd.nextInt(Verb.size())) + " " + Artikkel.get(tilfeldigOrd.nextInt(Artikkel.size())) + " " + 
								Adjektiv.get(tilfeldigOrd.nextInt(Adjektiv.size())) + " " + Substantiv.get(tilfeldigOrd.nextInt(Substantiv.size()));			
								uttekst = uttekst + randomOrd + "?\n";
					}
			
				} // next
				uttekst+= "\n";
			//} //next 
			// Skriver ut diktet
			JOptionPane.showMessageDialog(null, uttekst);
		} // else
	}
	
	
	
}  // Klasse slutt 






