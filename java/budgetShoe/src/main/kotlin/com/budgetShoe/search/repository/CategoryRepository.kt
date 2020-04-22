package com.budgetShoe.search.repository

import com.budgetShoe.search.dto.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional


@Repository
@Transactional
interface CategoryRepository : JpaRepository<Category, Long> {
    @Modifying
    @Query("update Category c set c.children = ?1 where c.id = ?2")
    fun updateCategory(children: List<Category>?, id:Long)

    @Query(value="select c.id from Category c where c.id in (?1)")
    fun findByIds(ids:List<Long>)
}
