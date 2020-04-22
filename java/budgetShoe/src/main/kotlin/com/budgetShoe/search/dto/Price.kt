package com.budgetShoe.search.dto

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var originalPrice: Double = 0.0
    var price: Double = 0.0
    var discountPercentValue: Int = 1
    var discountPercent: String = ""
}
