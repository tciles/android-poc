package fr.tciles.sportzone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import fr.tciles.sportzone.R
import fr.tciles.sportzone.databinding.FragmentHomeBinding
import fr.tciles.sportzone.ui.adapter.ViewPagerHomeAdapter


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter: ViewPagerHomeAdapter? = activity?.let {
            ViewPagerHomeAdapter(
                it, listOf(
                    ProfileFragment(),
                    RunningFragment(),
                    CyclingFragment()
                ), listOf(
                    "Profile",
                    "Running",
                    "Cycling",
                )
            )
        }

        binding.vpHome.adapter = viewPagerAdapter

        val tabIcons: List<Int> = listOf(
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_directions_run_24,
            R.drawable.ic_baseline_directions_bike_24
        )

        TabLayoutMediator(binding.tabLayoutHome, binding.vpHome) { tab, position ->
            tab.text = (binding.vpHome.adapter as ViewPagerHomeAdapter).fragmentsTitles[position]
            tab.setIcon(tabIcons[position])
        }.attach()
    }
}