package com.example.desafiomuxi

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LineHolder(row: View) : RecyclerView.ViewHolder(row), ItemClickSupportViewHolder{

    override val isClickable: Boolean get() = true
    override val isLongClickable: Boolean get() = false

    public  var name: TextView
    public  var image: ImageView
    public  var price: TextView
    public  var linearLayout: LinearLayout

    init {
        this.name = row.findViewById<TextView>(R.id.name) as TextView
        this.image = row.findViewById<ImageView>(R.id.foto) as ImageView
        this.price = row.findViewById<TextView>(R.id.price) as TextView
        this.linearLayout = row.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }

}