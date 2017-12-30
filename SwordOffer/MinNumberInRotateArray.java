/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * @author Zhu
 *
 */
/**
 * 利用二分查找进行查询
 * @author Zhu
 *
 */
public class MinNumberInRotateArray {
	public static int minNumberInRotateArray(int [] array) {
		int first=array[0],last=array[array.length-1];
		int left=0,right=array.length-1;
		int mid=0;
		if(first<last){
			return first;
		}
		while(left<right){
			mid=(left+right)/2;
			if(array[mid]>first){
				left=mid+1;
			}
			else{
				right=mid;
			}
		}
	    return array[right];
    }
	
	public static void main(String[] args) {
		int[] array={4,5,5,6,7,8,9,2};
		System.out.println(minNumberInRotateArray(array));
	}
}
