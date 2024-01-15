package com.example.limoquizz.ui.score

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.limoquizz.R
import com.example.limoquizz.game.Player
import com.example.limoquizz.ui.mode.ChoiceModeActivity

class ScoreActivity : AppCompatActivity() {

    private var  players: ArrayList<Player> = ArrayList()
    lateinit var limocoins: TextView
    lateinit var score: TextView
    lateinit var top1: Button
    lateinit var top2: Button
    lateinit var top3: Button
    lateinit var restartBtn: Button
    lateinit var p: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_bis)
        supportActionBar?.hide()

        this.players = (intent.getSerializableExtra("players") ?: ArrayList<Player>()) as ArrayList<Player>
        val correctAnsNo: String? = intent.getStringExtra("correct")
        val totalAnsNo: String? = intent.getStringExtra("total")

        this.limocoins = findViewById(R.id.limcoins)
        this.score = findViewById(R.id.score)
        this.top1 = findViewById(R.id.top1)
        this.top2 = findViewById(R.id.top2)
        this.top3 = findViewById(R.id.top3)
        this.restartBtn = findViewById(R.id.restartBtn)

        this.p = this.players.last()
        if (correctAnsNo != null) {
            p.finalScore = correctAnsNo.toInt()
        }
        if (totalAnsNo != null) {
            p.finalOutOff = totalAnsNo.toInt()
        }

        displayLimcoins()
        displayScore()
        displayTop()


    }

    fun onRestartClicked(btn: View){
        val intent = Intent(this, ChoiceModeActivity::class.java)
        intent.putExtra("players", this.players)
        startActivity(intent)
    }

    fun displayLimcoins(){
        val txt: String = "${this.p.getPseudo()}\n${this.p.getLimcoins()} LIMCOINS"
        this.limocoins.setText(txt)
    }

    fun displayScore(){
        val txt = "SCORE\n${this.p.finalScore}/${this.p.finalOutOff}"
        this.score.setText(txt)
    }

    fun displayTop(){
        val sortedPlayers = this.players.sortedByDescending { it.finalScore }

        if(sortedPlayers.getOrNull(0) != null){
            this.top1.text = "#1 " + sortedPlayers.get(0).getPseudo()
        }

        if(sortedPlayers.getOrNull(1) != null){
            this.top2.text = "#2 " + sortedPlayers.get(1).getPseudo()
        }else{
            this.top2.text = "#2"
        }

        if(sortedPlayers.getOrNull(2) != null){
            this.top3.text = "#3 " + sortedPlayers.get(2).getPseudo()
        }else{
            this.top3.text = "#3"
        }
    }
}