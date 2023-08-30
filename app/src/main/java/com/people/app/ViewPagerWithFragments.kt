package com.people.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.people.app.databinding.ViewpagerWithFragmentsBinding

class ViewPagerWithFragments : AppCompatActivity() {

    lateinit var binding: ViewpagerWithFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewpagerWithFragmentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }

}