import java.util.Arrays;
// This is a class there takes a array, integer or nothing and saves it in a sortede array
public class SorteretTabel {
	private int[] m_array;

	public SorteretTabel(int[] a) {
		this.m_array = new int[a.length];
		for(int i = 0; i < a.length; i++) { this.m_array[i] = a[i]; }
		
		// We simply use the build in sorting algorithm to sort.
		Arrays.sort(this.m_array);
	}

	public SorteretTabel(int a) {
		int[] a1 = {a};
		this.m_array = a1;
	}

	public SorteretTabel() {
		this.m_array = new int[0];
	}
// A method there printing the sorted array
	public String toString() {
		return Arrays.toString(this.m_array);
	}
	
	public void merge(SorteretTabel t) {
		
		// We compute the length of the new array.
		int n = this.m_array.length + t.m_array.length;
		
		// We instantiate variables for keeping track of indices.
		int i = 0;
		int j = 0;
		
		// We allocate the new array.
		int[] newArray = new int[n];
		
		// We loop over the indices of the new array.
		for(int k = 0; k < n; k++) {
			
			// If one array has no further elements then we
			// add the next element of the array with elements left.
			if(j >= t.m_array.length) {
				newArray[k] = this.m_array[i];
				i++;
			} else if(i >= this.m_array.length) {
				newArray[k] = t.m_array[j];
				j++;
				
			// Otherwise if the elements of the two arrays are not
			// equal then we add the smaller of the two to the new
		    // array and increment that arrays index.
			} else if(this.m_array[i] < t.m_array[j]) { 
				newArray[k] = this.m_array[i]; 
				i++;
			} else if(this.m_array[i] > t.m_array[j]) { 
				newArray[k] = t.m_array[j];
				j++;
				
			// Otherwise they are equal and we add both making sure
			// that the indices are handled correctly.
			} else {
				newArray[k] = this.m_array[i];
				k++;
				i++;
				
				newArray[k] = t.m_array[j];
				j++;
			}
		}
		
		// Finally we change the internal array to the newly created
		// one.
		this.m_array = newArray;
	}

	public int find(int holger){
		
		// We ensure that the array has at least one element.
		if(this.m_array.length < 1) { return -1; }
		
		// We set the values of the minimum and maximum indices.
		int min = 0; 
		int max = this.m_array.length - 1;
		
		return find(holger, min, max);
	}
	
	private int find(int holger, int min, int max) {
		
		// We compute the index of the middle element.
		int n = min + (int)((max - min) / 2);
		
		// If the middle element has the desired value then we return 
		// the index.
		if(this.m_array[n] == holger) { return n; }
		
		// If the minimum has reached (or passed) the maximum then
		// the desired value is not present.
		if(min >= max) { return -1; }
		
		// Otherwise if the middle element has a greater value then 
		// we repeat with the left half of the array.
		if(this.m_array[n] > holger) { 
			return find(holger, min, n - 1); 
			
		// Otherwise we repeat with the right half of the array.
		} else {
			return find(holger, n + 1, max); 
		}
	}
}



