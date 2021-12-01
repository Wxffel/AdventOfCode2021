@file:Suppress("MemberVisibilityCanBePrivate")

package de.kpaw

import java.io.File

abstract class Day(val dayOfMonth: Int) {

    val inputFile get() =
        File(this::class.java.classLoader.getResource("input/Day$dayOfMonth.txt")?.file
            ?: throw IllegalStateException("An input file for this day could not be found"))

    val inputString get() = inputFile.readText()
    val inputLines get() = inputFile.readLines()

    val inputLinesAsInts get() = inputFile.readLines().map { it.toInt() }

    val inputStringGrouped get() = inputString.split("${System.lineSeparator()}${System.lineSeparator()}")
    val inputLinesGrouped get() = inputStringGrouped.map { it.split(System.lineSeparator()) }

    fun runPart1() {
        println("| Running part 1 of puzzle day $dayOfMonth |")
        println(part1())
    }

    fun runPart2() {
        println("| Running part 2 of puzzle day $dayOfMonth |")
        println(part2())
    }

    fun run() {
        println("| Running solutions of puzzle day $dayOfMonth |")
        println("\nPart 1: " + part1())
        println("--------------------------------------------")
        println("Part 2: " + part2())
        println("\n| Finished solution of puzzle day $dayOfMonth |")
    }

    protected abstract fun part1(): Any?
    protected abstract fun part2(): Any?

}
