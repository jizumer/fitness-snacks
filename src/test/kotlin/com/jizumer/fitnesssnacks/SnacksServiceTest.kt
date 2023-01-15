package com.jizumer.fitnesssnacks

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
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

        every { snacksRepository.findByDoneNotNullOrderByDoneDesc() } returns emptyList<Snack>()

        assertNotNull(
            snacksService.next()
        )
        verify(exactly = 1) { snacksRepository.findByDoneNotNullOrderByDoneDesc() }
        //verify(exactly = 1) { snacksRepository.save(any<Snack>()) }
    }

    @Test
    fun `should return an empty response when the last snack was done less than 30 minutes ago`() {
        val snacksRepository = mockk<SnacksRepository>()
        val snacksService = SnacksService(snacksRepository)

        val snackMock = Snack("some-type", LocalDateTime.now().minusMinutes(29))
        every { snacksRepository.findByDoneNotNullOrderByDoneDesc() } returns listOf(snackMock)


        assertNull(snacksService.next())
        verify(exactly = 1) { snacksRepository.findByDoneNotNullOrderByDoneDesc() }
        verify(exactly = 0) { snacksRepository.save(any<Snack>()) }
    }

    @Test
    fun `should propose a new snack when there are proposed snacks but none done`() {
        val snacksRepository = mockk<SnacksRepository>()
        val snacksService = SnacksService(snacksRepository)

        val snackMock = Snack("some-type", null)
        every { snacksRepository.findByDoneNotNullOrderByDoneDesc() } returns listOf(snackMock)


        assertNotNull(snacksService.next())
        verify(exactly = 1) { snacksRepository.findByDoneNotNullOrderByDoneDesc() }
        verify(exactly = 0) { snacksRepository.save(any<Snack>()) }
    }
}