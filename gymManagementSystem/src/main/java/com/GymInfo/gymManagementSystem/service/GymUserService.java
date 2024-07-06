package com.GymInfo.gymManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GymInfo.gymManagementSystem.bean.GymUser;
import com.GymInfo.gymManagementSystem.dao.GymUserRepository;

@Service
public class GymUserService implements UserDetailsService {

    @Autowired
    private GymUserRepository repository;

    private String type;

    public void save(GymUser user) {
        repository.save(user);
    }

    public String getType() {
        return type;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GymUser user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        type = user.getType();
        return user;
    }

    public GymUser findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}