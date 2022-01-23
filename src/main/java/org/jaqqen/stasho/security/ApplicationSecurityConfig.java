package org.jaqqen.stasho.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.jaqqen.stasho.security.StashORole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
            .antMatchers("/api/**")
                .hasAnyRole(ADMIN.name())
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        final String defaultPw = passwordEncoder.encode("test");
        UserDetails adminUserDetails = User.builder()
            .username("admin")
            .password(defaultPw)
            .roles(ADMIN.name())
            .build();

        UserDetails commonUser = User.builder()
            .username("commoner")
            .password(defaultPw)
            .roles(USER.name())
            .build();

        return new InMemoryUserDetailsManager(adminUserDetails, commonUser);
    }
}
