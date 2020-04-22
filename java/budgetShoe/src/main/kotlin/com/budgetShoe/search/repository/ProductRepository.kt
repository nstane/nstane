package com.budgetShoe.search.repository

import com.budgetShoe.search.dto.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long>
