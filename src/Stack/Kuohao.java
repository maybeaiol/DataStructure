package Stack;

import java.util.Stack;

public class Kuohao {

	public static void main(String[] args) {
	
	System.out.println(KUohao("({[]})"));
	}
	public static boolean KUohao(String str) {
		Stack<Character> temp=new Stack<Character>();
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c=='('||c=='{'||c=='[') {
				temp.push(c);
			}
			else {
				if(temp.isEmpty()) {
					return false;
				}
				char poptop=temp.pop();
				if(c==')'&poptop!='(') {
					return false;
				}
				if(c=='}'&poptop!='{') {
					return false;
				}
				if(c==']'&poptop!='[') {
					return false;
				}
			}
		}
		return temp.isEmpty();
	}
}
