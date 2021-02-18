package com.example.desafiomuxi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class LineAdapter(private var listRecyclerItem: ArrayList<Fruits>) :
    RecyclerView.Adapter<LineHolder>() {

    private var TYPE = 1
    private lateinit var view : View

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): LineHolder {
        return when (i) {
            TYPE -> {
                val layoutView: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.viewholder, viewGroup, false)
                view = layoutView
                LineHolder(layoutView)
            }
            else -> {
                val layoutView: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.viewholder, viewGroup, false)
                view = layoutView
                LineHolder(layoutView)
            }
        }
    }

    override fun onBindViewHolder(holder: LineHolder, position: Int) {
        val itemViewHolder = holder
        val viewType = getItemViewType(position)
        when (viewType) {
            TYPE -> {
                itemViewHolder.name.setText(listRecyclerItem!![position].name)
                itemViewHolder.price.setText("Valor (dollar): ${listRecyclerItem!![position].price}")
                Glide.with(view).load(listRecyclerItem!![position].image)
                        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(itemViewHolder.image)
            }
            else -> {
                itemViewHolder.name.setText(listRecyclerItem!![position].name)
                itemViewHolder.price.setText("Valor (dollar): ${listRecyclerItem!![position].price}")
                Glide.with(view).load(listRecyclerItem!![position].image)
                        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(itemViewHolder.image)
            }
        }


    }


    override fun getItemCount(): Int {
        return listRecyclerItem.size;
    }

}