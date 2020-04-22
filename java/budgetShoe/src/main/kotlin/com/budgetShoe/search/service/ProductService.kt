package com.budgetShoe.search.service

import com.budgetShoe.search.dto.Product
import com.budgetShoe.search.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
        @Autowired val productRepository: ProductRepository

) {
    fun get(id: Long): Optional<Product> = productRepository.findById(id)
    fun getAll(): List<Product> = productRepository.findAll()
    fun add(product: Product): Product = productRepository.save(product);
}
