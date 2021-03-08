package com.sample.management.stateManagement.service;

import com.sample.management.stateManagement.domain.entity.dto.LoginUser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public interface LoginService {

    HashMap checkExists(LoginUser user) throws Exception;
}
