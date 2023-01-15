package com.jizumer.fitnesssnacks

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SnacksService(val snacksRepository: SnacksRepository) {
    fun findAll(): List<Snack> = snacksRepository.findAll().toList()
    fun next(): Snack? {
        if (itsTimeForANewSnack()) {
            return proposeNewSnack()
        }
        return null
    }

    private fun proposeNewSnack(): Snack {
        TODO("Not yet implemented")
    }

    private fun itsTimeForANewSnack(): Boolean {
        return snacksRepository.findByDoneNotNullOrderByDoneDesc()
            .firstOrNull()
            ?.done
            ?.isBefore(LocalDateTime.now().minusMinutes(30)) == true
    }
}