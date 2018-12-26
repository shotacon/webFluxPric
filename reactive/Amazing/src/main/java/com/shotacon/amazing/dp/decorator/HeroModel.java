package com.shotacon.amazing.dp.decorator;

public class HeroModel implements BaseHuman {

	public String name;

	@Override
	public void show() {
		System.out.println("你创建了一个新角色: " + name);
	}

	public HeroModel(String name) {
		super();
		this.name = name;
		show();
	}

}
