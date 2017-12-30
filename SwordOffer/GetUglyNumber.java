/**
 * ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�����
 * ��14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * @author Zhu
 *	˼·���ɲ�ȡ�ռ任ʱ������������ǿ��Դ���һ���������������ź���ĳ�����ÿ������������2,3,5��ɣ�����ÿ������������һ������*2,3,5�Ľ��
 *���ǿ��Խ������е�������2,3,5���õ���һ�����������㷨���Ѷ����ڱ�֤�����е���Ҫ������ģ�����ÿ������ֻ��Ҫ�ҳ�һ���պô������һ�����ĳ�����������
 *Ȼ������ͬ���ķ���Ѱ����һ������
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
