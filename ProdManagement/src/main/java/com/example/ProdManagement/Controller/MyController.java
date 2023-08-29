package com.example.ProdManagement.Controller;

import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Model.Response.ResponseClass;
import com.example.ProdManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> creatingProduct(@RequestBody ProductRequest productRequest){
        return productService.addingProduct(productRequest);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ResponseClass>> gettingAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<ResponseClass> gettingProductById(@PathVariable("id") Integer productCode){
        return productService.getProductById(productCode);
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<String> updatingProduct(@PathVariable("id") Integer productCode, @RequestBody ProductRequest productRequest){
        return productService.updateProductData(productRequest,productCode);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> deletingProduct(@PathVariable("id") Integer productCode){
        return productService.deleteProduct(productCode);
    }


}