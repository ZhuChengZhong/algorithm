package leetcode;
/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.


 * @author zhu
 *
 */
public class problem79 {
    public static boolean exist(char[][] board, String word) {
    	if(word==null||word.length()==0||board==null||board.length==0||board[0].length==0) {
    		return false;
    	}
    	boolean[][]mark=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(board[i][j]==word.charAt(0)) {
        			mark[i][j]=true;
        			if(exist(i, j, mark, board, word, 1)) {
        				return true;
        			}
        			mark[i][j]=false;
        		}
        	}
        }
        return false;
    }
    private static int[] xx= {-1,1,0,0};
    private static int[] yy= {0,0,-1,1};
    public static boolean exist(int row,int col,boolean[][]mark,char[][] board, String word,int index) {
        if(index==word.length()) {
        	return  true;
        }
        for(int i=0;i<4;i++) {
        	int x=row+xx[i];
        	int y=col+yy[i];
        	if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&!mark[x][y]&&board[x][y]==word.charAt(index)) {
        		mark[x][y]=true;
        		if(exist(x, y, mark, board, word, index+1)) {
        			return true;
        		}
        		mark[x][y]=false;
        	}
        }
        return false;
    }
    public static void main(String[] args) {
		char [][]board =
			{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
			};
		//String word = "ABCCED";
		//String word = "SEE";
		//String word = "ABCB";
		String word ="";
		System.out.println(exist(board,word));
	}
}
