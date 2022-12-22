package com.omen.ecommerce.service;

import com.omen.ecommerce.model.CustomUserDetail;
import com.omen.ecommerce.model.User;
import com.omen.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.map(CustomUserDetail::new).get();
    }
}
