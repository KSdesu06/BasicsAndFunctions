package com.example

import java.util.*

fun main(args: Array<String>) {
    feedTheFish()
    swim()
    swim("slow")
    swim(speed = "turtle-like")
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Use a when expression
fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "Bread"
        "Wednesday" -> "Bloodworm"
        "Thursday" -> "Noodles"
        "Friday" -> "Snails"
        "Sunday" -> "Lettuce"
        else -> "nothing"
    }
}

// Create a default value for a parameter
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// Compact functions
fun isTooHot(temperature: Int) = temperature > 40
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
