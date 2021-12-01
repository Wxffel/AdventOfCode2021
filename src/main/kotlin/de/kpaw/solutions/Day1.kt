package de.kpaw.solutions

import de.kpaw.Day

fun main() = Day01.run()

object Day01 : Day(1) {
    override fun part1() =
        inputLinesAsInts.filterIndexed { index, i -> index != 0 && i > inputLinesAsInts[index - 1] }.size

    override fun part2() =
        inputLinesAsInts.filterIndexed { index, _ ->
            index < inputLinesAsInts.size - 3 &&
            inputLinesAsInts.slice(index+1..index+3).sum() > inputLinesAsInts.slice(index..index+2).sum()
        }.size
}

// Better Solution by BestAuto:
/*
override fun part1() = input.map { it.toInt() }.zipWithNext().count { it.first < it.second }

override fun part2() = input.map(String::toInt).windowed(3)
    .map { it.sum() }.zipWithNext().count { it.first < it.second }
*/
