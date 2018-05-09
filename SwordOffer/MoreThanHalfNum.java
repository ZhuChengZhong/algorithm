/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 *方法一：时间复杂度O（n），因为这个数字出现的次数超过了数组长度的一半，所以我们可以用一个计数器，在遍历数组的时候如果当前遍历的数与前一个数相同则计数器加一，如果不同则减一
 *最后能够使计数器大于0的数一定就是这个超过数组长度一半的数
 *
 *法二：快速排序
 * */
public class MoreThanHalfNum {
	public static int moreThanHalfNum_Solution1(int [] array){
		if(array==null||array.length==0){
			return 0;
		}
		int count=1;
		int result=array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]==result)
				count++;
			else if(count>0){
				count--;
			}else{
				count=1;
				result=array[i];
			}
		}
		if(check(array,result))
			return result;
		return 0;
        
    }
	private static boolean check(int [] array,int result) {
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==result)
				count++;
		}
		if(count*2>array.length){
			return true;
		}
		return false;
	}
	public static int quicksort(int [] array){
		sort(array,0,array.length-1);
		int mid=array.length/2;
		int result=array[mid];
		if(check(array,result))
			return result;
		return 0;
	}
	private static void sort(int[] array,int start,int end){
		if(start>=end){
			return ;
		}
		int m=array[start];
		int left=start,right=end;
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
	public static void main(String[] args) {
		int[] array={1,2,3,2,2,2,5,4,2};
		int[] array1={6,4,7,8,7,4,1,9,5};
		int result=moreThanHalfNum_Solution1(array);
		result=quicksort(array);
		System.out.println(result);
	}
}
