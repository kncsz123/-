package com.wwj.showSystem.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wwj.showSystem.bo.Account;
import com.wwj.showSystem.service.AccountService;

/**
 * @author wwj
 * 用户模块
 * @RestController 让类编程控制对象
 * RequestMapping 请求映射
 * PostMapping  只能post请求映射
 */
@RestController

public class AccountApi {
	
	@Autowired
	private AccountService  accountService;
	
	/**
	 * 登陆接口
	 * 1. 方法可以被调用  
	 * 2. 输入和输出  （如何接收参数，接收参数接收json格式数据） (输出的数据格式我们也定义成json的格式) （json数据格式）
	 * 3. 逻辑如何去实现
	 * 4. 接收姓名和学号等的参数看成是一个整体（数据对象）
	 * 5. Map就是键值对的数据结构
	 */
	@PostMapping("/api/user/login")
	public Map login(@RequestBody Account  account){
		System.err.println(account.getIdNum()+account.getName());
//		System.err.println("该登录方法被调用");
//		//1. 接收参数
//		System.out.println(account.getIdNum()+account.getName());
//		//2. 验证（实现业务）（拿着数据和数据库中的数据去匹配）
//		
//		//3. 返回数据（反馈结果）
////		Map Info =  new HashMap();
////		Info.put("result", 1);
		return accountService.loginService(account);
		
		
	}

}
