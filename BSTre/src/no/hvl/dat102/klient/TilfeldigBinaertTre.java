package no.hvl.dat102.klient;

import java.util.Random;

import no.hvl.dat102.*;

public class TilfeldigBinaertTre {

	public static void main(String[] args) {
		
		// Vi laget 100 bin�re s�ketre med 1023 noder med forskjellige sifre inni seg.


		int maksBST = 0;
		int minsteHoyde = 121;
		// tok minsteHoyde = 121 siden det var rundt gjennomsnittet og minsteHoyde
		// kommer h�yst sannsynlig til � v�re mindre enn gjennomsnittsh�yde.
		int storsteHoyde = 0;
		int gjennomsnittHoyde = 0;

		Random Tilfeldig = new Random();
		
		for (int j = 0; j < 100; j++) {
			KjedetBSTre bstre = new KjedetBSTre();
			for (int i = 0; i < 1023; i++) {

				bstre.leggTil(Tilfeldig.nextInt(10));

			}
			
			
			//tok kommentar her siden antall dekker mye av console
			//System.out.println(bstre.antall());
			
			
			//System.out.println(bstre.TreHoyde(bstre.getRot()));
			
			if(bstre.TreHoyde(bstre.getRot()) > storsteHoyde) {
				storsteHoyde = bstre.TreHoyde(bstre.getRot());
			}
			
			
			if(minsteHoyde > bstre.TreHoyde(bstre.getRot())) {
				minsteHoyde = bstre.TreHoyde(bstre.getRot());
			}
                
			
			gjennomsnittHoyde += bstre.TreHoyde(bstre.getRot());
			
			
			maksBST++;
			
		}
			System.out.print("st�rste h�yde:   ");
			System.out.println(storsteHoyde);
			System.out.print("Minste H�yde:   ");
			System.out.println(minsteHoyde);
			System.out.print("GjennomsnittsH�yde:   ");
			System.out.println(gjennomsnittHoyde/100);
			
			
	}

}
