package leetcode;

import java.util.ArrayList;

public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>res=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return res;
        }
        int m=matrix.length,n=matrix[0].length;
        spiralOrder(res,matrix,0,0,m-1,n-1);
        return res;
    }
    
    private void spiralOrder(ArrayList<Integer>list,int[][]matrix,
                             int x1,int y1,int x2,int y2){
        if(x2<x1||y2<y1){
            return ;
        }
        for(int i=y1;i<=y2;i++){
            list.add(matrix[x1][i]);
        }
        for(int i=x1+1;i<x2;i++){
            list.add(matrix[i][y2]);
        }
        if(x1!=x2){
            for(int i=y2;i>=y1;i--){
                list.add(matrix[x2][i]);
            }
        }
        if(y1!=y2){
            for(int i=x2-1;i>x1;i--){
                list.add(matrix[i][y1]);
            }
        }
        spiralOrder(list,matrix,x1+1,y1+1,x2-1,y2-1);
    }
}
