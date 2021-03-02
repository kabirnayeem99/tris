package io.github.kabirnayeem99.tris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val buttonSelected = view as Button

//        Toast.makeText(this, "${buttonSelected.id} selected", Toast.LENGTH_SHORT).show()

        var cellId = 0
        when (buttonSelected.id) {
            R.id.btnFirstCFirstR -> cellId = 1
            R.id.btnSecondCFirstR -> cellId = 2
            R.id.btnThirdCFirstR -> cellId = 3
            R.id.btnFirstCSecondR -> cellId = 4
            R.id.btnSecondCSecondR -> cellId = 5
            R.id.btnThirdCSecondR -> cellId = 6
            R.id.btnFirstCThirdR -> cellId = 7
            R.id.btnSecondCThirdR -> cellId = 8
            R.id.btnThirdCThirdR -> cellId = 9
        }

        playGame(cellId, buttonSelected)
    }


    var activePlayer = 1
    var playerFirstSelectedCellList = ArrayList<Int>()
    var playerSecondSelectedCellList = ArrayList<Int>()

    private fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 1) {

            // changes the appearance of the selected cell
            buttonSelected.text = Constants.PLAYER_FIRST_SELECTED_SYMBOL
            buttonSelected.setBackgroundResource(Constants.PLAYER_FIRST_SELECTED_COLOR)

            // adds the cell to the selected cell list
            playerFirstSelectedCellList.add(cellId)

            // switches the player to the other one
            activePlayer = 2

        } else if (activePlayer == 2) {

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

        checkWinner()
    }

    private fun checkWinner() {
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

        if (winner == 1) {
            Toast.makeText(this, "First Player Won", Toast.LENGTH_SHORT).show()
        } else if (winner == 2) {
            Toast.makeText(this, "Second Player Won", Toast.LENGTH_SHORT).show()
        }
    }
}