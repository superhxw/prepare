package org.david.basic.string;

public class TestString {

	public static void main(String[] args) {
		String s = "E:\\jbx\\x9\\io9";  
		s.replace("j", "2");
        String ss;  
        //把路径s中的'\'换为'\\',为何还要整8个'\'?
        //“\\”被解释成一个regex。对于一个regex来说这就代表着一个字符，就是“\”
        ss = s.replaceAll("\\\\", "\\\\\\\\");
        System.out.println("s=" + s);  
        System.out.println("ss=" + ss);
	}

}
