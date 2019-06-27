package org.csu.mypetstore.service.impl;

import org.csu.mypetstore.MypetstoreApplicationTests;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AccountServiceImplTest extends MypetstoreApplicationTests {

   @Autowired
    private AccountService accountService;

    @Test
    public void TestgetAccount() {
        Account a = accountService.getAccount("j2ee");
        assertEquals("存在用户名j2ee",a.getUsername(),"j2ee");
    }

    @Test
    public void TestgetAccount1() {
        Account account = accountService.getAccount("a");
        assertNotNull("a用户不存在",account);
    }

    @Test
    public void TestgetAccount2() {
        Account account = accountService.getAccount("j2ee","j2ee");
        assertNotNull("j2ee用户不存在",account);
    }


    @Test
    public void TestUpdate() {
        Account account = accountService.getAccount("a");
        account.setCity("beijing");
        accountService.updateAccount(account);
        assertEquals("beijing",account.getCity());
    }

    @Test
    public void TestUpdate2() {
        Account account = accountService.getAccount("j2ee");
        account.setCity("beijing");
        accountService.updateAccount(account);
        assertEquals("beijing",account.getCity());
    }

}