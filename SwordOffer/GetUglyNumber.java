/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author Zhu
 *	思路：可采取空间换时间的做法，我们可以创建一个数组用来保存排好序的丑数，每个丑数都是由2,3,5组成，所以每个丑数都是另一个丑数*2,3,5的结果
 *我们可以将数组中的数乘以2,3,5来得到下一个丑数，该算法的难度在于保证数组中的数要是有序的，所以每次我们只需要找出一个刚好大于最后一个数的丑数放入数组
 *然后在用同样的方法寻找下一个丑数
 */
public class GetUglyNumber {
	public static int getUglyNumber(int index){
		if(index<=0){
			return 0;
		}
		int[] array=new int[index];
		int m2=1,m3=1,m5=1,max,countOfUgly=0;
		while(countOfUgly<index){
			int min=min(m2,m3,m5);
			array[countOfUgly++]=min;
			max=array[countOfUgly-1];
			int i=0;
			m2=m3=m5=0;
			while(m2<=max){
				m2=array[i++]*2;
			}
			i=0;
			while(m3<=max){
				m3=array[i++]*3;
			}
			i=0;
			while(m5<=max){
				m5=array[i++]*5;
			}
		}
        return array[countOfUgly-1];
    }
	private static int min(int x,int y,int z){
		int min=x<y?x:y;
		min=min<z?min:z;
		return min;
	}
	public static void main(String[] args) {
		int ugly=getUglyNumber(5);
		System.out.println(ugly);
	}
}
