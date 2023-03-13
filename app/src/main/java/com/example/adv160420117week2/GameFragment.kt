package com.example.adv160420117week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName

            var playerTurn = view.findViewById<TextView>(R.id.txtTurn)
            playerTurn.text = "$playerName's turn"
        }
        var playerScore = 0
        var num1 = Random.nextInt(99)
        var num2 = Random.nextInt(99)
        val question = view.findViewById<TextView>(R.id.txtQuestion)
        question.text = "$num1 + $num2"
        var rightAnswer = num1 + num2
        val answer = view.findViewById<EditText>(R.id.txtAnswer)


        val submitBtn = view.findViewById<Button>(R.id.btnSubmit)
        submitBtn.setOnClickListener {
            if (answer.text.toString().toInt() == rightAnswer){
                playerScore++
                num1 = Random.nextInt(99)
                num2 = Random.nextInt(99)
                question.text = "$num1 + $num2"
                rightAnswer = num1 + num2
                answer.text.clear()
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}