package com.example.baseadapterapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BaseAdapterClass(var list : ArrayList<Student>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 1L

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_base_adapter, parent, false)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.setText(list[position].name)
        val tvSubject = view.findViewById<TextView>(R.id.tvSubject)
        tvSubject.setText(list[position].subject)
        val tvRollNo = view.findViewById<TextView>(R.id.tvRollNo)
        tvRollNo.setText(list[position].rollNo.toString())
        return view

        return view
    }
}