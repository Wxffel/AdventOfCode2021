package solutions

import day

fun main() = day(1) {
    part1 { inputInts.zipWithNext().count { it.first < it.second } }
    part2 { inputInts.windowed(4).count { it[0] < it[3] } }
    expectPart1 = 7
    expectPart2 = 5
}
