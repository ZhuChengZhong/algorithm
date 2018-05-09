import java.util.Arrays;
import java.util.Comparator;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323
 * 
 * 思路：可以想办法找出一种排序规则，来将数组中的数进行排序，使得排序后的数从头到尾拼接起来就是最小的数
 * 比如上面的例子  3 与 32 谁排在前面呢？ 可以把它俩组合一下 变成  332与 323 因为323比332小，所以可知32一定排在3前面
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
