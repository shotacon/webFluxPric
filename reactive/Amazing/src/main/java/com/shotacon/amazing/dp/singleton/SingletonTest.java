package com.shotacon.amazing.dp.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

	private static ExecutorService e = Executors.newFixedThreadPool(5);

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 5; i++) {
			int v = i;
			e.submit(new Callable<SingletonClass>() {
				@Override
				public SingletonClass call() throws Exception {
					SingletonClass t = SingletonClass.getInstance();
					t.setAge(Thread.currentThread().hashCode());
					t.setName(Thread.currentThread().getName());
					t.setRange(v);
					System.out.println(t.toString());
					return t;
				}
			});
//			Thread.sleep(3000);
		}
		e.shutdown();

	}
}
