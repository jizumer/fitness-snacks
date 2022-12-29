package com.jizumer.fitnesssnacks

import org.springframework.stereotype.Service

@Service
class SnacksService(val snacksRepository: SnacksRepository) {
    fun findAll(): List<Snack> = snacksRepository.findAll().toList()
}