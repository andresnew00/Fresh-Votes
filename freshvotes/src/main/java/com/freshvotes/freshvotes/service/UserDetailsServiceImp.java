package com.freshvotes.freshvotes.service;

import com.freshvotes.freshvotes.domain.User;
import com.freshvotes.freshvotes.repositories.UserRepo;
import com.freshvotes.freshvotes.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("Username and password invalid");

        return new CustomSecurityUser(user);
    }
}
