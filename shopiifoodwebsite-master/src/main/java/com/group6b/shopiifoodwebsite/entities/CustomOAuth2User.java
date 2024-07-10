package com.group6b.shopiifoodwebsite.entities;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;
// dung để gói thông tin của đuối tượng và quyen hạn cua dôi tượng
public class CustomOAuth2User implements OAuth2User , UserDetails {

    private final OAuth2User oAuth2User; // luu tru thong tin nguoi dung
    private final Collection<? extends GrantedAuthority> authorities; // lưu trữ quyền hạn của ngươig dùng
        //
    public CustomOAuth2User(OAuth2User oAuth2User, Collection<? extends GrantedAuthority> authorities) {
        this.oAuth2User = oAuth2User;
        this.authorities = authorities;
    }


    @Override // kiểm tra và xác định các phương thức ghi đè
    public Map<String, Object> getAttributes() {
        // tra ve thuoc tinh nguoi dung
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // tra ve quyen han cua người dùng.
        return authorities;
    }

    @Override
    public String getPassword() {

        return "";
    }

    @Override
    public String getName() {
        // tra ve ten cu nguoi dùng
        return oAuth2User.getName();
    }

    @Override
    public String getUsername() {
        //tra ve emalo cua nguoi dung
        return oAuth2User.getAttribute("email");
    }

    @Override
    // kiểm  tra tài khoản có het hạn hay khong
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // kiểm tra tài khoản người dung co bị khóa hay khong
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // kiểm tra thông tin mật khẩu có dúng khong
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // kiểm tra tài khoản có được kích hoạt hay khogn

    public boolean isEnabled() {
        return true;
    }
}
