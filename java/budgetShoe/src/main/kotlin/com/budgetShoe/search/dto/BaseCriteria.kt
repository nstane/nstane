package com.budgetShoe.search.dto

open class BaseCriteria(val gender: List<Gender>,
                        val size:Int,
                        val color: String,
                        val category: List<Category>,
                        val productType: Category
)
