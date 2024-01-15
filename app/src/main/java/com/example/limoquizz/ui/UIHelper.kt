package com.example.limoquizz.ui

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Button
import com.example.limoquizz.R

@SuppressLint("UseCompatLoadingForDrawables")
class UIHelper(
    private val context: Context
) {

    private var uiButtons : ArrayList<Button> = arrayListOf()

    fun setUiButtons(btns: ArrayList<Button>) {
        this.uiButtons = btns
    }

    fun getUiButtons(): ArrayList<Button> {
        return this.uiButtons
    }

    fun uiResetAllBtnStyle() {
        for(btn: Button in this.uiButtons) {
            this.uiResetBtnStyle(btn)
        }
    }

    fun uiEnableAllBtn() {
        for(btn: Button in this.uiButtons) {
            this.uiEnableBtn(btn)
        }
    }

    fun uiDisableAllBtn() {
        for(btn: Button in this.uiButtons) {
            this.uiDisableBtn(btn)
        }
    }

    private fun uiEnableBtn(btn: Button){
        btn.isClickable = true
    }

    private fun uiDisableBtn(btn: Button){
        btn.isClickable = false
    }

    private fun uiResetBtnStyle(btn: Button?) {
        if (btn != null) {
            btn.background = this.context.getDrawable(R.drawable.option_bg)
        }
    }

    fun uiSetSelectedStyleBtn(btn: Button?) {
        if (btn != null) {
            btn.background = this.context.getDrawable(R.drawable.selected_bg)
        }
    }

    private fun isBtnSelected(btn: Button): Boolean{
        return btn.background == this.context.getDrawable(R.drawable.selected_bg)
    }

    fun getBtnSelected(): Button?
    {
        for(btn: Button in this.uiButtons){
            if(this.isBtnSelected(btn))
                return btn
        }

        return null
    }

    private fun uiSetCorrectStyleBtn(btn: Button?) {
        if (btn != null) {
            btn.background = this.context.getDrawable(R.drawable.right_bg)
        }
    }

    private fun isBtnCorrect(btn: Button): Boolean{
        return btn.background == this.context.getDrawable(R.drawable.right_bg)
    }

    fun uiToggleCorrectResetedStyleBtn(btn: Button?){
        if(btn != null) {
            when (this.isBtnCorrect(btn)) {
                true -> { this.uiResetBtnStyle(btn) }
                else -> { this.uiSetCorrectStyleBtn(btn) }
            }
        }
    }

    fun uiToggleCorrectSelectedStyleBtn(btn: Button?){
        if(btn != null){
            when(this.isBtnCorrect(btn)){
                true -> { this.uiSetSelectedStyleBtn(btn) }
                else -> { this.uiSetCorrectStyleBtn(btn) }
            }
        }
    }


    fun uiSetWrongStyleBtn(btn: Button?) {
        if (btn != null) {
            btn.background = this.context.getDrawable(R.drawable.wrong_bg)
        }
    }
}