package com.example.spring.domain.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.spring.domain.entity.Account;

@Repository
public class GrantedAuthorityDao {
    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public Collection<GrantedAuthority> selectByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return Collections.<GrantedAuthority>emptyList();
        }
        String sql = "SELECT role FROM account_role WHERE username=:username";

        Account account = new Account();
        account.setUsername(username);
        List<Map<String, Object>> roleList = npJdbcTemplate.queryForList(sql,
                new BeanPropertySqlParameterSource(account));
        String[] roles = roleList.stream().map(v -> v.get("role")).toArray(size -> new String[size]);

        return AuthorityUtils.createAuthorityList(roles);
    }
}
