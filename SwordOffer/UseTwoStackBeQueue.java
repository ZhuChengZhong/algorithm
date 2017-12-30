import java.util.Stack;

/*
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * */
public class UseTwoStackBeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.add(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.add(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
    public static void main(String[] args) {
    	UseTwoStackBeQueue queue=new UseTwoStackBeQueue();
    	for(int i=0;i<5;i++){
    		queue.push(i);
    	}
    	for(int i=0;i<5;i++){
    		System.out.println(queue.pop());
    	}
	}
}
