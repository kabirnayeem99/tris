package io.github.kabirnayeem99.tris

import android.util.Log
import android.widget.Button

class Game {

    private val TAG = "Game"

    var activePlayer = 1
    var playerFirstSelectedCellList = ArrayList<Int>()
    var playerSecondSelectedCellList = ArrayList<Int>()

    private fun checkWinner(): Int {
        var winner = -1

        // Rows
        // row 1
        if (playerFirstSelectedCellList.contains(1)
            && playerFirstSelectedCellList.contains(2)
            && playerFirstSelectedCellList.contains(3)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(1)
            && playerSecondSelectedCellList.contains(2)
            && playerSecondSelectedCellList.contains(3)
        ) {
            winner = 2
        }

        // row 2
        if (playerFirstSelectedCellList.contains(4)
            && playerFirstSelectedCellList.contains(5)
            && playerFirstSelectedCellList.contains(6)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(4)
            && playerSecondSelectedCellList.contains(5)
            && playerSecondSelectedCellList.contains(6)
        ) {
            winner = 2
        }

        // row 3
        if (playerFirstSelectedCellList.contains(7)
            && playerFirstSelectedCellList.contains(8)
            && playerFirstSelectedCellList.contains(9)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(7)
            && playerSecondSelectedCellList.contains(8)
            && playerSecondSelectedCellList.contains(9)
        ) {
            winner = 2
        }


        // Columns
        // column 1
        if (playerFirstSelectedCellList.contains(1)
            && playerFirstSelectedCellList.contains(4)
            && playerFirstSelectedCellList.contains(7)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(1)
            && playerSecondSelectedCellList.contains(4)
            && playerSecondSelectedCellList.contains(7)
        ) {
            winner = 2
        }

        // column 2
        if (playerFirstSelectedCellList.contains(2)
            && playerFirstSelectedCellList.contains(5)
            && playerFirstSelectedCellList.contains(8)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(2)
            && playerSecondSelectedCellList.contains(5)
            && playerSecondSelectedCellList.contains(8)
        ) {
            winner = 2
        }

        // row 3
        if (playerFirstSelectedCellList.contains(3)
            && playerFirstSelectedCellList.contains(6)
            && playerFirstSelectedCellList.contains(9)
        ) {
            winner = 1
        }
        if (playerSecondSelectedCellList.contains(3)
            && playerSecondSelectedCellList.contains(6)
            && playerSecondSelectedCellList.contains(9)
        ) {
            winner = 2
        }

        return winner
    }

    fun playGame(cellId: Int, buttonSelected: Button): Int {
        if (!playerFirstSelectedCellList.contains(cellId)
            && !playerSecondSelectedCellList.contains(cellId)
        ) {
            if (activePlayer == 1 && playerFirstSelectedCellList.size < 3) {

                Log.d(TAG, "playGame: ${playerFirstSelectedCellList.size}")

                // changes the appearance of the selected cell
                buttonSelected.text = Constants.PLAYER_FIRST_SELECTED_SYMBOL
                buttonSelected.setBackgroundResource(Constants.PLAYER_FIRST_SELECTED_COLOR)

                // adds the cell to the selected cell list
                playerFirstSelectedCellList.add(cellId)

                // switches the player to the other one
                activePlayer = 2

            } else if (activePlayer == 2 && playerSecondSelectedCellList.size < 3) {

                // changes the appearance of the selected cell
                buttonSelected.text = Constants.PLAYER_SECOND_SELECTED_SYMBOL
                playerSecondSelectedCellList.add(cellId)

                // adds the cell to the selected cell list
                buttonSelected.setBackgroundResource(Constants.PLAYER_SECOND_SELECTED_COLOR)

                // switches the player to the other one
                activePlayer = 1
            }

            // this button can't be clicked again
            // buttonSelected.isEnabled = false

        }
        return checkWinner()

    }


}