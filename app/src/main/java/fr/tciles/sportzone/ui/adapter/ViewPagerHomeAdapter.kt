package fr.tciles.sportzone.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerHomeAdapter(
        private val fa: FragmentActivity,
        val fragments: List<Fragment>,
        val fragmentsTitles: List<String>
        ) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return fragments.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}