package org.david.basic.sort;
/**
 * 选择排序
 * 选择排序是对冒泡排序的改进，它的比较次数与冒泡排序相同，
 * 但交换次数要小于冒泡排序。当数据量较大时，效率会有很大的提升
 * 但时间复杂度仍为O(n*n)
 * 相比于冒泡排序，选择排序的交换次数大大减少，因此速度要快于冒泡排序
 * 
 * 1、从第一个元素开始，分别与后面的元素向比较，找到最小的元素与第一个元素交换位置
 * 2、从第二个元素开始，分别与后面的元素相比较，找到剩余元素中最小的元素，与第二个元素交换
 * 3、重复上述步骤，直到所有的元素都排成由小到大为止
 * 
 * @author hanxiaowei
 *
 */
public class ChooseSort {
	private int[] array;
	private int length;
	
	public ChooseSort(int[] array) {
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
		for (int i = 0; i < length-1; i++) {
			int minIndex = i;
			for (int j = minIndex+1; j < length; j++) {
				if(array[j]>array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
	public static void main(String[] arg) {
		int[] array = {8,6,3,9,10,4,15};
		ChooseSort chooseSort = new ChooseSort(array);
		chooseSort.sort();
		chooseSort.print();
	}
}
