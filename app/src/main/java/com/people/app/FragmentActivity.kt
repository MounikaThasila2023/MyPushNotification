package com.people.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FragmentActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_fragment)

        /*First Fragment*/
        val fragmentBtn1: Button = findViewById(R.id.fragment1)
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = FragmentOne()
        fragmentBtn1.setOnClickListener {
            mFragmentTransaction.add(R.id.frameLayout, mFragment).commit()
        }

        /*Second Fragment*/
        val fragmentBtn2: Button = findViewById(R.id.fragment2)
        val mFragment2 = FragmentTwo()
        fragmentBtn2.setOnClickListener {
            mFragmentTransaction.add(R.id.frameLayout, mFragment2).commit()
        }

        /*Third Fragment*/
        val fragmentBtn3: Button = findViewById(R.id.fragment3)
        val mFragment3 = FragmentThree()
        fragmentBtn3.setOnClickListener {
            mFragmentTransaction.add(R.id.frameLayout, mFragment3).commit()
        }

    }
}