package com.budgetShoe.search.dto

class SearchCriteria(
        gender: Gender, size: Int, color: String, category: Category, productType: Category,
        priceRange: IntRange,
        discountList: List<String>
)
