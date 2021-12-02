package solutions

import day

fun main() = day(2) {
    part1 {
        var depth = 0
        var horizontal = 0

        inputLines.forEach { line ->
            val (cmd, value) = line.split(" ")
            when (cmd) {
                "forward" -> horizontal += value.toInt()
                "up" -> depth -= value.toInt()
                "down" -> depth += value.toInt()
            }
        }
        horizontal * depth
    }

    part2 {
        var depth = 0
        var horizontal = 0
        var aim = 0

        inputLines.forEach { line ->
            val (cmd, value) = line.split(" ")
            when (cmd) {
                "forward" -> {
                    horizontal += value.toInt()
                    depth += aim * value.toInt()
                }
                "up" -> aim -= value.toInt()
                "down" -> aim += value.toInt()
            }
        }
        horizontal * depth
    }
    expectPart1 = 150
    expectPart2 = 900
}