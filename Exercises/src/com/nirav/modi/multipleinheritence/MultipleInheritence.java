package com.nirav.modi.multipleinheritence;

public class MultipleInheritence implements DefaultMethodInterface,
		DefaultMethodInterface2 {
	public static void main(String[] args) {
		DefaultMethodInterface defMethIn = new MultipleInheritence();
		defMethIn.defaultMethod();
	}
	
	@Override
	public void defaultMethod() {
		DefaultMethodInterface2.super.defaultMethod();
	}
}

interface DefaultMethodInterface {
	default public void defaultMethod() {
		System.out.println("DefaultMethodInterface");
	}
}

interface DefaultMethodInterface2 {
	default public void defaultMethod() {
		System.out.println("DefaultMethodInterface2");
	}
}
