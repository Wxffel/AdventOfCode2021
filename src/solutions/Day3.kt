package solutions

import day

fun main() = day(3) {
    part1 {
        inputLines.asSequence().map { it.mapIndexed { index, c -> index to c } }.flatten()
            .groupBy({ it.first }, { it.second }).map { it.value.sorted()[it.value.size / 2] }
            .joinToString("").toInt(2).let { it * it.xor(4095) } // 31 for testcase
    }

    part2 {

        var oxygen = "test1"
        var binariesOxygen = inputLines

        var scrubber = "test2"
        var binariesScrubber = inputLines

        println("InputLines = $inputLines")

        for (column in 0 until inputLines[0].length) {

            if (binariesOxygen.size <= 1) {
                println("Only one oxygen-binary was left, taking it.")
                oxygen = binariesOxygen.first()
            } else {

                val mostCommon = binariesOxygen.asSequence().map { it.mapIndexed { index, c -> index to c } }.flatten()
                    .groupBy({ it.first }, { it.second })
                    .map { it.value.sorted()[it.value.size / 2] }[column]

                binariesOxygen = binariesOxygen.filter { binary ->
                    binary[column] == mostCommon
                }

                println("binariesOxygen[depth=$column] = $binariesOxygen")
                oxygen = binariesOxygen.first()
            }

            if (binariesScrubber.size <= 1) {
                println("Only one scrubber-binary was left, taking it.")
                scrubber = binariesScrubber.first()
            } else {

                val leastCommon = binariesOxygen.asSequence().map { it.mapIndexed { index, c -> index to c } }.flatten()
                    .groupBy({ it.first }, { it.second })
                    .map { it.value.sorted()[it.value.size / 2] }[column].let { if (it == '1') '0' else '1' }


                binariesScrubber = binariesScrubber.filter { binary ->
                    binary[column] == leastCommon
                }

                println("binariesScrubber[depth=$column] = $binariesScrubber")
                scrubber = binariesScrubber.first()
            }

        }
        println("oxygen = $oxygen")
        println("scrubber = $scrubber")

        oxygen.toInt(2) * scrubber.toInt(2)
    }

    expectPart1 = 22 * 9
    expectPart2 = 23 * 10
}