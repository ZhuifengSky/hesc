package com.test;

import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.model.User;
import com.service.IUserService;

public class TestHession {

	public static void main(String[] args) {
		String url = "http://localhost:8080/hess/userServiceServlet";
		HessianProxyFactory factory = new HessianProxyFactory();
		       
		       IUserService service = null;
			try {
				service = (IUserService) factory.create(IUserService.class, url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//创建IService接口的实例对象
			   User user = new User();
			   user.setUserName("admin");
		       List<User> users = service.searchUsers(user);
		       for (User u : users) {
				System.out.println(u.getAge()+u.getUserName());
			}
	}
}
