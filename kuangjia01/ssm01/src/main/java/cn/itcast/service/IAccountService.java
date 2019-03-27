package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
