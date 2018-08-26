package leetcode;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        if(n<1) return new int[0][0];
        int[][] matrix=new int[n][n];
        int x1=0,y1=0,x2=n-1,y2=n-1;
        int index=1;
        while(x1<=x2){
            for(int i=y1;i<=y2;i++){
                matrix[x1][i]=index++;
            }
            for(int i=x1+1;i<x2;i++){
                matrix[i][y2]=index++;
            }
            if(x1!=x2){
                for(int i=y2;i>=y1;i--){
                    matrix[x2][i]=index++;
                }
            }
            if(y1!=y2){
                for(int i=x2-1;i>x1;i--){
                    matrix[i][y1]=index++;
                }
            }
            x1++;y1++;x2--;y2--;
        }
        return matrix;
    }
}
