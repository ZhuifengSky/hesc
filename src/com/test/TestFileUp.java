package com.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.model.User;
import com.service.IFileUpService;
import com.service.IUserService;

public class TestFileUp {

	public static void main(String[] args) {
		String url = "http://localhost:8080/hess/fileUpService";
		HessianProxyFactory factory = new HessianProxyFactory();
		       
		       IFileUpService service = null;
			try {
				service = (IFileUpService) factory.create(IFileUpService.class, url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//����IService�ӿڵ�ʵ������
			try {
				InputStream is = new BufferedInputStream(new FileInputStream("C:/Users/pc-zw/Pictures/2008625204205.jpg"));
				String result = service.uploadFile("der", "jpg",is);
				if (result!="file up error") {
					System.out.println("�ļ��ϴ��ɹ���");
				}else{
					System.out.println("�ļ��ϴ�ʧ�ܣ�");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}
}
