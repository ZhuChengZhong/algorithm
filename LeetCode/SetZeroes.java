package leetcode;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return ;
        }
        int m=matrix.length,n=matrix[0].length;
        int row=-1,col=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row=i;
                    col=j;
                    break;
                }
            }
        }
        if(row==-1) return;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[row][j]=0;
                    matrix[i][col]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][col]==0&&i!=row){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[row][i]==0&&i!=col){
                for(int j=0;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for(int i=0;i<n;i++) matrix[row][i]=0;
        for(int i=0;i<m;i++) matrix[i][col]=0;
    }
}
