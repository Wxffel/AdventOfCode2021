package solutions

import day

fun main() = day(2) {

    part1 {
        inputLines.let { l ->
            fun f(c: Char) = l.filter { it[0] == c }.sumOf { it.last().digitToInt() }
            f('f') * (f('d') - f('u'))
        }

        // or

        // sorted order: d f u
        val s = inputLines.groupBy({ it[0] }, { it.last().digitToInt() }).toSortedMap().map { it.value.sum() }
        s[1] * (s[0] - s[2])

        // or

        val g = inputLines.groupBy({ it[0] }, { it.last().digitToInt() })
        g['f']!!.sum() * (g['d']!!.sum() - g['u']!!.sum())
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