
/*Author Kalle Jongberg
 * 20/11 2018
 * this is a funktion there is deviding an array to an array with one element, and after that, merging them together.
 * 
 */
import java.util.Arrays;

public class Sortering {

	public static int[] fletteSortering(int[] rodetArray ){
		// if the array has the length one the funktion returns the value
	if( rodetArray.length <= 1) {
		return rodetArray;
	}
	// calling the funktion rekusiv to the lengt is 1 and after merging the arrays together
	int n = rodetArray.length/2;
	int[] arr1 = Arrays.copyOfRange(rodetArray,0,n);
	int[] arr2 = Arrays.copyOfRange(rodetArray,n,rodetArray.length);
	arr1 = fletteSortering(arr1);
	arr2 = fletteSortering(arr2);
	return merge(arr1, arr2);
	
	
	
	

		
		
	}
	
	// made with Matteo Vogt.
public static int[] merge(int[] t, int[] m) {
		
		// We compute the length of the new array.
		int n = t.length + m.length;
		
		// We instantiate variables for keeping track of indices.
		int i = 0;
		int j = 0;
		
		// We allocate the new array.
		int[] newArray = new int[n];
		
		// We loop over the indices of the new array.
		for(int k = 0; k < n; k++) {
			
			// If one array has no further elements then we
			// add the next element of the array with elements left.
			if(j >= m.length) {
				newArray[k] = t[i];
				i++;
			} else if(i >= t.length) {
				newArray[k] = m[j];
				j++;
				
			// Otherwise if the elements of the two arrays are not
			// equal then we add the smaller of the two to the new
		    // array and increment that arrays index.
			} else if(t[i] < m[j]) { 
				newArray[k] = t[i]; 
				i++;
			} else if(t[i] > m[j]) { 
				newArray[k] = m[j];
				j++;
				
			// Otherwise they are equal and we add both making sure
			// that the indices are handled correctly.
			} else {
				newArray[k] = t[i];
				k++;
				i++;
				
				newArray[k] = m[j];
				j++;
			}
		}
		
		// Finally we change the internal array to the newly created
		// one.
		return newArray;
	}
}
