package com.people.app.listview_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.people.app.R

class RecyclerViewAdapter(
    private val mList: List<RecyclerViewDataModel>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_description_activity, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.empName.text = item.Name

//        val user = mList[position]
//        holder.bind()
//        myHolder.bind(users.get(position),itemClickListener)
//
//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//
//                onClickListener!!.onClick(position, item)
//            }
//        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
//        this.onClickListener = onClickListener
    }


    interface OnClickListener {

        fun onClick(position: Int, model: RecyclerViewDataModel)
    }

    fun bind(user: RecyclerViewDataModel,clickListener: AdapterView.OnItemClickListener)
    {
//        name.text = user.username
//        phone.text = user.phone
//
//        itemView.setOnClickListener {
//            clickListener.onItemClicked(user)
//        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(items: View) : RecyclerView.ViewHolder(items) {
        var empName: TextView = itemView.findViewById(R.id.name)

    }
}