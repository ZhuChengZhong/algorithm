/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
