package com.shotacon.amazing.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * 动态代理
 * <p>
 * 代理类通过实现{@link InvocationHandler}, 调用{@link InvocationHandler.invoke}方法,
 * 来代替被代理类进行操作.
 * 
 * @author shotacon
 *
 * @param <T>
 */
public class PersonDynamicProxy<T> implements InvocationHandler {

	T target;

	public PersonDynamicProxy(T target) {
		super();
		this.target = target;
	}

	/**
	 * <p>
	 * proxy: 代表动态代理对象
	 * <p>
	 * method：代表正在执行的方法
	 * <p>
	 * args：代表调用目标方法时传入的实参
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("before invoke");

		Object invoke = method.invoke(target, args);

		System.out.println("after invoke");

		return invoke;
	}

}
