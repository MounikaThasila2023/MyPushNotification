package com.people.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.people.app.databinding.ViewPager2Binding

class ViewPager2 : AppCompatActivity() {

    private lateinit var binding: ViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ViewPager2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager2()
    }

    private fun setupViewPager2() {
        val list: MutableList<String> = ArrayList()
        list.add("This is your First Screen")
        list.add("This is your Second Screen")
        list.add("This is your Third Screen")
        list.add("This is your Fourth Screen")

        val colorList: MutableList<String> = ArrayList()
        colorList.add("#00ff00")
        colorList.add("#ff0000")
        colorList.add("#0000ff")
        colorList.add("#f0f0f0")

        // Set adapter to viewPager.
        binding.viewPager2.adapter = ViewPager2Adapter(this, list, colorList)
    }
}
