package com.example.restapimongodb.services;


import com.example.restapimongodb.models.UserModel;
import com.example.restapimongodb.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService
{

        @Autowired
        private UserRepository userRepository;

        public List<UserModel> getUsers()
        {
                //business logic
            return userRepository.findAll();

        }

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
        public UserModel insertIntoUsers(UserModel user)
        {
                String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encodedPass);
                UserModel insertedUser = userRepository.insert(user);
                return insertedUser;
        }

        public Optional<UserModel> getAUser(String id)
        {
                return userRepository.findById(id);
        }

        public void deleteAUser(String id)
        {
                userRepository.deleteById(id);
        }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                UserModel foundUser = userRepository.findByEmail(email);
                String UserN = foundUser.getEmail();
                String UserP = foundUser.getPassword();
                return new User(UserN,UserP, new ArrayList<>());
        }
}
