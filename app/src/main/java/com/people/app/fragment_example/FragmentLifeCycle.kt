package com.people.app.fragment_example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.people.app.activity_life_cycle.MainClassActivityLifeCycle
import com.people.app.databinding.FragmentLifeCycleBinding


class FragmentLifeCycle : Fragment() {
    lateinit var binding: FragmentLifeCycleBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("FragmentLifeCycle","-----------onAttach method")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("FragmentLifeCycle","-----------onCreate method")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("FragmentLifeCycle", "-----------onCreateView")
        binding = FragmentLifeCycleBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.fra2.setOnClickListener {
            activity?.let {
                val intent = Intent(it, MainClassActivityLifeCycle::class.java)
                it.startActivity(intent)
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("FragmentLifeCycle","-----------onViewCreated method")
    }

    override fun onStart() {
        super.onStart()
        Log.e("FragmentLifeCycle","-----------onStart method")
    }

    override fun onResume() {
        super.onResume()
        Log.e("FragmentLifeCycle","-----------onResume method")
    }

    override fun onPause() {
        super.onPause()
        Log.e("FragmentLifeCycle","-----------onPause method")
    }

    override fun onStop() {
        super.onStop()
        Log.e("FragmentLifeCycle","-----------onStop method")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("FragmentLifeCycle","-----------onDestroyView method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("FragmentLifeCycle","-----------onDestroy method")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("FragmentLifeCycle","-----------onDetach method")

    }

}