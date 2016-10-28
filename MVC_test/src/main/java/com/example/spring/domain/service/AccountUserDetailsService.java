package com.example.spring.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring.base.AccountUserDetails;
import com.example.spring.domain.dao.AccountDao;
import com.example.spring.domain.dao.GrantedAuthorityDao;
import com.example.spring.domain.entity.Account;

@Service
public class AccountUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private GrantedAuthorityDao grantedAuthorityDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account account = Optional.ofNullable(accountDao.selectOne(username))
                .orElseThrow(
                        () -> new UsernameNotFoundException("user not found"));
        return new AccountUserDetails(account,
                grantedAuthorityDao.selectByUsername(username));
    }
}
