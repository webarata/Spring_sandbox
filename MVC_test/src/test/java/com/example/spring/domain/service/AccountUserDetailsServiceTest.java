package com.example.spring.domain.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.spring.base.AccountUserDetails;
import com.example.spring.domain.dao.AccountDao;
import com.example.spring.domain.dao.GrantedAuthorityDao;
import com.example.spring.domain.entity.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountUserDetailsServiceTest {
    @InjectMocks
    private AccountUserDetailsService accountUserDetailsService;

    @Mock
    private AccountDao mockAccountDao;

    @Mock
    private GrantedAuthorityDao mockGrantedAuthorityDao;

    @Test
    public void testLoadUserByUsername() throws Exception {
        Account account = new Account("user1", "password", "姓", "名");
        doReturn(account).when(mockAccountDao).selectOne("user1");
        doReturn(AuthorityUtils.createAuthorityList("ROLE_APP1", "ROLE_APP2"))
                .when(mockGrantedAuthorityDao).selectByUsername("user1");

        UserDetails actualUserDetails = accountUserDetailsService
                .loadUserByUsername("user1");

        assertThat(actualUserDetails, is(notNullValue()));
        assertThat(actualUserDetails, instanceOf(AccountUserDetails.class));
        AccountUserDetails actualAccountUserDetails = (AccountUserDetails) actualUserDetails;
        assertThat(actualAccountUserDetails.getUsername(), is("user1"));
        assertThat(actualAccountUserDetails.getPassword(), is("password"));
        assertThat(actualAccountUserDetails.isEnabled(), is(true));
        assertThat(actualAccountUserDetails.isAccountNonExpired(), is(true));
        assertThat(actualAccountUserDetails.isAccountNonLocked(), is(true));
        assertThat(actualAccountUserDetails.isCredentialsNonExpired(),
                is(true));

        Account actualAccount = actualAccountUserDetails.getAccount();
        assertThat(actualAccount, is(notNullValue()));
        assertThat(actualAccount.getUsername(), is("user1"));
        assertThat(actualAccount.getPassword(), is("password"));
        assertThat(actualAccount.getLastName(), is("姓"));
        assertThat(actualAccount.getFirstName(), is("名"));

        Collection<? extends GrantedAuthority> actualAuthorities = actualUserDetails
                .getAuthorities();
        assertThat(actualAuthorities, is(notNullValue()));
        assertThat(actualAuthorities.size(), is(2));

        List<String> roles = actualAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        assertThat(roles, hasItems("ROLE_APP1", "ROLE_APP2"));
    }
}
