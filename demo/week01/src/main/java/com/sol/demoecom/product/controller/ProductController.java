package com.sol.demoecom.product.controller;

import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.product.controller.response.ProductDetail;
import com.sol.demoecom.product.controller.response.ProductsItem;
import com.sol.demoecom.product.controller.response.SearchProduct;
import com.sol.demoecom.product.exception.ProductNotFoundException;
import com.sol.demoecom.product.mapper.ProductDetailMapper;
import com.sol.demoecom.product.mapper.ProductItemMapper;
import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/search")
    public ResponseSuccess<SearchProduct> login(@RequestParam String keyword) {
        List<ProductModel> products =  productRepository.findByNameContainsIgnoreCase(keyword);
        List<ProductsItem> productsItems = products.stream().map(p -> new ProductItemMapper().mapRow(p)).collect(Collectors.toList());
        int totalCount = (int) productRepository.count();
        int count = products.size();
        return new ResponseSuccess(new SearchProduct(totalCount, count, productsItems));
    }

    @GetMapping("/products/{productId}")
    public ResponseSuccess<ProductDetail> getDetailById(@PathVariable UUID productId) {
        Optional<ProductModel> product =  productRepository.findById(productId);
        if(product.isPresent()) {
            return new ResponseSuccess(new ProductDetailMapper().mapRow(product.get()));
        }
        throw new ProductNotFoundException();
    }
}
