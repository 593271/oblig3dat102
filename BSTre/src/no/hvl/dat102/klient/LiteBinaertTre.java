package no.hvl.dat102.klient;

import no.hvl.dat102.BinaerTreNode;

import no.hvl.dat102.KjedetBSTre;



public class LiteBinaertTre {

	public static void main(String[] args) {
		
		KjedetBSTre bstre = new KjedetBSTre();

		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);	
		bstre.leggTil(1);	

	

		
		bstre.visInorden();
		System.out.println(bstre.antall());
		System.out.println(bstre.finnMin(bstre.getRot()));
		System.out.println(bstre.finnMaks(bstre.getRot()));
		
		
		
		

	}

}
