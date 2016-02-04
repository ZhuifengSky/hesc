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

public class TestHession2 {

	public static void main(String[] args) {
		String url = "http://localhost:8080/hess/fileUpService";
		HessianProxyFactory factory = new HessianProxyFactory();
		       
		       IFileUpService service = null;
			try {
				service = (IFileUpService) factory.create(IFileUpService.class, url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//创建IService接口的实例对象
			try {
				InputStream is = new BufferedInputStream(new FileInputStream("G:/公司项目/财务系统/环球财务系统业务处理逻辑.doc"));
				String result = service.downLoadFile("ss", "haha");
				System.out.println(result);
				if (result!="file up error") {
					System.out.println("文件上传成功！");
				}else{
					System.out.println("文件上传失败！");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.exit(0);
	}
}
