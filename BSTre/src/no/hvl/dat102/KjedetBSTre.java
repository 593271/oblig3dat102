package no.hvl.dat102;

import java.util.Iterator;

//********************************************************************
// KjedetBin�rS�keTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt bin�rt s�ketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et bin�rt s�ketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	
	/**********************************************************************
	 * Legger det spesifiserte elementet p� passende plass i BS-treet. Like
	 * elementer blir lagt til h�yre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/

	@Override
    public void leggTil(T element )  { 
        rot = leggTilRek(rot, element); 
        antall++;
    } 
   
    //recursive insert function
    public BinaerTreNode<T> leggTilRek(BinaerTreNode<T> rot, T element) { 
          //tree is empty
        if (rot == null) { 
        	rot = new BinaerTreNode(element); 
            return rot; 
        } 
        //traverse the tree
        if (element.compareTo(rot.getElement()) < 0)     //insert in the left subtree
            rot.setVenstre(leggTilRek(rot.getVenstre(), element) );
        else if (element.compareTo(rot.getElement()) > 0)    //insert in the right subtree
        	rot.setHoyre((leggTilRek(rot.getHoyre(), element) ) );         // return pointer
        return rot; 
    } 

	/******************************************************************
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// 
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette bin�re s�ketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		BinaerTreNode<T> minste = null;
		finnMin(this.getRot())
		
		return null;
	}//

	/******************************************************************
	 * Fjerner noden med st�rste verdi fra dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		// TODO 
		return null;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMin(BinaerTreNode<T> p) {
		
		BinaerTreNode<T> current = p;
		
		  while (current.getVenstre() != null) { 
	            current = current.getVenstre(); 
	        } 
	        return (current.getElement()); 
		
		
	}//

	/******************************************************************
	 * Returnerer det st�rste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMaks(BinaerTreNode<T> p) {
		BinaerTreNode<T> current = p;
		
		  while (current.getHoyre() != null) { 
	            current = current.getHoyre(); 
	        } 
	        return (current.getElement()); 
		
		

    }//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		// S�k med rekursiv hjelpemetode

		// return finnRek(element, rot);
		return null;
	}

	// Den rekursive hjelpemetoden for s�king
	
	// TODO 

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO 
		return null;
	}
	

	


	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
		
	}
}// class
