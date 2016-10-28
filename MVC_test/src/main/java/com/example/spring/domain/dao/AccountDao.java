package com.example.spring.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.spring.domain.entity.Account;

@Repository
public class AccountDao {
    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public Account selectOne(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        String sql = "SELECT username, password, last_name, first_name FROM account WHERE username=:username";

        Account account = new Account();
        account.setUsername(username);
        List<Account> accountList = npJdbcTemplate.query(sql, new BeanPropertySqlParameterSource(account),
                new BeanPropertyRowMapper<Account>(Account.class));
        if (accountList.isEmpty()) {
            return null;
        }
        return accountList.get(0);
    }
}
