package org.david.basic.sort;
/**
 * 冒泡排序
 * N个元素需要排序N-1轮
 * 第i轮需要比较N-i次
 * N个元素排序，需要比较n（n-1）/2次
 * 冒泡排序的算法复杂度较高，为O（n*n）
 * 
 * 例如待排序数据：8,6,3,9,10,4,15
 * 第一轮排序过程：指针指向8,8和6比较6<8,交互6和8的位置，结果为6,8,3,9,10,4,15
 * 指针指向第二个元素8，8和3比较，3<8，交换位置，结果为：6,3,8,9,10,4,15
 * 指针指向第三个元素8，8和9比较，9>8，不用交换位置，结果仍为：6,3,8,9,10,4,15
 * 指针指向第四个元素9，9和10比较，10>9，不用交换位置，结果仍为：6,3,8,9,10,4,15
 * 指针指向第五个元素10，10和4比较，4<10，交换位置，结果为：6,3,8,9,4,10,15
 * 指针指向第六个元素10，10和15比较，15>10，不用交换位置，结果仍为：6,3,8,9,4,10,15
 * 第一轮排序结束后，最大的数字15再最右边。
 * 依次N-1轮排序；第i轮排序需要的比较次数为N-i次
 * @author hanxiaowei
 *
 */
public class BobSort {

	private int[] array;
	private int length;
	
	public BobSort(int[] array) {
		this.array = array;
		this.length = array.length;
	}
	public void print() {
		for(int i:array) {
			System.out.print(i+" ");
		}
        System.out.println();
	}
	public void sort() {
		for(int i = 0; i < length-1; i++) {//排序轮次
			for(int j = 0; j < length-1-i; j++) {//比较次数
				if(array[j]>array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public static void main(String[] arg) {
		int[] array = {8,6,3,9,10,4,15};
		BobSort bobSort = new BobSort(array);
		bobSort.sort();
		bobSort.print();
	}
}
