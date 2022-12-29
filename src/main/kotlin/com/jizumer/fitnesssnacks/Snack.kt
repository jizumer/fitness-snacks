package com.jizumer.fitnesssnacks

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("SNACKS")
data class Snack(@Id val id: String, val type: String, val done: LocalDateTime?) {
    constructor(type: String, done: LocalDateTime?) : this(UUID.randomUUID().toString(), type, done)
}