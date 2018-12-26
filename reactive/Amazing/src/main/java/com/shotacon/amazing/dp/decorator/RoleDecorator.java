package com.shotacon.amazing.dp.decorator;

/**
 * 角色装饰器
 * 
 * @author shotacon
 *
 */
public abstract class RoleDecorator implements BaseHuman {

	BaseHuman baseHuman;

	String name;

	String abilities;

	@Override
	public void show() {
		System.out.println("你的角色完成了转职任务");
	}

}