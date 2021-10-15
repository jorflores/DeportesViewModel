package com.delnortedevs.deportesviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.delnortedevs.deportesviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var modoTablet = false

    val soccerfragment: SoccerFragment = SoccerFragment()
    val basketBallFragment = BasketBallFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modoTablet = binding.scoreContainerLarge != null

        //************
        val sportSelectorFragment  = SportSelectorFragment.newInstance(modoTablet)

       if(modoTablet){
           var fragmentManager = supportFragmentManager
           val fragmentTransaction = fragmentManager.beginTransaction()
           fragmentTransaction.add(R.id.fragment_container,sportSelectorFragment).addToBackStack(null).commit()
       }

    }


    fun openBasektBallFragment() {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.score_container_large,basketBallFragment).addToBackStack(null).commit()

    }

    fun openSoccerFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.score_container_large,soccerfragment).addToBackStack(null).commit()
    }
}