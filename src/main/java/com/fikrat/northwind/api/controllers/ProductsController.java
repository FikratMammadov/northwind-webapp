package com.fikrat.northwind.api.controllers;

import com.fikrat.northwind.business.abstracts.ProductService;
import com.fikrat.northwind.core.utilities.results.DataResult;
import com.fikrat.northwind.core.utilities.results.Result;
import com.fikrat.northwind.core.utilities.results.SuccessDataResult;
import com.fikrat.northwind.entities.concretes.Product;
import com.fikrat.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @PostMapping ("add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("getbyproductname")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
                                                             @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("getByProductNameOrCategoryId")
    DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName,categoryId);
    }

    @GetMapping("getByCategoryIdIn")
    DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping("getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo-1,pageSize);
    }

    @GetMapping("getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }
}
