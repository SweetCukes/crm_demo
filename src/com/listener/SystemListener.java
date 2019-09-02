package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SystemListener implements ServletContextListener{
	private Thread thread = null;
	public SystemListener() {
		System.out.println("--------SystemListener--------");
	}
	/*
	 * 实例调用初始化方法
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--------SystemListener----init----");
		ServletContext application = sce.getServletContext();
		thread =  new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						loadProperties(application);
						Thread.sleep(1000*60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void loadProperties(ServletContext application) {
				
			}
		});
		thread.start();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("--------SystemListener----Destroy----");
	}
}
