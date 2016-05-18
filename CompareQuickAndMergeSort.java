/**
 * program:	CompareQuickAndMergeSort.java
 * version:	1.7
 * author:	Hrishikesh Karale (hhk9433)
 * date:	february 8, 2015
 */
import java.util.Random;

/**
 * This program Compares quick and merge sort speed for 50000 elements
 */
public class CompareQuickAndMergeSort 
{
	static int no_of_values= 50000;
	private int merge_sorter[];
	private int merge_sorted[];
	private int length=0;
	
	/**
	 * This method takes in an array and its start and end points and
	 * gives us a sorted array as a result.
	 * @param unsorted
	 * @param start
	 * @param end
	 * @return
	 */
	private int[] quicksort(int unsorted[], int start, int end)
	{
		int pivot=0;
		int mid= 0;
		int swap=0;
		
		//checks if only one element is present in the array.
		if(start==end)
			return unsorted;
		
		else if(start!= end)
		{
			mid= (end+start)/2;
			pivot=unsorted[mid];
			int pos=mid;
			for(int i= start; i<end; i++)
			{
				if(start==end)
					return unsorted;
				else if(start==end-1)
				{
					if(end<no_of_values && unsorted[end]<unsorted[start])
					{
						swap=unsorted[end];
						unsorted[end]=unsorted[start];
						unsorted[start]=swap;
					}
					return unsorted;
				}
				else
				{
					if(unsorted[i]>pivot)
					
					{
						if(pos>i)
						{
							swap=unsorted[i];
							for(int j=i; j<pos; j++)
							{
								unsorted[j]=unsorted[j+1];
							}
							unsorted[pos]=swap;
							pos=pos-1;
							i--;
						}
						
					}
					else if(unsorted[i]<unsorted[pos])
					{
						if(pos<i)
						{
							swap=unsorted[i];
							for(int j=i; j>pos; j--)
							{
								unsorted[j]= unsorted[j-1];
							}
							unsorted[pos]= swap;
							pos=pos+1;
							i--;
						}					
					}
				}
					
			}
			
			quicksort(unsorted, start, pos);
			quicksort(unsorted, pos+1, end);
		}
		return unsorted;
	}
	
	/**
	 * This block of code calls partition on the given array.
	 * @param unsorted
	 */
	private void mergesort(int unsorted[])
	{
		this.merge_sorted= unsorted;
		this.length= unsorted.length;
		this.merge_sorter= new int[length];
		partition(0, no_of_values-1);
		
	}
	
	/**
	 * This Method partition's the array for the merge sort.
	 * @param start
	 * @param end
	 */
	private void partition(int start, int end)
	{
		int mid=0;
		if(start<end)
		{
			mid=start+(end-start)/2;
			partition(start, mid);
			partition(mid+1, end);
			merge(start, mid, end);
		}
	}

	/**
	 * This Method sorts and merges the arrays.
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void merge(int start, int mid, int end)
	{
		for(int i=start; i<=end; i++)
			merge_sorter[i]= merge_sorted[i];
		int i=start;
		int k=start;
		int j=mid+1;
		while(i<= mid && j<=end)
		{
			if(merge_sorter[i]<=merge_sorter[j])
				merge_sorted[k++]= merge_sorter[i++];
			else
				merge_sorted[k++]= merge_sorter[j++];
		}
		
		while(i<=mid)
			merge_sorted[k++]= merge_sorter[i++];
		
	}

	/**
	 * This is the main method of our program it generates random numbers and 
	 * stores them into arrays. Later we send these arrays to be sorted and time
	 * them. This method gives tells us which sorting method is faster by 
	 * comparing their run time.
	 * @param args
	 */
	public static void main(String args[])
	{
		int quick_unsorted[]= new int [no_of_values];
		int merge_unsorted[]= new int [no_of_values];
		int unsorted[]= new int[no_of_values];
		Random r= new Random();
		CompareQuickAndMergeSort classobject= new CompareQuickAndMergeSort();
		
		for (int i= 0; i<no_of_values; i++)
		{
			quick_unsorted[i]=r.nextInt(200);
			merge_unsorted[i]=quick_unsorted[i];
			unsorted[i]= merge_unsorted[i];
		}
				
		long qstartTime = System.currentTimeMillis();
		quick_unsorted= classobject.quicksort(quick_unsorted, 0, no_of_values);
		long qendTime   = System.currentTimeMillis();
		long qtotalTime = qendTime - qstartTime;
		System.out.println("Quick Sort: "+qtotalTime);
		
		long mstartTime = System.currentTimeMillis();
		classobject.mergesort(merge_unsorted);
		long mendTime   = System.currentTimeMillis();
		long mtotalTime = mendTime - mstartTime;
		System.out.println("Merge Sort: "+mtotalTime);
		
		
		if(mtotalTime<qtotalTime)
			System.out.println("Merge Sort is Faster");
		else if(mtotalTime<qtotalTime)
			System.out.println("Quick Sort is Faster");
		else
			System.out.println("Both are the same");
		
	}
	
	
	
}
