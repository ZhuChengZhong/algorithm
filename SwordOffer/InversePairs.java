/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author Zhu
 *思路：找逆序对其实也就是冒泡排序中需要交换的次数，但是用冒泡排序所需的时间复杂度为O（n2）
 *我们可以采用归并排序来解该题
 */
public class InversePairs {
	private static final int MOD=1000000007;
	public static int inversePairs(int [] array) {
		if(array==null){
			return 0;
		}
		return mergeSort(array,0,array.length-1);
    }
	private static int mergeSort(int [] array,int start,int end){
		if(start>=end){
			return 0;
		}
		int mid=(start+end)/2;
		return ((mergeSort(array,start,mid)+mergeSort(array,mid+1,end))%MOD+merge(array,start,mid,mid+1,end))%MOD;
	}
	private static int merge(int [] array,int left1,int right1,int left2,int right2){
		int inverseCount=0;
		int length=right2-left1+1;
		int start=left1;
		int[] ars=new int[length];
		int index=0;
		while(left1<=right1&&left2<=right2){
			if(array[left1]<=array[left2]){
				ars[index++]=array[left1];
				++left1;
			}else{
				//此时 array[left1~right1]中的数肯定都大于array[left2]
				//所以array[left1~right1]中的每个数与array[left2]都是一个逆序对
				inverseCount=(inverseCount+right1-left1+1)%MOD;
				ars[index++]=array[left2];
				++left2;
			}
		}
		while(left1<=right1){
			ars[index++]=array[left1];
			++left1;
		}
		while(left2<=right2){
			ars[index++]=array[left2];
			++left2;
		}
		for(int i=start,j=0;i<start+length;j++,i++){
			array[i]=ars[j];
		}
		return inverseCount%MOD;
	}
	public static void main(String[] args) {
		int[] array={3,2,1};
		int inverseCount=inversePairs(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println(inverseCount);
	}
}
