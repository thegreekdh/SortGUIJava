package sortGUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Main implements ActionListener {

	private final int ARR_LEN = 50;
	
	private int[] ints = new int[ARR_LEN];
	
	private JFrame f;
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	
	private void shuffleArray(int[] arr) {
		Random r = new Random();
		int randChosen;
		int tempSwap;
		
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < arr.length; j++) {
				randChosen = r.nextInt(50);
				tempSwap = arr[j];
				arr[j] = arr[randChosen];
				arr[randChosen] = tempSwap;
			}
		}
	}
	
	void selectionSort(int arr[])
	    {
	        int n = arr.length;
	 
	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;
	 
	            // Swap the found minimum element with the first
	            // element
	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	            repaintAndUpdate(100);
	        }
	    }
	 public void insertionSort(int array[]) {  
	        int n = array.length;  
	        for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	                repaintAndUpdate(20);
	            }  
	            array[i+1] = key;  
	            repaintAndUpdate(20);
	        }  
	    }  
	
	private void initFrame() {
		f = new JFrame("sortGUI");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(1300, 1000);
		f.setContentPane(new DrawPane());
		
		b1 = new JButton();
		b1.setActionCommand("shuffle");
		b1.setText("Shuffle");
		b1.setVisible(true);
		b1.setEnabled(true);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton();
		b2.setActionCommand("bubble");
		b2.setText("Bubble");
		b2.setVisible(true);
		b2.setEnabled(true);
		b2.addActionListener(this);
		f.add(b2);
		
		b3 = new JButton();
		b3.setActionCommand("insertion");
		b3.setText("Insertion");
		b3.setVisible(true);
		b3.setEnabled(true);
		b3.addActionListener(this);
		f.add(b3);
		
		b4 = new JButton();
		b4.setActionCommand("selection");
		b4.setText("Selection");
		b4.setVisible(true);
		b4.setEnabled(true);
		b4.addActionListener(this);
		f.add(b4);
		
		b5 = new JButton();
		b5.setActionCommand("quick");
		b5.setText("Quick");
		b5.setVisible(true);
		b5.setEnabled(true);
		b5.addActionListener(this);
		f.add(b5);
		
		b6 = new JButton();
		b6.setActionCommand("merge");
		b6.setText("Merge");
		b6.setVisible(true);
		b6.setEnabled(true);
		b6.addActionListener(this);
		f.add(b6);
		
		b7 = new JButton();
		b7.setActionCommand("heap");
		b7.setText("Heap");
		b7.setVisible(true);
		b7.setEnabled(true);
		b7.addActionListener(this);
		f.add(b7);
	}
	
	void repaintAndUpdate(int delay) {
		f.repaint();
		try {
			TimeUnit.MILLISECONDS.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void heapSort(int arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            repaintAndUpdate(25);
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            repaintAndUpdate(25);
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
    
	void bubbleSort(int[] arr) {  
	        int n = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 //swap elements  
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;
	                                 repaintAndUpdate(15);
	                        }  
	                          
	                }  
	        }  
	}
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // Inplace Implementation
    void merge(int arr[], int start, int mid,
                      int end)
    {
        int start2 = mid + 1;
  
        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2]) {
            return;
        }
  
        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {
  
            // If element 1 is in right place
            if (arr[start] <= arr[start2]) {
                start++;
            }
            else {
                int value = arr[start2];
                int index = start2;
  
                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start) {
                    arr[index] = arr[index - 1];
                    
                    index--;
                    repaintAndUpdate(15);
                }
                arr[start] = value;
                
                repaintAndUpdate(15);
                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }
    }
  
    /* l is for left index and r is right index of the
       sub-array of arr to be sorted */
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
  
            // Same as (l + r) / 2, but avoids overflow
            // for large l and r
            int m = l + (r - l) / 2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
	
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        repaintAndUpdate(50);
    }
 
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    int partition(int[] arr, int low, int high)
    {
 
        // pivot
        int pivot = arr[high];
 
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
	public void main() {
		
		
		//shuffleArray(ints);
		initFrame();
		
		for (int i = 0; i < ARR_LEN; i++) {
			ints[i] = i + 1;
		}
		
		f.setVisible(true);
		f.repaint();
		//insertionSort(ints);
		//mergeSort(ints, 0, ints.length - 1);
		//quickSort(ints, 0, ints.length - 1);
		//bubbleSort(ints);
		//selectionSort(ints);
	}
	
	private class DrawPane extends JPanel {
		public void paintComponent(Graphics g) {
			for (int i = 0; i < ints.length; i++) {
				g.fillRect(25 * i + 20, 620 - ints[i] * 10, 15, ints[i] * 10);
			}
			 
		}
	}

	class myWorker extends SwingWorker<Void, Void> {
		String str;
		
		public myWorker(String s) {
			str = s;
		}
		
		@Override
		protected Void doInBackground() throws Exception {
			
			if (str.equals("bubble"))
				bubbleSort(ints);
			else if (str.equals("insertion"))
				insertionSort(ints);
			else if (str.equals("selection"))
				selectionSort(ints);
			else if (str.equals("quick"))
				quickSort(ints, 0, ints.length - 1);
			else if (str.equals("merge"))
				mergeSort(ints, 0, ints.length - 1);
			else if (str.equals("heap"))
				heapSort(ints);
			
			return null;
		}
		
		protected void done() {
			enableButtons();
			f.repaint();
		}
		
	}
	
	public void enableButtons() {
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
	}
	
	public void disableButtons() {
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("shuffle".equals(e.getActionCommand())) {
			shuffleArray(ints);
			f.repaint();
		}
		else 
			
		{
			disableButtons();
			new myWorker(e.getActionCommand()).execute();
		}
		
		
		
	}
	
	
}
