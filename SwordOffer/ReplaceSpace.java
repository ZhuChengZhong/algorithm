
public class ReplaceSpace {
	public static String replaceSpace(StringBuffer str){
		String s=str.toString();
		int len=s.length();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c==' '){
				len+=2;
			}
		}
		char[] cs=new char[len];
		int index=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c==' '){
				cs[index++]='%';
				cs[index++]='2';
				cs[index++]='0';
			}else{
				cs[index++]=s.charAt(i);
			}
		}
		return new String(cs);
	}
	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
	}
}
