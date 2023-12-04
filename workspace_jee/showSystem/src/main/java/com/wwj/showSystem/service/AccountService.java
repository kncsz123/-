package com.wwj.showSystem.service;

import java.util.Map;

import com.wwj.showSystem.bo.Account;

/**
 * @author wangweijie
 * 账户服务:登陆验证、信息录入
 */
public interface AccountService {
	/**
	 * 登陆验证的服务
	 * @param account 账户信息
	 * @return
	 */
	public Map loginService(Account account);

}
