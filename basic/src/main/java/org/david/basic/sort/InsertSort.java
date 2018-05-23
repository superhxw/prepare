package org.david.basic.sort;
/**
 * 插入排序:
 * 简单排序中最快的排序算法
 * 虽然时间复杂度仍然为O(n*n)，
 * 但是却比冒泡排序和选择排序快很多。
 * 
 * 1、以数组的某一位作为分隔位，比如index=1，假设左面的都是有序的.
 * 2、将index位的数据拿出来，放到临时变量里，这时index位置就空出来了
 * 3、从leftindex=index-1开始将左面的数据与当前index位的数据（即temp）进行比较，如果array[leftindex]>temp,
 * 	     则将array[leftindex]后移一位，即array[leftindex+1]=array[leftindex],此时leftindex就空出来了.
 * 4、再用index-2(即leftindex=leftindex-1)位的数据和temp比，重复步骤3，
 * 	     直到找到<=temp的数据或者比到了最左面（说明temp最小），停止比较，将temp放在当前空的位置上.
 * 5、index向后挪1，即index=index+1，temp=array[index],重复步骤2-4，直到index=array.length,排序结束
 * 	     此时数组中的数据即为从小到大的顺序.
 * 
 * @author hanxiaowei
 *
 */
public class InsertSort {
	
	private int[] array;
	private int length;
	
	public InsertSort(int[] array) {
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
		for (int index = 1; index < length; index++) {//外层向右的
			int temp = array[index];//用作比较的数据
			int leftIndex = index -1;
			while(leftIndex>=0&&array[leftIndex]>temp) {//当比到最左边或者遇到比temp小的数据时，结束循环
				array[leftIndex+1] = array[leftIndex];
				leftIndex --;
			}
			array[leftIndex+1] = temp;//把temp放到空位上
		}
		
	}
	public static void main(String[] arg) {
		int[] array = {8,6,3,9,10,4,15};
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		insertSort.print();
	}
}
