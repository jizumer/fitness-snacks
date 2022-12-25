package com.jizumer.fitnesssnacks

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class SnacksControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val baseUrl = "/snacks"

    @Test
    fun `should return the full list of snacks`() {

        mockMvc.get(baseUrl)
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].type") {
                    value(
                        "squats"
                    )
                }
            }
    }
}