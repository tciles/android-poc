package fr.tciles.sportzone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import fr.tciles.sportzone.R


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLoginGoCycling: Button = view.findViewById(R.id.btn_go_cycling)
        val btnLoginGoRunning: Button = view.findViewById(R.id.btn_go_running)

        btnLoginGoCycling.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cyclingFragment)
        }

        btnLoginGoRunning.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_runningFragment)
        }
    }
}