package com.delnortedevs.deportesviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.delnortedevs.deportesviewmodel.databinding.FragmentSportSelectorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"



private var _binding: FragmentSportSelectorBinding? = null
private val binding get() = _binding!!

/**
 * A simple [Fragment] subclass.
 * Use the [SportSelectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SportSelectorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var modoTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            modoTablet = it.getBoolean(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSportSelectorBinding.inflate(inflater, container, false)

        binding.imageViewSoccer.setOnClickListener{

            if (modoTablet) {
                (activity as MainActivity).openSoccerFragment()
            }
            else
                findNavController().navigate(R.id.action_sportSelectorFragment3_to_soccerFragment)
        }

        binding.imageViewBasketball.setOnClickListener{
            if (modoTablet){
                (activity as MainActivity).openBasektBallFragment()

            } else
            findNavController().navigate(R.id.action_sportSelectorFragment3_to_basketBallFragment)
        }

        // Inflate the layout for this fragment
        return  binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SportSelectorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(modoTablet: Boolean) =
            SportSelectorFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, modoTablet)

                }
            }
    }
}