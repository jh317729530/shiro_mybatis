package com.gunn.common.utils;

import java.io.Serializable;

/**
 * Created by Gunn on 2017/8/25.
 */
public class Persion implements Serializable{

	private String name;

	private int age;

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
}
