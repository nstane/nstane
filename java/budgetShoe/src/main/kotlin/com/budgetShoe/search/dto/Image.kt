package com.budgetShoe.search.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    val alt: String = "",
    val url: String = "",
    val heroImage: Boolean = false
)
