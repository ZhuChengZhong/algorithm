/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 *  ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 *  ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 *  NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
 * @author Zhu
 *
 */
/**
 * ���ö��ֲ��ҽ��в�ѯ
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
