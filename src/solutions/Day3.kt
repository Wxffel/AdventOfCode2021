package solutions

import day

fun main() = day(3) {
    part1 {
        inputLines.asSequence().map { it.mapIndexed { index, c -> index to c } }.flatten()
            .groupBy({ it.first }, { it.second }).map { it.value.sorted()[it.value.size / 2] }
            .joinToString("").toInt(2).let { it * it.xor(4095) } // 31 for testcase
    }
    expectPart1 = 22 * 9
}