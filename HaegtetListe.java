package uge12;
// Author Kalle Jongberg 
// Made 27/11 2017

//Denne klasse udnytter hægtet liste til hurtigt at kunne ligge elementer til, og søge efter elementer.

public class HaegtetListe<T> {
	private HaegtetListe<T> resten;
	private T element;
	public HaegtetListe(){
		// making element to use
		element = null;
		resten = null;
	}
	// konstrukter making
	private HaegtetListe(T t, HaegtetListe<T> resten) {
		if (t == null) {throw new IllegalArgumentException("noop");}
		else {this.element = t;}
		this.resten = resten;
		
	}
	// making add funktion
	public void add(T t){
		if(element != null) {
			// setting the old element to rest.
			this.resten = new HaegtetListe(this.element, this.resten);
		}
		// setting the new funktion as input.
		this.element = t;
	}
	// Funktion there made the elemts to a string.
	public String toString() {
		if(resten == null) return element+"";
		return element + ", " + resten ;
	}
	// cheking if the element is a part of the list.
	public boolean contains(T t) {
	
		if(t == this.element) {return true;}
		else if (resten == null) {return false;}
		// if the element is't null or the input t, the funktion is calld rekusivt.
		else{return this.resten.contains(t);}
	}
}
