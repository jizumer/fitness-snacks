package com.jizumer.fitnesssnacks

import org.springframework.data.repository.CrudRepository

interface SnacksRepository : CrudRepository<Snack, String> {

    fun findByDoneNotNullOrderByDoneDesc(): List<Snack>
}