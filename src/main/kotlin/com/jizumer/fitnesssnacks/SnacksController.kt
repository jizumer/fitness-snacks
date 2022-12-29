package com.jizumer.fitnesssnacks

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("snacks")
class SnacksController(val snacksService: SnacksService) {
    @GetMapping("")
    fun getAll() = snacksService.findAll()
}