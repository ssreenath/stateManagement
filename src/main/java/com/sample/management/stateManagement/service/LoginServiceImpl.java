package com.sample.management.stateManagement.service;

import com.sample.management.stateManagement.dao.UserRepository;
import com.sample.management.stateManagement.domain.entity.User;
import com.sample.management.stateManagement.domain.entity.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;

@Service
public class LoginServiceImpl  implements LoginService{

    @Autowired
    UserRepository userdao;
    @Override
    public HashMap checkExists(LoginUser user) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        User loginUser = convertToUser(user);
        loginUser = userdao.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
        if(null != loginUser){
            loginUser.setPassword(null);
            loginUser.setDob(null);
            loginUser.setQualifcation(null);
            loginUser.setProducts(null);
            result.put("userInfo", loginUser);
            result.put("result", true);
        }else{
            result.put("result", false);
            result.put("error", "Invalid Credentials");
        }
        return result;
    }

    private User convertToUser(LoginUser loginUser) throws UnsupportedEncodingException {
       User user = new User();
       user.setUsername(loginUser.getUserId().toLowerCase());
        String base64encodedString = Base64.getEncoder().encodeToString(loginUser.getUserPassword().getBytes("utf-8"));
       user.setPassword(base64encodedString);
       return user;
    }
}
