package com.jizumer.fitnesssnacks

import java.time.LocalDateTime
import java.util.*

data class Snack(val id: String, val type: String, val done: LocalDateTime?) {
    constructor(type: String, done: LocalDateTime?) : this(UUID.randomUUID().toString(), type, done)
}