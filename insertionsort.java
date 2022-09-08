package Sorting;

import java.util.Scanner;

public class insertionsort {
	
	public static void insertsort(int arr[]) {

	int i;
	for(i=1;i<arr.length;i++)
	{
		int temp = arr[i];
		 int j;
		 j=i-1;
		
		while(j>=0 && arr[j]>temp) {
			arr[j+1]=arr[j];
			j--;
			arr[j+1]=temp;
		}
		
		
	}
	System.out.println("After Sorting");
	for(i=0;i<arr.length;i++) {
	System.out.println(arr[i]);
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = scan.nextInt();
		
		int arr[]=new int[n];
		
		System.out.println("Enter the elements");
		
		for(int i=0; i<n;i++)
		{
		int x = scan.nextInt();
		arr[i]=x;
		}
		
		System.out.println("Before Sorting");
		for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
		}
		
		insertsort(arr);
		
		
		
	}

}

