package solutions

import day

fun main() = day(2) {

    part1 {
        // sorted order: down, forward, up
        val s = inputLines.groupBy({ it[0] }, { it.last().digitToInt() }).toSortedMap().map { it.value.sum() }
        s[1] * (s[0] - s[2])
    }

    part2 {
        var horizontal = 0
        var depth = 0
        var aim = 0

        inputLines.forEach { line ->
            val split = line.split(" ")
            val value = split[1].toInt()

            when (split[0]) {
                "forward" -> {
                    horizontal += value
                    depth += aim * value
                }
                "up" -> aim -= value
                "down" -> aim += value
            }
        }
        horizontal * depth
    }
    expectPart1 = 150
    expectPart2 = 900
}