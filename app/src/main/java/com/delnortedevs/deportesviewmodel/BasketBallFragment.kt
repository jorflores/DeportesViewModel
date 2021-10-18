package com.delnortedevs.deportesviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.delnortedevs.deportesviewmodel.databinding.FragmentBasketBallBinding
import com.delnortedevs.sportkotlin.ScoreBasketBallViewModel
import com.delnortedevs.sportkotlin.ScoreSoccerViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private var _binding: FragmentBasketBallBinding? = null
private val binding get() = _binding!!


/**
 * A simple [Fragment] subclass.
 * Use the [BasketBallFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasketBallFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private val viewModel: ScoreBasketBallViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.scoreTeamA.observe(viewLifecycleOwner,{newscore -> binding.teamAScore.text = newscore.toString() })
        viewModel.scoreTeamB.observe(viewLifecycleOwner,{newscore -> binding.teamBScore.text = newscore.toString() })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding  = FragmentBasketBallBinding.inflate(inflater,container,false)


        binding.teamA3.setOnClickListener{

            viewModel.addScoreA(3)
        }

        binding.teamA2.setOnClickListener{

            viewModel.addScoreA(2)
        }

        binding.teamA1.setOnClickListener{

            viewModel.addScoreA(1)
        }

        binding.teamB3.setOnClickListener{
            viewModel.addScoreB(3)
        }

        binding.teamB2.setOnClickListener{
            viewModel.addScoreB(2)
        }

        binding.teamB1.setOnClickListener{
            viewModel.addScoreB(1)



        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BasketBallFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BasketBallFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}