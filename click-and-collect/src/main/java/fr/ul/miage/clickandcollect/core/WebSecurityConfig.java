package fr.ul.miage.clickandcollect.core;

import fr.ul.miage.clickandcollect.core.userdetails.SecurityProperties;
import fr.ul.miage.clickandcollect.core.userdetails.UserDetailsFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;

// https://spring.io/guides/gs/securing-web/
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityProperties properties;
    private final UserDetailsFactory detailsFactory;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // https://stackoverflow.com/a/14020466/1107450
        // jetbrains://idea/settings?name=Editor--Code+Style
        // Enable format markers
        //@formatter:off
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/v1.yml").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .anyRequest()
                .authenticated()
            .and()
                .httpBasic();
        //@formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(OPTIONS, "/**")
                .antMatchers(GET, "/favicon.ico");
    }

    @Bean
    @Override
    // https://docs.spring.io/spring-security/site/docs/4.2.15.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html#withDefaultPasswordEncoder--
    public UserDetailsService userDetailsService() {
        return detailsFactory.build(properties.getStorage());
    }
}