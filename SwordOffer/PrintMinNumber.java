import java.util.Arrays;
import java.util.Comparator;

/*
 * ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323
 * 
 * ˼·��������취�ҳ�һ������������������е�����������ʹ������������ͷ��βƴ������������С����
 * �������������  3 �� 32 ˭����ǰ���أ� ���԰��������һ�� ���  332�� 323 ��Ϊ323��332С�����Կ�֪32һ������3ǰ��
 * 
 * */
public class PrintMinNumber {
	private static int compare(int o1,int o2){
		int b=1,temp=o2,x,y;
		while(temp>0){
			temp/=10;
			b*=10;
		}
		x=o1*b+o2;
		b=1;
		temp=o1;
		while(temp>0){
			temp/=10;
			b*=10;
		}
		y=o2*b+o1;
		return x-y;
	}
	public static String printMinNumber(int [] numbers) {
		if(numbers==null)
			return "";
		
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				if(compare(numbers[i], numbers[j])>0){
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<numbers.length;i++){
			sb.append(numbers[i]);
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		/*int[] arrays={3,32,321};*/
		int[] arrays={3,5,1,4,2};
		String result=printMinNumber(arrays);
		System.out.println(result);
	}
}
