package com.example.myapplication

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView


class  ListRowHolder(row: View?) {
    public val name: TextView
    public val image: TextView
    public val price: TextView
    public val linearLayout: LinearLayout

    init {
        this.name = row?.findViewById<TextView>(R.id.name) as TextView
        this.image = row?.findViewById<TextView>(R.id.image) as TextView
        this.price = row?.findViewById<TextView>(R.id.price) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}