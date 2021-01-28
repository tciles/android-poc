package fr.tciles.sportzone.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import fr.tciles.sportzone.R
import fr.tciles.sportzone.ui.adapter.ViewPagerHomeAdapter


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        // (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(false)
        // (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById(R.id.vp_home)
        val viewPagerAdapter: ViewPagerHomeAdapter? = activity?.let {
            ViewPagerHomeAdapter(it, listOf(
                    RunningFragment(),
                    CyclingFragment()
            ), listOf(
                    "Running",
                    "Cycling",
            ))
        }
        viewPager.adapter = viewPagerAdapter

        val tabIcons: List<Int> = listOf(
                R.drawable.ic_baseline_directions_run_24,
                R.drawable.ic_baseline_directions_bike_24
        )

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout_home)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = (viewPager.adapter as ViewPagerHomeAdapter).fragmentsTitles[position]
            tab.setIcon(tabIcons[position])
        }.attach()
    }
}