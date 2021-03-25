package no.hvl.dat102;

import java.util.Iterator;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

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
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/


	
	public int TreHoyde(BinaerTreNode<T> rot) {
        if (rot == null)
            return -1;
        else
        {

            int VHoyde = TreHoyde(rot.getVenstre());
            int rDepth = TreHoyde(rot.getHoyre());

            if (VHoyde > rDepth)
                return (VHoyde + 1);
             else
                return (rDepth + 1);
        }
    }
	
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}
	
	// recursive insert function
	public BinaerTreNode<T> leggTilRek(BinaerTreNode<T> rot, T element) {
		// tree is empty
		if (rot == null) {
			rot = new BinaerTreNode(element);
			return rot;
		}
		// traverse the tree
		if (element.compareTo(rot.getElement()) < 0) // insert in the left subtree
			rot.setVenstre(leggTilRek(rot.getVenstre(), element));
		else if (element.compareTo(rot.getElement()) >= 0) // insert in the right subtree
			rot.setHoyre((leggTilRek(rot.getHoyre(), element))); // return pointer
		return rot;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		//
	}

	@Override
	public T fjern(T element) {

		rot = fjernRek(rot, element);
		return element;

	}

	/*
	 * A recursive function to delete an existing key in BST Otherwise, recur down
	 * the tree
	 */

	public BinaerTreNode<T> fjernRek(BinaerTreNode<T> rot, T element) {

		if (rot == null)
			return rot;

		if (element.compareTo(rot.getElement()) < 0)
			rot.setVenstre(fjernRek(rot.getVenstre(), element));
		else if (element.compareTo(rot.getElement()) > 0)
			rot.setHoyre(fjernRek(rot.getHoyre(), element));

		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else {
			// node with only one child or no child
			if (rot.getVenstre() == null)
				return rot.getHoyre();
			else if (rot.getHoyre() == null)
				return rot.getVenstre();

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			rot.setElement(finnMin());

			// Delete the inorder successor
			rot.setHoyre(fjernRek(rot.getHoyre(), rot.getElement()));
		}

		return rot;

	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		return fjern(finnMin());
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		return fjern(finnMaks());
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {

		BinaerTreNode<T> current = rot;

		while (current.getVenstre() != null) {
			current = current.getVenstre();
		}
		return (current.getElement());

	}//

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		BinaerTreNode<T> current = rot;

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
		// Søk med rekursiv hjelpemetode

		// return finnRek(element, rot);
		return finnRek(element, rot);

	}

	public T finnRek(T element, BinaerTreNode<T> p) {
		// if (p == null) -> tomt tre, basis - gjør ingenting
		T svar = null;
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) { // basis
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finnRek(element, p.getVenstre());
			} else {
				svar = finnRek(element, p.getHoyre());

			}
		}

		return svar;
	}

	// TODO

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		try {
			T svar = null;

			while (element != null) {
				if (rot.getElement() == element)
					return svar;

				if (element.compareTo(rot.getElement()) < 0) {
					rot = rot.getVenstre();
					svar = rot.getElement();
				}

				else if (element.compareTo(rot.getElement()) > 0)
					rot = rot.getHoyre();
				svar = rot.getElement();

			}
			return svar;
		} catch (NullPointerException e) {
			return null;
		}

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
