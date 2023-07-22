package com.example.snappfood.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.snappfood.R
import com.navin.snappfood.models.Category
import ir.android.filimo.customview.FarsiTextview

class CategoriAdapter(mcontext:Context,data:List<Category>):RecyclerView.Adapter<CategoriAdapter.CategoryVH>() {
    val context=mcontext
    var categorylist=data
    class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title=itemView.findViewById<FarsiTextview>(R.id.txt_title)
        var img_category=itemView.findViewById<AppCompatImageView>(R.id.img_category)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        var view:View=LayoutInflater.from(context).inflate(R.layout.category_row,null)
        return CategoryVH(view)

    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        var category=categorylist.get(position)
        holder.txt_title.setText(category.categoryName)
        holder.img_category.load(category.categoryImage)



    }

    override fun getItemCount(): Int {
        return categorylist.size
    }
}