package org.david.basic.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 字符串反转,考虑时间复杂度和空间复杂度
 * 1，输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，
 * 		句子中单词以空格符隔开。为简单起见，
 * 		标点符号和普通字母一样处理。
 * 		例如，输入“I am a student.”，则输出“student. a am I”。
 * 算法分析：
 * 			首先第一步反转.tneduts a ma I，
 * 			然后以空格为界，逐个单词反转，最后输出student. a am I，
 * 			时间复杂度O(n)，空间复杂度O(1)
 * @author hanxiaowei
 *
 */
public class TestStringReverse {

    private static String str = "I am a student.";
    //Iamastudent
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] arg) {
        char[] chars=str.toCharArray();
        //first reverse
        reverse(chars,0,chars.length-1);
        System.out.println(String.valueOf(chars));
        //second reverse
        int start=0,end;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==' '){
                end=i-1;
                reverse(chars,start,end);
                start=i+1;
            }else if(i==chars.length-1){
                reverse(chars,start,i);
            }
        }
        System.out.println(String.valueOf(chars));
    }
    public static void reverse(char[] chars,int start,int end){
        System.out.println(">>>>>>>>>>>>>>count:"+count.incrementAndGet());
        while(start<end){
            char temp=chars[start];
            chars[start++]=chars[end];
            chars[end--]=temp;
        }
    }
}
