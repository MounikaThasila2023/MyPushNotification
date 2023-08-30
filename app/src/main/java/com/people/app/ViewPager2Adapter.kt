package com.people.app

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.people.app.databinding.Viewpager2WithImageBinding

class ViewPager2Adapter(private val context: Context,
                        private val labelList: MutableList<String>,
                        private val colorList: MutableList<String>
) : RecyclerView.Adapter<ViewPager2Adapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val binding = Viewpager2WithImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val label = labelList[position]
        val color = colorList[position]
        holder.bind(label, color)
    }

    override fun getItemCount(): Int {
        return labelList.size
    }

    class ViewPagerHolder(private var itemHolderBinding: Viewpager2WithImageBinding) :
        RecyclerView.ViewHolder(itemHolderBinding.root) {
        fun bind(label: String, color: String) {
            itemHolderBinding.label.text = label
            itemHolderBinding.root.setBackgroundColor(Color.parseColor(color))
        }
    }

}