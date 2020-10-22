package ru.shop.oauthserver.principal;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.shop.dbtools.models.user.AuthoritiesEnum;
import ru.shop.dbtools.models.user.Status;
import ru.shop.dbtools.models.user.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class UserPrincipal implements UserDetails {


    private final String password;
    private final String username;
    private final Set<GrantedAuthority> authorities;
    private final boolean enabled;

    public UserPrincipal(User user) {
        this.password = user.getPassword();
        this.username = user.getEmail();
        this.authorities = user.getRole().getAuthorities().stream().map(this::getGrantedAuthority).collect(Collectors.toSet());
        this.enabled = user.getStatus().equals(Status.ACTIVE);
    }

    private SimpleGrantedAuthority getGrantedAuthority(AuthoritiesEnum authority) {
        return new SimpleGrantedAuthority(authority.name());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
