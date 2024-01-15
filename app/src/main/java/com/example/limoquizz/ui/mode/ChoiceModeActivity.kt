package com.example.limoquizz.ui.mode

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.limoquizz.R
import com.example.limoquizz.game.Player
import com.example.limoquizz.ui.UIHelper
import com.example.limoquizz.ui.mode.solo.SoloGameActivity

class ChoiceModeActivity : AppCompatActivity() {

    private lateinit var startSoloGameBtn : Button
    private lateinit var startDuoGameBtn : Button
    private lateinit var inputPseudo : EditText
    private lateinit var limcoinTextView : TextView

    private var players : ArrayList<Player> = ArrayList()

    private val uiHelper : UIHelper = UIHelper(this)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_choice)
        supportActionBar?.hide()
        this.players = (intent.getSerializableExtra("players") ?: ArrayList<Player>()) as ArrayList<Player>

        this.limcoinTextView = findViewById(R.id.limcoins)
        this.startSoloGameBtn = findViewById(R.id.startSoloGameBTN)
        this.startDuoGameBtn = findViewById(R.id.startDuoGameBTN)
        this.inputPseudo = findViewById(R.id.editText)


        if(this.players.size > 0){
            val p: Player = this.players.last()

            this.inputPseudo.setText(p.getPseudo())

            val limcoinText: String = p.getLimcoins().toString() + " Limcoins"
            this.limcoinTextView.setText(limcoinText)


        }

        this.inputPseudo.addTextChangedListener(object : TextWatcher {
             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

             }

             override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

             }

             override fun afterTextChanged(p0: Editable?) {
                 val newText = p0.toString()
                 val player: Player? = findPlayer(newText)

                 if(player != null){
                     val limcoinText: String = player.getPseudo() + "\n" + player.getLimcoins().toString() + " Limcoins"
                     limcoinTextView.setText(limcoinText)
                 }else{
                     limcoinTextView.setText("500 Limcoins")
                 }
             }
        })

        this.uiHelper.setUiButtons(
            arrayListOf(this.startSoloGameBtn, this.startDuoGameBtn)
        )
    }

    fun startChoiceDifficultyActivitySOLO(btn: View) {
        this.uiHelper.uiResetAllBtnStyle()
        this.uiHelper.uiSetSelectedStyleBtn(btn as Button)
        val intent = Intent(this, ChoiceDifficultyActivity::class.java)

        val p: Player = this.findPlayer(this.inputPseudo.text.toString()) ?: Player(this.inputPseudo.text.toString())
        p.removeCoins(100)
        this.players.add(p)
        intent.putExtra("players", players)
        intent.putExtra("gameMode", "solo")

        startActivity(intent)
    }
    fun startChoiceDifficultyActivityDUO(btn: View) {
        this.uiHelper.uiResetAllBtnStyle()
        this.uiHelper.uiSetSelectedStyleBtn(btn as Button)
        //val intent = Intent(this, DuoGameActivity::class.java)
        //startActivity(intent)
    }

    fun findPlayer(inputText: String): Player?
    {
        for(player: Player in this.players.reversed()){
            if(inputText == player.getPseudo()){
                return player
            }
        }
        return null
    }
}