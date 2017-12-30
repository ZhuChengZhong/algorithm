/*��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * 
 *����һ��ʱ�临�Ӷ�O��n������Ϊ������ֳ��ֵĴ������������鳤�ȵ�һ�룬�������ǿ�����һ�����������ڱ��������ʱ�������ǰ����������ǰһ������ͬ���������һ�������ͬ���һ
 *����ܹ�ʹ����������0����һ����������������鳤��һ�����
 *
 *��������������
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
