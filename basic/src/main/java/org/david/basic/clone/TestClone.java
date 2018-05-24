package org.david.basic.clone;
/**
 * 拷贝的类型分为 深拷贝与浅拷贝。(jvm 堆操作)
 * 
 * 深拷贝：引用对象的值等信息，复制一份一样的
 * 		   能复制变量，也能复制当前对象的内部对象
 * 
 * 浅拷贝：只复制引用,另一处修改,你当下的对象也会修改
 * 		   能复制变量，如果对象内还有对象，则只能复制对象的地址
 * 
 * @author hanxiaowei
 *
 */
public class TestClone {

	public static void main(String[] arg) {
		try {
	        Parent item1 = new Parent("test", 10);
/*	        Parent item2 = item1.clone();
	        System.out.println("parent1 = " + item1.toString()); 
	        System.out.println("parent2 = " + item2.toString());
	        
	        item1.setName("test1");
	        System.out.println("parent1 = " + item1.toString()); 
	        System.out.println("parent2 = " + item2.toString());*/
	        
	        Son son = new Son("test son",4);
	        item1.setTheson(son);
	        Parent item2 = item1.clone();
	        item1.setName("alice-test1");
	        son.setName("alice----test son");
	        System.out.println("parent1 = " + item1.toString()+"---son:"+item1.getTheson().toString()); 
	        System.out.println("parent2 = " + item2.toString()+"---son:"+item2.getTheson().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Parent implements Cloneable{

	private String name;
	private int age = 0;
    Son theson;
	Parent(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	/**
	 * clone：它允许在堆中克隆出一块和原对象一样的对象，并将这个对象的地址赋予新的引用。 
	 */
	@Override
	protected Parent clone() throws CloneNotSupportedException {
		Parent clone = (Parent) super.clone();
		clone.theson = theson.clone();
		return clone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Son getTheson() {
		return theson;
	}

	public void setTheson(Son theson) {
		this.theson = theson;
	}

	public String toString() {  
        return "Parent[" + name + "===" + age + "];";  
    }  
}
class Son implements Cloneable {
	
	private String name;
	private int age = 0;
	Son(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	protected Son clone() throws CloneNotSupportedException {
		return (Son) super.clone();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {  
        return "Son[" + name + "===" + age + "];";  
    }  
}