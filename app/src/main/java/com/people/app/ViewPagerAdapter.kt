package com.people.app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var count = 3
    override fun getCount(): Int {
       return count
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> FragmentOne()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position){
            0 -> "Tab1"
            1 -> "Tab2"
            2 -> "Tab3"
            else -> "Hey"
        }

    }

}