package com.delnortedevs.sportkotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreSoccerViewModel : ViewModel()  {

    init {
        Log.d("ScoreViewModel", "ScoreViewModel created!")
    }

    private val _scoreTeamA  = MutableLiveData(0)
    private var _scoreTeamB = MutableLiveData(0)

    val scoreTeamA : LiveData<Int>   = _scoreTeamA
    val scoreTeamB : LiveData<Int>  = _scoreTeamB

    fun addScoreA() {
        _scoreTeamA.value =   scoreTeamA.value?.plus(1)

    }

    fun addScoreB() {
        _scoreTeamB.value = scoreTeamB.value?.plus(1)
    }


    fun resetScores(){
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ScoreViewModel", "ScoreViewModel destroyed!")
    }

}