package com.calderasoftware.recipe.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("refunds")
class RefundController {
    @GetMapping("/{orderNumber}")
    fun get(@PathVariable orderNumber: String): RefundResponse {
        return RefundResponse(orderNumber)
    }
}

data class RefundResponse(val orderNumber: String, val message: String = "No Refunds")