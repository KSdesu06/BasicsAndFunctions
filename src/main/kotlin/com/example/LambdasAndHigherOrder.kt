package com.example

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}


fun main() {
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    fun increaseDirty(start: Int) = start + 1
    println(updateDirty(30, waterFilter))
    println(updateDirty(15, ::increaseDirty))

    // last parameter call syntax
    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) {dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}