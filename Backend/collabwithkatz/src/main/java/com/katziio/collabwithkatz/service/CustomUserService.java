package com.katziio.collabwithkatz.service;

import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private EditorRepository editorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        this.editorRepository.findById(103L)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Editor editor = this.editorRepository.findById(1L).get();
//       return optionalEditor.get();

        return new User(editor.getName(),editor.getPassword());

    }
}

class User implements UserDetails {

    private String name;
    private String password;

    User(String name,String password)
    {
        this.name = name;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}