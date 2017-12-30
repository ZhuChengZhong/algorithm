/**
 * ��쳲��������У�ע��ǧ��Ҫʹ�õݹ�����
 * �ݹ��������ص�Ч�����⣬ԭ���ǵ����˺ܶ��
 * �ظ�����
 * @author Zhu
 *
 */
public class Fibonacci {
	/**
	 * ����һ  ���Ӷ�O(n)
	 * ˳����
	 * @param n
	 * @return
	 */
	public static int fibonacci1(int n) {
		int f1=0;
		int f2=1;
		int result=1;
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		for(int i=2;i<=n;i++){
			result=f1+f2;
			f1=f2;
			f2=result;
		}
		return result;
    }
	/**
	 * ���þ���Ŀ���������⣬���Ӷ�Ϊlog(n)
	 * ��ʽ
	 * |f(n-1) f(n)|*|0  1|=|f(n) f(n+1)|
	 *               |1  1|
	 * @param n
	 * @return
	 */
	public static int fibonacci2(int n) {
		if(n==0){
			return 0;
		}
		if(n==1||n==2){
			return 1;
		}
		n-=2;
		int[][] a={{0,1},{1,1}};
		int[][] result={{1,0},{0,1}};
		while(n>0){
			if((n&1)!=0){
				result=multiply(result,a);
			}
			n=n>>1;
			a=multiply(a,a);
		}
		return result[0][1]+result[1][1];
	}
	/**
	 * �������ĳ˷�
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	private static int[][] multiply(int[][] matrix1,int[][] matrix2){
		int [][]matrix={{0,0},{0,0}};
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++){
					matrix[i][j]+=matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		return matrix;
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(fibonacci2(i));
		}
	}
}
