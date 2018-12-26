package com.shotacon.amazing.dp.singleton;

/**
 * 单例
 * 
 * @author shotacon
 *
 */
public class SingletonClass {

	private static volatile SingletonClass instance;

	private int age;

	private String name;

	private int range;

	private SingletonClass() {
		if (null != instance)
			throw new IllegalStateException("SingletonClass is already initialized");
	}

	public static SingletonClass getInstance() throws InterruptedException {
//		Thread.sleep(1000);
		SingletonClass result = instance;

		if (null == result) {
			synchronized (SingletonClass.class) {
				result = instance;
				System.out.println("t:" + Thread.currentThread() + ", synchronized");
			}

			if (null == result) {
				instance = result = new SingletonClass();
				System.out.println("t:" + Thread.currentThread() + ", create");
			}

		}
		return result;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "age:" + this.age + ", name:" + this.name + ", " + this.range;
	}

}
