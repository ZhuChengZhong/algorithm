/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author Zhu
 *
 */
public class Test1 {
	  public static boolean find(int target, int [][] array) {
		int row=array.length;
		int col=array[0].length;
		int i=0,j=col-1;
		while(i<row && j>=0){
			if(target>array[i][j]){
				i++;
			}else if(target<array[i][j]){
				j--;
			}else{
				return true;
			}
		}
		return false;
	  }
	  public static void main(String[] args) {
		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(find(10,a));
	}
}
