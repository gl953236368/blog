package com.px.config.filter;

import com.px.utils.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        System.out.println("当前token:"+tokenHeader);
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
//        super.doFilterInternal(request, response, chain);
        chain.doFilter(request,response);
    }

    // 从token中获取用户权限
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader){
        try {
            String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
            String username = JwtTokenUtils.getUsername(token);
            String roles = JwtTokenUtils.getRoles(token);
            System.out.println(String.format("jwt解密的username:%s;roles:%s", username, roles));
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            for(String role:roles.split(",")){
                if(StringUtils.isNotBlank(role)){
                    grantedAuthorityList.add(new SimpleGrantedAuthority(role));
                }
            }
            if(username != null){
                System.out.println("jwt return");
                return new UsernamePasswordAuthenticationToken(username,null, grantedAuthorityList);
            }


        }catch (Exception e){
            return null;
        }
        return null;
    }

}
