package com.jizumer.fitnesssnacks

import org.springframework.stereotype.Service
import java.time.LocalDateTime.now

@Service
class SnacksService(val snacksRepository: SnacksRepository) {
    fun findAll(): List<Snack> = snacksRepository.findAll().toList()
    fun next(): Snack? {
        if (itsTimeForANewSnack()) {
            return proposeSnack()
        }
        return null
    }

    private fun proposeSnack(): Snack {
        return lastNotDone() ?: proposeNewSnack()
    }

    private fun proposeNewSnack(): Snack = Snack("plank", null)

    private fun lastNotDone(): Snack? = snacksRepository.findByDoneNullOrderByDoneDesc().firstOrNull()

    private fun itsTimeForANewSnack(): Boolean {
        return snacksRepository.findByDoneNotNullOrderByDoneDesc()
            .firstOrNull { snack: Snack ->
                snack.done != null
                        && snack.done.isAfter(now().minusMinutes(30))
            } == null

    }
}