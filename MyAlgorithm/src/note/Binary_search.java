package note;

import java.io.*;
import java.util.*;

public class Binary_search {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {8,2,6,4,7,5,3,1,0};
		Arrays.sort(arr);
		
		int key = 3;
		
		System.out.println("idx:" + bi_search(arr, key));
		System.out.println("idx:" + Arrays.binarySearch(arr, key));
		
	}
	
	static int bi_search(int[] arr, int key) {
		int ans = 0;
		
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			System.out.println("mid:" + mid);
			
			if(key > arr[mid]) {
				left = mid + 1;
			}
			else if(key < arr[mid]){
				right = mid - 1;
			}
			else {
				ans = mid;
				break;
			}
		}
			
		return ans;
	}

}
