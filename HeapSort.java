public class HeapSort{
	public static void main(String[] args) {
		int  a [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int b [] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int c [] = {5,15,7,18,2,8,20,11,1,3,19,12,14,6,17,4,9,10,13,16};

		int d [] = {5,15,7,18,2,8,20,11,1,3,19,12,14,6,17,4,9,10,13,16};

		int e [] = {5,15,7,18,2,8,20,11,1,3,19,12,14,6,17,4,9,10,13,16};

		int f [] = {5,4,3,2,1};

		recursiveHeapSort(f);	
		for (int z = 0; z<f.length;z++){
			System.out.println(f[z]);
		}


		recursiveBuildHeap(c, c.length);
		System.out.println("BuildHeap");
		for(int i = 0; i < c.length; i++){
			System.out.println(c[i]);
		}

	

		recursiveHeapSort(e);
		System.out.println("HeapSort");
		for(int j = 0; j < e.length; j++){
			System.out.println(e[j]);
		}

	

		badHeapSort(d);

		System.out.println("BadHeapSort");
		for(int h = 0; h < d.length; h++){
			System.out.println(d[h]);
		}

		for(int i = 0; i < a.length; i++){
		System.out.println(a[i]);
		}
		
		System.out.println("Printing a: ");
		
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
		buildMaxHeap(a);

		System.out.println("a after building a max heap");

		for(int q = 0; q < a.length; q++){
			System.out.println(a[q]);
		}

		heapSort(a);

		System.out.println("Printing a after HeapSort: ");
		
		for(int j = 0; j < a.length; j++){
			System.out.println(a[j]);
		}

		System.out.println("Printing b: ");
		
		for(int k = 0; k < b.length; k++){
			System.out.println(b[k]);
		}
		buildMaxHeap(b);

		System.out.println("Printing b after building a max heap");

		for(int n = 0; n < b.length; n++){
			System.out.println(b[n]);
		}

		heapSort(b);

		System.out.println("Printing b after HeapSort: ");
		
		for(int m = 0; m < b.length; m++){
			System.out.println(b[m]);
		}

		System.out.println("Printing c: ");
		
		for(int h = 0; h < c.length; h++){
			System.out.println(c[h]);
		}

		buildMaxHeap(c);
		System.out.println("Printing c after building a max heap");

		for(int p = 0; p < c.length; p++){
			System.out.println(c[p]);
		}

		heapSort(c);


		System.out.println("Printing c after HeapSort: ");
		
		for(int l = 0; l < c.length; l++) {
			System.out.println(c[l]);
		
		}

		


	}

	public static int parent(int a){
		if(a%2 == 0){
			return (a - 2)/2;
		
		} else {
			return (a-1)/2;
		}	

	}

	public static int left(int a){
		return (2*a)+1;
	}
	public static int right(int a){
		return (2*a)+2;
	}

	public static void buildMaxHeap(int a []){
		maxHeapify(a, 0, a.length);
	}
	public static void maxHeapify(int a [], int b, int n){
		boolean swaps = true;
		
		while(swaps== true){
			int swapCount = 0;
			for(int j = n-1; j > 0; j=j-2){
				
				int parent = parent(j);
			//	System.out.println("Parent: " + parent(j));
				int left = left(parent);
			//	System.out.println("Left: " + left);
				int right = right(parent);
			//	System.out.println("Right: " + right);
				int largest = 0;
				if (a[left] > a[parent] && left < n){
			//		System.out.println("Largest = Left: " + a[left]);
					largest = left;
				} else {
					largest = parent;
			//		System.out.println("Largest = parent: " + a[parent]);
				}
				try {
					if (a[right] > a[largest] && right < n){
			//		System.out.println("Largest = Right " + a[right]);
					largest = right;
					}
				} catch(ArrayIndexOutOfBoundsException e){
			//		System.out.println("Right leaf does not exist");
				}
				
				if (largest != parent(j)){
			//		System.out.println("Swapping: " + parent+ " and " + largest);
					swap(a, parent, largest);
					swapCount++;
				} 
		
			}
			if (swapCount == 0){
				swaps = false;
			}
		}
	}

	public static void heapSort(int a []){
		buildMaxHeap(a);
		
		int l = 0;
		
		for(int i = a.length-1; i > 0; i--){
			for(int j = 0; j < a.length; j++){
			}
		
			swap(a,0,i);
			maxHeapify(a,0,i);
	
		}
	}
	public static void swap(int a [], int i, int j){
		int temp = a[i];
		System.out.println("i: " + i);
		System.out.println("j: " + j);
		a[i] = a[j];
		a[j] = temp;
	}

	public static void remove(int a[], int i){
		swap(a, a[i], a[a.length-1]);

	}

	public static void recursiveHeapify(int a[], int i, int heapSize){
		int l = left(i);
		System.out.println("i: " + i + " a[i]:" + a[i]);
		int r = right(i);

		int largest;
		if (l < heapSize && a[l] > a[i]){
			largest = l;
		}
		else {
			largest = i;
		}
		try{
			if (r < heapSize && a[r] > a[largest]) {
				largest = r;
			}
		} catch(ArrayIndexOutOfBoundsException e){

		}
		if(largest != i){
			swap(a, i, largest);
			recursiveHeapify(a, largest, heapSize);
		}
		
	}

	public static int recursiveBuildHeap(int a [], int heapSize){
		for(int i = parent(a.length); i >= 0; i--){
			System.out.println("i: " + i);
			recursiveHeapify(a, i, heapSize);
		}
		return heapSize;
	}

	public static void recursiveHeapSort(int a []){
		int heapSize = recursiveBuildHeap(a, a.length);
		for(int i = a.length-1; i >= 1; i--){
			swap(a,0,i);
			heapSize = heapSize - 1;
			recursiveHeapify(a, 0, heapSize);
		}
	}
	public static void badHeapSort(int a[]){
		int heapSize = recursiveBuildHeap(a, a.length);

		while(heapSize> 0){
			swap(a, 0, --heapSize);
			recursiveBuildHeap(a, heapSize);
		
		}
	}
}