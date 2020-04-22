package com.budgetShoe.search.controller

import com.budgetShoe.search.dto.Product;
import com.budgetShoe.search.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController(@Autowired
                        val productService: ProductService
) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Product = productService.get(id).get()

    @GetMapping
    fun getAll(): List<Product> = productService.getAll()

    @PostMapping
    fun add(@RequestBody product: Product): Product = productService.add(product)

}
