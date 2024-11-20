package com.rca.asset.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rca.asset.entity.UserData;
import com.rca.asset.repository.UserDataRepository;
import java.util.List;
import java.util.Optional;
@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    private UserDataRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userData = repository.findByEmail(username);
        //Convert userData to UserDetails
        return userData.map(UserDataDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public UserData loadCurrentUser(String username) throws UsernameNotFoundException {
        Optional<UserData> userDetail = repository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found " +
                        username));
    }

    public String addUser(UserData userData) {
        userData.setPassword(encoder.encode(userData.getPassword()));
        repository.save(userData);
        return "User Added Successfully";
    }

    public List<UserData> listAll() {
        return repository.findAll();
    }

    public void deleteUser(Integer id){
        repository.deleteById(id);
    }

    public Optional<UserData> updateUser(UserData userData,Integer id){
        return repository.findById(id).map(user ->{
            user.setName(userData.getName());
            user.setPassword(userData.getPassword());
            user.setEmail(userData.getEmail());
            user.setRoles(userData.getRoles());

            return repository.save(user);
        });
    }
}