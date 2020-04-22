package com.budgetShoe.search.dto

class Filters(
        genders: List<Gender>, sizes: List<Int>, colors: List<String>, categories: List<Category>, productTypes: List<Category>,
        priceRange: IntRange,
        discountList: List<String>
)
