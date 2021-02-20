package tech.becoming.clickandcollect.app.core.auth;

import tech.becoming.clickandcollect.app.users.User;
import tech.becoming.clickandcollect.app.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.springframework.security.core.userdetails.User.withUsername;

@RequiredArgsConstructor
public class DBUserDetailsService implements UserDetailsService {

    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository
                .findByUsername(username)
                .orElseThrow(AuthFailException::new);

        // https://docs.spring.io/spring-security/site/docs/4.2.15.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html#withDefaultPasswordEncoder--

        return withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
