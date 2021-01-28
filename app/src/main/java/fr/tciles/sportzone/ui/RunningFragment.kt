package fr.tciles.sportzone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.tciles.sportzone.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {
    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}