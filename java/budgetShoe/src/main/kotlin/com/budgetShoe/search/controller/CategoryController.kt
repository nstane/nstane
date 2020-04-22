package com.budgetShoe.search.controller

import com.budgetShoe.search.dto.Category
import com.budgetShoe.search.dto.Product
import com.budgetShoe.search.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(@Autowired val categoryService: CategoryService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Category = categoryService.get(id).get()

    @GetMapping
    fun getAll(): List<Category> = categoryService.getAll()

    @PostMapping
    fun add(@RequestBody category: Category): Category = categoryService.add(category)

    @PutMapping
    fun update(@RequestBody category: Category) = categoryService.update(category)

    @PostMapping("/byIds")
    fun findByIds(@RequestBody ids: List<Long>) = categoryService.findByIds(ids)

}
