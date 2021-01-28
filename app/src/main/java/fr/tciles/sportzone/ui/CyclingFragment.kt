package fr.tciles.sportzone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import fr.tciles.sportzone.data.ProfileDataViewModel
import fr.tciles.sportzone.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {
    private lateinit var binding: FragmentCyclingBinding
    private val viewModel: ProfileDataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textInputPma.isEnabled = false
        binding.textInputFtp.isEnabled = false

        viewModel.pma.observe(viewLifecycleOwner, Observer<Int> { pma ->
            binding.textInputPma.setText(pma.toString())
        })

        viewModel.ftp.observe(viewLifecycleOwner, Observer<Int> { ftp ->
            binding.textInputFtp.setText(ftp.toString())
        })
    }
}