package leetcode;

import java.util.Stack;
/**
 *  Given a string containing just the characters'(',')','{','}','['and']', determine if the input string is valid.

The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not. 
 * @author Administrator
 *
 */
public class IsValid {
    
    private static boolean isMatch(char c,char cc){
        if(c=='('&&cc==')'){
            return true;
        }
        if(c=='{'&&cc=='}'){
            return true;
        }
        if(c=='['&&cc==']'){
            return true;
        }
        return false;
    }
    
    public boolean isValid(String s) {
        if(s==null){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(!isMatch(stack.pop(),c)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
