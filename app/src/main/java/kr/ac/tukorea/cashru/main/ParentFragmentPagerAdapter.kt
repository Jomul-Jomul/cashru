package kr.ac.tukorea.cashru.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ParentFragmentPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

override fun createFragment(position: Int): Fragment {
    return when (position) {
        0 -> HFragment()
        1 -> TFragment()
        else -> WFragment()
        }
    }
}
