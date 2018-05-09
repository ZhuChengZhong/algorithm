/*
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,
 * ������Ҫ��������������������,������ȫΪ������ʱ��,
 * ����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,
 * �������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},
 * ����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
 * */
public class FindGreatestSumOfSubArray {
	public static int findGreatestSumOfSubArray(int[] array) {
		if(array==null){
			return 0;
		}
        int sum=0,max=array[0];
        for(int i=0;i<array.length;i++){
        	sum+=array[i];
        	if(max<sum){
        		max=sum;
        	}
        	if(sum<0){
        		sum=0;
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		int [] array={-2,-8,-1,-5,-9};
		int max=findGreatestSumOfSubArray(array);
		System.out.println(max);
	}
}
