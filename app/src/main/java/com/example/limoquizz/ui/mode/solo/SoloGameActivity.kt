package com.example.limoquizz.ui.mode.solo

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.limoquizz.R
import com.example.limoquizz.game.Board
import com.example.limoquizz.game.Player
import com.example.limoquizz.game.Question
import com.example.limoquizz.ui.UIHelper
import com.example.limoquizz.ui.score.ScoreActivity
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class SoloGameActivity : AppCompatActivity() {

    private var players : ArrayList<Player> = ArrayList()

    private var nbQuestions: Int = 11
    private var difficulty: Long = 105
    lateinit var board: Board

    lateinit var limcoinsTextView: TextView
    lateinit var countDown:TextView
    lateinit var questions:TextView
    lateinit var option1:Button
    lateinit var option2:Button
    lateinit var option3:Button
    lateinit var option4:Button

    private val uiHelper: UIHelper = UIHelper(this)


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_solo)
        supportActionBar?.hide()

        this.nbQuestions = intent.getIntExtra("nbQuestions", 11)
        this.difficulty = intent.getLongExtra("difficulty", 105)
        this.players = (intent.getSerializableExtra("players") ?: ArrayList<Player>()) as ArrayList<Player>
        this.board = Board(this.players.last())

        limcoinsTextView = findViewById(R.id.limcoins)
        countDown = findViewById(R.id.countdown)
        questions = findViewById(R.id.questions)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)


        this.board.generateQuestions(this.nbQuestions);


        changeQuestionsDisplay()

        countdown()

    }


    private fun countdown(){
        val duration:Long=TimeUnit.SECONDS.toMillis(this.difficulty)

        val that = this@SoloGameActivity


        object: CountDownTimer(duration, 100) {
            override fun onTick(millisUntilFinished: Long) {

                val sDuration:String= String.format(Locale.FRENCH,
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))

                countDown.text = sDuration

                when(millisUntilFinished){
                    in 1..5000 -> {
                        if(countDown.currentTextColor == ContextCompat.getColor(that, R.color.white))
                            countDown.setTextColor(ContextCompat.getColor(that, R.color.black))
                        else countDown.setTextColor(ContextCompat.getColor(that, R.color.white))
                    }
                    else -> {

                    }
                }

            }
            override fun onFinish() {
                startScoreActivity()
            }
        }.start()
    }

    private fun startScoreActivity(){
        val intent = Intent(this, ScoreActivity::class.java)

        intent.putExtra("correct",this.board.nbCorrectAns.toString())
        intent.putExtra("total", this.board.getAllSelectedQuestions().size.toString())
        intent.putExtra("players", this.players)

        startActivity(intent)
    }

    private fun checkCorrectAns(optionSelected: Button? = null){
        when(this.board.statut){
            "play" -> {
                val duration: Long = TimeUnit.SECONDS.toMillis(2)
                val handler = Handler(Looper.getMainLooper())


                object : CountDownTimer(duration, 100) {
                    override fun onTick(millisUntilFinished: Long) {
                        handler.post {
                            Log.d("SoloGameActivity", optionSelected?.text.toString())
                            if (board.isTheCorrectAns(optionSelected?.text.toString())) {
                                uiHelper.uiToggleCorrectSelectedStyleBtn(optionSelected)
                            }
                        }
                    }

                    override fun onFinish() {
                        handler.postDelayed({
                            if (board.issetNextQuestion()) {
                                board.nextQuestion()
                                changeQuestionsDisplay()
                                uiHelper.uiResetAllBtnStyle()
                                uiHelper.uiEnableAllBtn()
                            } else {
                                board.updateScores()
                                startScoreActivity()
                            }
                        }, 2000)
                    }
                }.start()
            }
            "end" ->  {
                for (btn: Button in this.uiHelper.getUiButtons()) {
                    if (this.board.isTheCorrectAns(btn.text.toString())) {
                        this.uiHelper.uiToggleCorrectResetedStyleBtn(btn)
                    }
                }
            }
        }

    }

    private fun checkWrongAns(optionSelected: Button ){
        this.uiHelper.uiDisableAllBtn()

        if (!this.board.isTheCorrectAns(optionSelected.text.toString())) {
            this.board.statut = "end"
            this.uiHelper.uiSetWrongStyleBtn(optionSelected)
            checkCorrectAns()
            thread{
                Thread.sleep(2000)
                startScoreActivity()
            }
        }
    }

    private fun changeQuestionsDisplay() {
        val limcoinsText: String = this.board.player.getPseudo() + "\n" + this.board.player.getLimcoins().toString() + " Limcoins"
        this.limcoinsTextView.setText(limcoinsText)

        val q: Question = this.board.getCurrentQuestion()
        val newq: String = "${this.board.currentIndex+1}. " + q.question

        this.questions.text = newq
        this.option1.text = q.option1
        this.option2.text = q.option2
        this.option3.text = q.option3
        this.option4.text = q.option4

        this.uiHelper.setUiButtons(
            arrayListOf(this.option1, this.option2, this.option3, this.option4)
        )
    }

    fun onOptionClicked(btn: View){
        // sélection du bouton
        val button: Button = btn as Button
        this.uiHelper.uiResetAllBtnStyle()
        this.uiHelper.uiSetSelectedStyleBtn(button)
        this.board.userSelectAns(button.text.toString())

        // vérifications
        checkWrongAns(button)
        checkCorrectAns(button)
    }





}