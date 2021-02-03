package com.example.teste2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso

class CustomAdapter(context: Context, arrayListDetails:ArrayList<Fruits>) : BaseAdapter(){

    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Fruits>
    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }
    override fun getCount(): Int {
        return arrayListDetails.size
    }
    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder

        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.name.text = arrayListDetails.get(position).name
        listRowHolder.price.text = arrayListDetails.get(position).price.toString()
        Picasso.get().load(arrayListDetails[position].image).into(listRowHolder.image)

        return view
    }
}