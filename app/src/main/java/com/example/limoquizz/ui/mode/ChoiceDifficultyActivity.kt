package com.example.limoquizz.ui.mode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.limoquizz.R
import com.example.limoquizz.game.Player
import com.example.limoquizz.ui.UIHelper
import com.example.limoquizz.ui.mode.solo.SoloGameActivity

class ChoiceDifficultyActivity : AppCompatActivity() {

    private lateinit var startGameLentBtn : Button
    private lateinit var startGameMoyenBtn : Button
    private lateinit var startGameRapideBtn : Button
    private lateinit var startChoixGameBtn : Button
    private lateinit var limcoinTextView : TextView
    private lateinit var gameMode : String

    private var players : ArrayList<Player> = ArrayList()

    private val uiHelper : UIHelper = UIHelper(this)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_choice_difficulty)
        supportActionBar?.hide()
        this.players = (intent.getSerializableExtra("players") ?: ArrayList<Player>()) as ArrayList<Player>
        this.gameMode = intent.getStringExtra("gameMode") ?: ""

        this.limcoinTextView = findViewById(R.id.limcoins)
        this.startGameLentBtn = findViewById(R.id.startGameLentBTN)
        this.startGameMoyenBtn = findViewById(R.id.startGameMoyenBTN)
        this.startGameRapideBtn = findViewById(R.id.startGameRapideBTN)
        this.startChoixGameBtn = findViewById(R.id.startChoixGameBTN)


        if(this.players.size > 0){
            val p: Player = this.players.last()

            val limcoinText: String = p.getPseudo() + "\n" + p.getLimcoins().toString() + " Limcoins"
            this.limcoinTextView.setText(limcoinText)
        }
    }

    fun startSoloGame(nbQuestion: Int, difficulty: Long) {
        val intent = Intent(this, SoloGameActivity::class.java)
        intent.putExtra("players", this.players)
        intent.putExtra("difficulty", difficulty)
        intent.putExtra("nbQuestions", nbQuestion)

        startActivity(intent)
    }
    fun startDuoGame(nbQuestion: Int, difficulty: Long) {
    }

    fun startGameLent(btn: View){
        this.startGame(btn, 11,105)
    }
    fun startGameMoyen(btn: View){
        this.startGame(btn, 15,60)
    }

    fun startGameRapide(btn: View){
        this.startGame(btn, 15,45)
    }

    fun startChoiceModeActivity(btn: View){
        val intent = Intent(this, ChoiceModeActivity::class.java)
        intent.putExtra("players", this.players)

        startActivity(intent)
    }

    fun startGame(btn: View, nbQuestion: Int, difficulty: Long){
        this.uiHelper.uiResetAllBtnStyle()
        this.uiHelper.uiSetSelectedStyleBtn(btn as Button)

        when(this.gameMode){
            "solo" -> startSoloGame(nbQuestion, difficulty)
            "duo" -> startDuoGame(nbQuestion, difficulty)
            else -> startChoiceModeActivity(btn)
        }
    }
}