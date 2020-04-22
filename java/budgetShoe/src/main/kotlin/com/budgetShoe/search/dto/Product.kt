package com.budgetShoe.search.dto

import com.budgetShoe.budgetShoe.search.dto.ShoeType
import com.budgetShoe.search.Availability
import javax.persistence.*

@Entity
class Product(
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",
        var code: String = "",
        var desc: String = "",
        @OneToMany
        var imageUrls: List<Image>? = null,
        @OneToMany
        var categories: List<Category>? = null,

        @OneToMany
        var subCategories: List<Category>? = null,
        var gender: Gender? = null,
        var availability: Availability? = null,
        var state: State = State.NOT_ACTIVE,
        @OneToOne
        var price: Price? = null
)
