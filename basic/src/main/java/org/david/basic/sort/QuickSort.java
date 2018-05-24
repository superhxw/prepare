package org.david.basic.sort;
/**
 * 快排
 * 划分：
 * 		划分是快速排序的前提，即把数据分为两组，大于特定值的数据在一组，
 * 		小于特定值的数据在另一组。快速排序即是由划分和递归操作来完成的。
 * 原理：
 * 		定义一个阈值，分别从最左面和最右面向中间遍历元素，
 * 		左面找到一个大于阈值的数据便停止，右边找到一个小于阈值的数据便停止，
 * 		如果此时左右两边都还没有走到中间，则交换左面大于阈值的数据和右面小于阈值的数据；
 * 		重复上述过程，直到左面指针和右面指针相遇，
 * 		此时左面数据均小于阈值，右面数据均大于阈值，划分结束。
 * 		划分结束后，数据仍然是无序的，但更接近于有序。
 * 例子：
 * 		待划分数据：7, 6, 9, 8, 5,1，假设阈值为5
 * 		第一轮：左指针指向7，右指针指向1，左指针向后移，右指针向左移，
 * 				发现左面第一个大于5的元素7，右面第一个小于5的元素1，交换7和1的位置，
 * 				结果：1,6,9,8,5,7
 * 		第二轮：从6开始找大于5的数字，找到6，右边从5起找小于5的数字，找到1，但此时由于6在1的右面
 * 				即右指针<左指针，左右指针交叉，此时划分结束。
 * 				原数列被划分为两部分，左侧子数列只有一个元素，即为1，
 * 				其为小于阈值的子数列；右侧子数列包括5个元素，均为大于阈值5的元素。
 * @author hanxiaowei
 *
 */
public class QuickSort {

	private int[] array;//数组
	
	private int length;//数组长度
	
	public QuickSort(int[] array) {
		this.array = array;
		this.length = array.length;
	}
	/**
	 * 打印元素
	 */
	public void print() {
		for(int i:array) {
			System.out.print(i+" ");
		}
        System.out.println();
	}
	
	/**
	 * 划分
	 * @param left
	 * @param right
	 * @param pivot 阀值
	 * @return 划分的分界点
	 */
    public int partition(int left, int right, int pivot){
    	//左指针的起点，left-1是由于在后面的循环中，每循环一次左指针都要右移，
        //这样可以确保左指针从左边第一个元素开始，不然是从第二个开始
        int leftpoint = left-1;
        //右指针的起点，right+1是由于后面的循环中，每循环一次右指针都要左移，
        //这样可以确保右指针从最右边开始，不然是从倒数第二个开始
        int rightpoint = right+1;
        while(true) {
			//找到左边大于pivot的数据，或者走到了最右边仍然没有找到比pivot大的数据
			while(leftpoint<right && array[++leftpoint]<pivot);
			//找到右边小于pivot的数据，或者走到了最左边仍然没有找到比pivot小的数据
			while(rightpoint>left && array[--rightpoint]>pivot);
			//左指针和右指针重叠或相交
			if(leftpoint >=rightpoint) {
				break;
			}else {
				//交换左边大的和右边小的数据
				swap(leftpoint, rightpoint);
			}
        }
        //返回分界点，即右边子数组中最左边的点
    	return leftpoint;
    }
    
    /**
     * 交换数据
     * @param leftpoint
     * @param rightpoint
     */
    public void swap(int leftpoint,int rightpoint){
    	int temp = array[leftpoint];
    	array[leftpoint] = array[rightpoint];
    	array[rightpoint] = temp;
    }

    public static void main(String[] arg) {
		int[] array = {8,6,3,9,10,4,15};
    	QuickSort qs = new QuickSort(array);
        System.out.println("划分前的数据为：");
        qs.print();
        int bound = qs.partition(0, array.length-1,3);
        System.out.println("划分后的数据为：");
        qs.print();
        System.out.println("划分的分界点为：" + array[bound] + "，分界点的坐标为：" + bound);
    }
}
