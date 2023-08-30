package com.people.app.listview_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.people.app.R

class RecycerViewMainLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycer_view_main_layout)




        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<RecyclerViewDataModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..10) {
            data.add(RecyclerViewDataModel("Mounika" + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = RecyclerViewAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}