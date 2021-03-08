package com.sample.management.stateManagement.service;

import com.sample.management.stateManagement.dao.ProductRepository;
import com.sample.management.stateManagement.domain.entity.Product;
import com.sample.management.stateManagement.domain.entity.User;
import com.sample.management.stateManagement.domain.entity.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productdao;

    @Override
    public HashMap fetchDetailsByID(LoginUser user) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        User loginUser = convertToUser(user);
        List<Product> productList = productdao.findByUser(loginUser);
        if(null != productList){
            for(int i=0; i<productList.size(); i++){
                productList.get(i).setUser(null);
            }
            result.put("productList", productList);
            result.put("result", true);
        }else{
            result.put("result", false);
            result.put("error", "Failed to fetch details");
        }
        return result;
    }

    @Override
    public HashMap deleteProducts(List<String> prodList) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try{
            List<Product> productList = convertToProduct(prodList);
            productdao.deleteAll(productList);
            result.put("message", "Successfully Deleted Products");
            result.put("result", true);
        }catch (Exception e){
            result.put("message", e.getMessage());
            result.put("result", false);
        }
        return result;
    }

    private List<Product> convertToProduct(List<String> prodList) {
        List<Product> productList = new ArrayList<>();
        prodList.forEach(prod -> {
            Product product = new Product();
            product.setProductId(Long.valueOf(prod));
            productList.add(product);
        });
        return productList;
    }

    private User convertToUser(LoginUser loginUser) throws Exception {
        User user = new User();
        user.setUserId(Long.parseLong(loginUser.getUserId()));
        return user;
    }
}
