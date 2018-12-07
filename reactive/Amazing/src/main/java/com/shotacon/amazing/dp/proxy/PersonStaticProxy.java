package com.shotacon.amazing.dp.proxy;

import com.shotacon.amazing.dp.common.entity.Person;
import com.shotacon.amazing.dp.common.interfaces.Human;

/**
 * <p>
 * 静态代理:
 * <p>
 * 编译期就已经存在代理类class文件的代理.
 * <p>
 * 
 * @des 代理类, 持有被代理类的对象, 达到代理效果
 * 
 * @author shotacon
 *
 */
public class PersonStaticProxy implements Human {

	/**
	 * 被代理类
	 */
	Person person;

	/**
	 * 只代理Person类
	 * 
	 * @param person
	 */
	public PersonStaticProxy(Human p) {
		if (p.getClass() == Person.class) {
			this.person = (Person) p;
		}
	}

	public void walk() {
		System.out.println(person.getName() + " have PTSD.");
		person.walk();
	}

	@Override
	public void talk() {
		System.out.println(person.getName() + " so mean.");
		person.talk();

	}

}
