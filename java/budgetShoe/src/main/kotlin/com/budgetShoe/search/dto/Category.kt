package com.budgetShoe.search.dto

import javax.persistence.*

@Entity
class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",
        var imageUrl: String?  = null,
        var state: State = State.NOT_ACTIVE,
        @Column(name = "subCategories")
        @ManyToMany
        var children: List<Category>? = null
){
        //Replace all special char with - and remove all spaces
        var code: kotlin.String = name.replace("\\s".toRegex(), "-").replace("\\W".toRegex(), "-")
}
