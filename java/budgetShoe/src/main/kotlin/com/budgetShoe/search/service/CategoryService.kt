package com.budgetShoe.search.service

import com.budgetShoe.search.dto.Category
import com.budgetShoe.search.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class CategoryService(@Autowired val repository: CategoryRepository) {

    fun get(id: Long): Optional<Category> = repository.findById(id)
    fun getAll(): List<Category> = repository.findAll()
    fun add(category: Category): Category = repository.save(category)
    fun update(category: Category) {
        val parent = repository.findById(category.id).orElseGet(null)
        parent?.let {
            val children = category.children?.map { repository.findById(it.id) }
            parent.children = children?.map { it.orElseGet(null) }?.filter { it != null }
            repository.saveAndFlush(category)
        }

    }
    fun findByIds(ids:List<Long>) = repository.findByIds(ids)
}
