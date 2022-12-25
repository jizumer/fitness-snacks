package com.jizumer.fitnesssnacks

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class SnacksControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val baseUrl = "/snacks"

    @Test
    fun `should return hello world`() {
        mockMvc.get("$baseUrl/hello")
            .andExpect {
                status { isOk() }
                content {string("Hello world")}
            }
    }
}