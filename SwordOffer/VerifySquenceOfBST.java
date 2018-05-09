/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @author Zhu
 *
 */
public class VerifySquenceOfBST {
	
	public static boolean verifySquenceOfBST(int [] sequence) {
		if(sequence==null){
			throw new RuntimeException("数组不能为空");
		}
		if(sequence.length==0){
			return false;
		}
		int begin=0,end=sequence.length-1;
        return judge(sequence,begin,end);
    }
	private static boolean judge(int [] sequence,int begin,int end){
		if(begin>=end){
			return true;
		}
		int rootVal=sequence[end];
		int mid,i;
		for(i=begin;i<end;i++){
			if(sequence[i]>rootVal){
				break;
			}
		}
		mid=i-1;
		for(i=mid+1;i<end;i++){
			if(sequence[i]<rootVal){
				return false;
			}
		}
		return judge(sequence,begin,mid)&&judge(sequence,mid+1,end-1);
	}
	public static void main(String[] args) {
		int[] array1={};
		int [] array={7,3,1,4,5};
		boolean result=verifySquenceOfBST(array1);
		System.out.println(result);
	}
}
