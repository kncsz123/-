package com.wwj.showSystem.mapper;
/**
 * @author wangweijie
 * Account数据操作
 */

import org.apache.ibatis.annotations.Mapper;

import com.wwj.showSystem.bo.Account;
// 找接口下面的实现的xml文件
@Mapper
public interface AccountMapper {
	/**
	 * 输入账户信息参数，查询数据库是否存在该信息（对象）
	 * @param account
	 * @return
	 */
	public Account selectAccount(Account account);

}
