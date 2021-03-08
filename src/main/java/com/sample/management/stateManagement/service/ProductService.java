package com.sample.management.stateManagement.service;

import com.sample.management.stateManagement.domain.entity.dto.LoginUser;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
    HashMap fetchDetailsByID(LoginUser user) throws Exception;

    HashMap deleteProducts(List<String> prodList) throws Exception;
}
