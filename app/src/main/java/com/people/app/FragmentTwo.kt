package com.people.app


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val v =  inflater.inflate(R.layout.fragment_two, container, false)

            val btn : Button = v.findViewById(R.id.fragment2)
            btn.setOnClickListener {
                activity?.let {
                    val intent = Intent(it,FragmentActivity::class.java)
                    it.startActivity(intent)
                }
            }

        return v
    }
}