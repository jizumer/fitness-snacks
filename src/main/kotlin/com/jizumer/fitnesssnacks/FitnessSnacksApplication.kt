package com.jizumer.fitnesssnacks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FitnessSnacksApplication

fun main(args: Array<String>) {
    runApplication<FitnessSnacksApplication>(*args)
}

@RestController
@RequestMapping("snacks")
class SnacksController {
    @GetMapping("")
    fun getAll() = listOf(Snack("squats", null))
}
