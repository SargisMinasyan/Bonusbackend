package com.example.demo.WebSecConfig;

import com.example.demo.UserDetilsServis.UserDetilesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

   /* @Autowired
    UserDetilesServise userDetilesServise;
*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.getDefaultUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("*/**").permitAll();
    }
}
