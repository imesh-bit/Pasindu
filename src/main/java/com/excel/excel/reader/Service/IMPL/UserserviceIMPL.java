package com.excel.excel.reader.Service.IMPL;
import com.excel.excel.reader.Entity.User;
import com.excel.excel.reader.Repo.UserRepository;
import com.excel.excel.reader.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
