import java.util.ArrayList;
/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author Zhu
 *
 */

public class GetLeastNumbers {
	public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		sort(input,0,input.length-1);
		for(int i=0;i<k;i++){
			list.add(input[i]);
		}
		return list;
		
    }
	private static void sort(int[] array,int start,int end){
		if(start>=end)
			return ;
		int left=start,right=end;
		int m=array[start];
		while(left<right){
			while(array[right]>m&&left<right){
				right--;
			}
			array[left]=array[right];
			while(array[left]<=m&&left<right){
				left++;
			}
			array[right]=array[left];
		}
		array[left]=m;
		sort(array,start,left-1);
		sort(array,left+1,end);
	}
	public static int partition(int [] array,int start,int end){
		int left=start,right=end,index=0;
		int m=array[start];
		while(left<right){
			while(array[right]>m&&left<right){
				right--;
			}
			array[left]=array[right];
			while(array[left]<=m&&left<right){
				index++;
				left++;
			}
			array[right]=array[left];
		}
		return index;
	}
	public static void main(String[] args) {
		int array[]={4,5,1,6,2,7,3,8};
		//ArrayList<Integer> list=getLeastNumbers_Solution(array,4);
		int index=partition(array, 0, array.length-1);
		System.out.println(index);
	}
}
