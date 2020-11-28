package fr.ul.miage.clickandcollect.core.userdetails;

import fr.ul.miage.clickandcollect.users.User;
import fr.ul.miage.clickandcollect.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.core.userdetails.User.withUsername;

@RequiredArgsConstructor
public class DBUserDetailsService implements UserDetailsService {

    private final UsersRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).orElseThrow();

        return withUsername(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .roles(user.getRole())
                .build();
    }
}
