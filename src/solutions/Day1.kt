package solutions

import day

fun main() = day(1) {
    part1 { inputInts.filterIndexed { index, i -> index != 0 && i > inputInts[index - 1] }.size }

    part2 {
        inputInts.filterIndexed { index, _ ->
            index < inputInts.size - 3 &&
                    inputInts.slice(index + 1..index + 3).sum() > inputInts.slice(index..index + 2).sum()
        }.size
    }

    expectPart1 = 7
    expectPart2 = 5
}
// Better Solution by BestAuto:
/*
override fun part1() = input.map { it.toInt() }.zipWithNext().count { it.first < it.second }

override fun part2() = input.map(String::toInt).windowed(3)
    .map { it.sum() }.zipWithNext().count { it.first < it.second }
*/
