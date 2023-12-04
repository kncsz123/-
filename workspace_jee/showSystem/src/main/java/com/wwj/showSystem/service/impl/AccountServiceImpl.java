package com.wwj.showSystem.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwj.showSystem.bo.Account;
import com.wwj.showSystem.mapper.AccountMapper;
import com.wwj.showSystem.service.AccountService;

import cn.hutool.core.util.StrUtil;

//用于将类生成对象，并且表明他是一个具体服务对象
@Service
public class AccountServiceImpl implements AccountService{
	
	//引用数据操作对象
	@Autowired
	private  AccountMapper accountMapper;

	@Override
	public Map loginService(Account account) {
		// TODO Auto-generated method stub
		Map  info  = new HashMap();
		//1. 获取当前的账户信息
		Account  c_account = accountMapper.selectAccount(account);
		if(StrUtil.isEmptyIfStr(c_account)) {
			info.put("result", 0);
		}else {
			info.put("result", 1);
		}
		return info;
	}

}
