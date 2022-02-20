package com.springboot.dynamodb.repositories;

import com.springboot.dynamodb.models.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ProductInfoRepository extends
        CrudRepository<ProductInfo, String> {

    Optional<ProductInfo> findById(String id);
}