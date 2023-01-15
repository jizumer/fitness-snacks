package com.jizumer.fitnesssnacks

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
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

    @Test
    fun `should return a new snack proposal when 'next' method is called for the first time`() {
        val snacksRepository = mockk<SnacksRepository>()
        val snacksService = SnacksService(snacksRepository)

        val snacksMock = emptyList<Snack>()
        every { snacksRepository.findAll() } returns snacksMock


        assertNull(snacksService.next())
        verify(exactly = 1) { snacksRepository.findAll() }
        verify(exactly = 0) { snacksRepository.save(any<Snack>()) }
    }
}