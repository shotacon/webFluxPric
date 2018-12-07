package com.shotacon.amazing.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.shotacon.amazing.dp.common.entity.Person;
import com.shotacon.amazing.dp.common.interfaces.Human;

public class ProxyTest {

	public static void main(String[] args) {

		Person tony = new Person("Tony");
		tony.littleTalk();

		System.out.println("=============");

		Human human = new Person("Tony");
		// 静态代理
		Human pp = new PersonStaticProxy(human);
		pp.walk();

		System.out.println("=============");

		// 动态代理
		InvocationHandler invocationHandler = new PersonDynamicProxy<Human>(human);
		pp = (Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class<?>[] { Human.class },
				invocationHandler);
		pp.walk();
		pp.talk();

	}
}
