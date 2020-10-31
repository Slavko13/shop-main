package ru.shop.oauthserver.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shop.dbtools.repositories.UserRepo;
import ru.shop.oauthserver.principal.UserPrincipal;


@Service("userDetails")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;


    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepo.findByEmail(email)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("{AbstractUserDetailsAuthenticationProvider.badCredentials}"));
    }



}
