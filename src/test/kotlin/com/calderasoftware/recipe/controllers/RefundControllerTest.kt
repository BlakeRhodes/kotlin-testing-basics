package com.calderasoftware.recipe.controllers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

// TODO: Example 7
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class RefundControllerTest(
    @Autowired private val restTemplate: TestRestTemplate
) {
    @LocalServerPort
    private var port: Int = 0

    @ParameterizedTest
    @CsvSource(
        "123",
        "234",
        "345",
    )
    fun `status should return message Server Ok!`(orderNumber: String) {

        val expected = ResponseEntity(RefundResponse(orderNumber), HttpStatus.OK)

        val result = restTemplate.getForEntity(
            "http://localhost:$port/refunds/$orderNumber",
            RefundResponse::class.java
        )

        assertEquals(expected.statusCode, result.statusCode)
        assertEquals(expected.body, result.body)
    }
}