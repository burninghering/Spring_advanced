package com.example.spartaspring.controller;

import com.example.spartaspring.dto.ProductMypriceRequestDto;
import com.example.spartaspring.dto.ProductRequestDto;
import com.example.spartaspring.model.Product;
import com.example.spartaspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

//@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    private final ProductService productService;

    @Autowired //@RequiredArgsConstructor를 지우고 Autowired 붙여줌
    public ProductController(ProductService productService){
        this.productService=productService;
    }


    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {

        //서비스에 넘겨주기

        Product product = productService.createProduct(requestDto);

        // 응답 보내기
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {


        Product product = productService.updateProduct(id,requestDto);

        // 응답 보내기 (업데이트된 상품 id)
        return product.getId();
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {


        List<Product> products = productService.getProducts();

        // 응답 보내기
        return products;
    }
}
