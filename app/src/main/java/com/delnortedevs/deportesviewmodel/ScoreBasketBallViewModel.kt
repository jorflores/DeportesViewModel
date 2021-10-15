package com.delnortedevs.sportkotlin

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreBasketBallViewModel  : ViewModel() {

    init {
        Log.d("ScoreViewModel", "ScoreViewModel created!")
    }

    private var _scoreTeamA = 0
    private var _scoreTeamB = 0

    val scoreTeamA get() = _scoreTeamA
    val scoreTeamB get() = _scoreTeamB

    fun addScoreA(points : Int) {
        _scoreTeamA+= points
    }

    fun addScoreB(points : Int) {
        _scoreTeamB+= points
    }


    fun resetScores(){
        _scoreTeamA = 0
        _scoreTeamB = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ScoreViewModel", "ScoreViewModel destroyed!")
    }

}