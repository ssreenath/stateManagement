package com.sample.management.stateManagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.management.stateManagement.domain.entity.dto.LoginUser;
import com.sample.management.stateManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/admin/home")
    public ModelAndView productHome()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping("/admin/fetchProduct")
    public ResponseEntity<HashMap> fetchProducts(LoginUser user) {
        HashMap result = null;
        try{
            result = productService.fetchDetailsByID(user);
        }catch (Exception e){
            result = new HashMap();
            result.put("result", false);
            result.put("error", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/admin/products")
    public ResponseEntity<HashMap> deleteProducts(@RequestParam("prodList") String strProdList) {
        HashMap result = null;
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<String> prodList = new ArrayList<>();
            prodList = Arrays.asList(mapper.readValue(strProdList, String[].class));
            result = productService.deleteProducts(prodList);
        }catch (Exception e){
            result = new HashMap();
            result.put("result", false);
            result.put("error", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }
}
