package solutions

import day

fun main() = day(4) {

    val digitRegex = Regex("\\d+")

    part1 {
        val numbersToDraw = inputLines.first().split(',').map { it.toInt() }

        // chunk to boards
        val boardsChunked = inputLines.drop(2).filter { it.isNotBlank() }.chunked(5)

        val boards = boardsChunked.map { board ->
            board.map { row ->
                digitRegex.findAll(row).map { it.value.toInt() }.toList()
            }
        }

        numbersToDraw.forEachIndexed { index, drawnNumber ->

            val drawnNumbers = numbersToDraw.subList(0, index + 1)

            boards.forEach { board ->

                // row wins check
                board.forEach { row ->
                    if (drawnNumbers.containsAll(row)) {
                        // WINNING
                        val unmarkedNumbers = board.flatten().toMutableList()
                        unmarkedNumbers.removeAll(drawnNumbers)

                        return@part1 unmarkedNumbers.sum() * drawnNumber
                    }
                }

                // make columns
                val columns = board.map { row ->
                    row.mapIndexed { index, i -> index to i }
                }.flatten().groupBy({ it.first }, { it.second }).toList()


                // column wins check
                columns.forEach { column ->
                    if (drawnNumbers.containsAll(column.second)) {
                        val unmarkedNumbers = board.flatten().toMutableList()
                        unmarkedNumbers.removeAll(drawnNumbers)
                        return@part1 unmarkedNumbers.sum() * drawnNumber
                    }
                }
            }
        }
    }

    part2 {

        val numbersToDraw = inputLines.first().split(',').map { it.toInt() }
        val boardsChunked = inputLines.drop(2).filter { it.isNotBlank() }.chunked(5)
        val boards = boardsChunked.map { board ->
            board.map { row ->
                digitRegex.findAll(row).map { it.value.toInt() }.toList()
            }
        }

        fun findFirstWinning(remainingBoards: List<List<List<Int>>>): Int {

            val remainingBoardsMutable = remainingBoards.toMutableList()

            numbersToDraw.forEachIndexed { index, drawnNumber ->

                val drawnNumbers = numbersToDraw.subList(0, index + 1)

                remainingBoards.forEach { board ->

                    // row wins check
                    board.forEach { row ->
                        if (drawnNumbers.containsAll(row)) {
                            // first winning board [row]

                            if (remainingBoards.size == 1) {
                                val unmarkedNumbers = board.flatten().toMutableList()
                                unmarkedNumbers.removeAll(drawnNumbers)
                                return unmarkedNumbers.sum() * drawnNumber
                            }
                            remainingBoardsMutable.remove(board)
                            return findFirstWinning(remainingBoardsMutable)
                        }
                    }

                    // make columns
                    val columns = board.map { row ->
                        row.mapIndexed { index, i -> index to i }
                    }.flatten().groupBy({ it.first }, { it.second }).toList()


                    // column wins check
                    columns.forEach { column ->
                        if (drawnNumbers.containsAll(column.second)) {
                            // first winning board [column]

                            if (remainingBoards.size == 1) {
                                val unmarkedNumbers = board.flatten().toMutableList()
                                unmarkedNumbers.removeAll(drawnNumbers)
                                return unmarkedNumbers.sum() * drawnNumber
                            }
                            remainingBoardsMutable.remove(board)
                            return findFirstWinning(remainingBoardsMutable)
                        }
                    }
                }
            }
            return -1
        }
        findFirstWinning(boards)
    }
    expectPart1 = 188 * 24
    expectPart2 = 148 * 13
}