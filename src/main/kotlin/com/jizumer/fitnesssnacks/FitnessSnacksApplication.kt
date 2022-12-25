package com.jizumer.fitnesssnacks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@SpringBootApplication
class FitnessSnacksApplication

fun main(args: Array<String>) {
    runApplication<FitnessSnacksApplication>(*args)
}

data class Snack(val id: String, val type: String, val done: LocalDateTime?)

@RestController
@RequestMapping("snacks")
class SnacksController {
    @GetMapping("")
    fun getAll() = listOf(Snack("1", "squats", null))
}
