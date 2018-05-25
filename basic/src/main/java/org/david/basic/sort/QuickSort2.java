package org.david.basic.sort;
/**
 * 快排
 * 
 * 快速排序采用了分治策略。就是在一个数组中取一个基准数字，把小的数放基准的左边，大的数放基准的右边。
 * 基准左边和右边分别是新的序列。在新的序列中再取一个基准数字，小的放左边，大的放右边。
 * 这个里面用到的递归。我们需要三个参数，一个是数组，另外两个是序列的边界
 *   
 * 划分：
 *   最佳的划分是将待排序的序列分成等长的子序列，
 *   最佳的状态我们可以使用序列的中间的值，也就是第N/2个数。
 *   可是，这很难算出来，并且会明显减慢快速排序的速度。
 *   这样的中值的估计可以通过随机选取三个元素并用它们的中值作为基准元而得到。
 *   事实上，随机性并没有多大的帮助，因此一般的做法是使用左端、右端和中心位置上的三个元素的中值作为基准元。
 * 
 * @author hanxiaowei
 *
 */
public class QuickSort2 {

	private int[] array;//数组
	
	public QuickSort2(int[] array) {
		this.array = array;
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
	
	public void sort(int num[],int left,int right){
        if (left<right){
            int index = partition(num,left,right);//算出枢轴值 
            sort(num,left,index-1);//对低子表递归排序
            sort(num,index+1,right);//对高子表递归排序
        }
    }
	
	/**
	 * 三数取中划分
	 * @param num
	 * @param left
	 * @param right
	 * @return 基准记录的位置
	 */
	public int partition(int[] num,int left,int right){
        if(num==null || num.length<=0 || left<0 || right>=num.length){
            return 0;
        }
        int prio=num[left+(right-left)/2];//获取数组中间元素的下标
        while (left<=right){//从两端交替向中间扫描
            while (num[left]<prio)
                left++;
            while (num[right]>prio)
                right--;
            if (left<=right){
                swap(num,left,right);//最终将基准数归位  
                left++;
                right--;
            }
        }
        return left;
    }
    /**
     * 交换数据
     * @param leftpoint
     * @param rightpoint
     */
    public void swap(int[] num,int left,int right){
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    public static void main(String[] arg) {
		int[] array = {8,6,3,9,10,4,15};
    	QuickSort2 qs = new QuickSort2(array);
        System.out.println("快排前的数据为：");
        qs.print();
        qs.sort(array,0,array.length-1);
        System.out.println("快排后的数据为：");
        qs.print();
    }
}
