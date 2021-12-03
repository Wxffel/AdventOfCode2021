package solutions

import day
import kotlin.math.pow

fun main() = day(3) {
    fun mostCommon(binaries: List<String>) = binaries.map { it.withIndex() }.flatten()
        .groupBy({ it.index }, { it.value })
        .map { it.value.sorted()[it.value.size / 2] }

    part1 {
        val xorBy = 2.0.pow(inputLines.first().length).toInt() - 1 // by blue
        mostCommon(inputLines).joinToString("").toInt(2).let { it * (it xor xorBy) }
    }

    part2 {
        var oxygens = inputLines; var scrubbers = inputLines

        for (column in 0 until inputLines[0].length) {
            val mostCommon = mostCommon(oxygens)[column]
            val leastCommon = if (mostCommon(scrubbers)[column] == '1') '0' else '1'

            if (oxygens.size > 1)
                oxygens = oxygens.filter { it[column] == mostCommon }

            if (scrubbers.size > 1)
                scrubbers = scrubbers.filter { it[column] == leastCommon }
        }
        oxygens[0].toInt(2) * scrubbers[0].toInt(2)
    }
    expectPart1 = 22 * 9
    expectPart2 = 23 * 10
}