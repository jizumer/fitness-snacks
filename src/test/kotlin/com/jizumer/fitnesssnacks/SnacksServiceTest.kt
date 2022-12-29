package com.jizumer.fitnesssnacks

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDateTime

internal class SnacksServiceTest {

    @Test
    fun `should make use of the repository when calling findAll`() {
        val snacksRepository = mockk<SnacksRepository>()
        val snacksService = SnacksService(snacksRepository)
        val snacksMock = listOf(Snack("some-type", LocalDateTime.now()))
        every { snacksRepository.findAll() } returns snacksMock

        assertEquals(
            snacksService.findAll(), snacksMock
        )


        verify(atLeast = 1) { snacksRepository.findAll() }
    }
}