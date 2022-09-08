package Sorting;

import java.util.Scanner;

public class bubblesort {

	
		
		public static void Sort(int arr[]) {
			int i;
			System.out.println("Element after sorting: ");
		for( i=0; i<arr.length;i++) {
			
			for(int j=i+1; j<arr.length; j++) {
				
				if(arr[j]<arr[i]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println(arr[i]);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = scan.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter the element");
		
		
		
		for(int i=0;i<arr.length;i++) {
			int x = scan.nextInt();
			arr[i]=x;
			}
		System.out.println("Element before sorting: ");
		
		for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i] + " ");
		}
		
		Sort(arr);
		
		
	}

}
