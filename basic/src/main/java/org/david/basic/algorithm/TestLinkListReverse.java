package org.david.basic.algorithm;

import java.util.Scanner;

/**
 * 给出一个链表和一个数k，比如，链表为1→2→3→4→5→6
 * 若k=2，翻转后 2→1→6→5→4→3
 * 若k=3，翻转后 3→2→1→6→5→4
 * 若k=4，翻转后 4→3→2→1→6→5
 * 算法分析：
 * 			以第k-1个数字为界，拆分两部分，分别反转，时间复杂度O(n)，空间复杂度O(1)
 * 			若k=2:
 * 			1)翻转后 2→1→3→4→5→6
 * 			2)翻转后 2→1→6→5→4→3
 * @author hanxiaowei
 *
 */
public class TestLinkListReverse {

    /**
     * 以数组形式来表示链表
     * 重新排序方式
     * @param arg
     */
    public static void main(String[] arg) {
        int[] num = {1, 2, 3, 4, 5, 6};
        System.out.println("Enter a number(1-6):");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k>num.length||k<1) {
            System.out.println("invalid number");
            return;
        }
        reverseArr(num,0,k-1);
        reverseArr(num,k,num.length-1);

        //result output
        for (int i = 0; i <num.length ; i++) {
            if(i<num.length-1)
                System.out.print(num[i]+"->");
            else
                System.out.print(num[i]);
        }
    }
    public static int[] reverseArr(int[] num,int start,int end){
        while(start<end){
            int temp=num[start];
            num[start++]=num[end];
            num[end--]=temp;
        }
        return num;
    }
}
