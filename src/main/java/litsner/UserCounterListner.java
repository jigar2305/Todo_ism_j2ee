package litsner;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserCounterListner implements HttpSessionListener{
	static int counter = 0; 

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		counter++;
		System.out.println("active user ===> "+counter);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		counter--;
		System.out.println("active user ===> "+counter);

	}

}
