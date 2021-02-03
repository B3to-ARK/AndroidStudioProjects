package com.example.teste2

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class  ListRowHolder(row: View?) {
    public var name: TextView
    public var image: ImageView
    public var price: TextView
    public var linearLayout: LinearLayout

    init {
        this.name = row?.findViewById<TextView>(R.id.name) as TextView
        this.image = row?.findViewById<ImageView>(R.id.foto)
        this.price = row?.findViewById<TextView>(R.id.price) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}

