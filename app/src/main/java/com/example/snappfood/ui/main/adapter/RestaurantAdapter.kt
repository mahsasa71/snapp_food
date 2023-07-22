package com.example.snappfood.ui.main.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.snappfood.R
import com.example.snappfood.models.Resturant
import com.example.snappfood.ui.restaurantDetails.ResturantActivity
import ir.android.filimo.customview.FarsiTextview

class RestaurantAdapter(mcontext:Context, data:List<Resturant>):RecyclerView.Adapter<RestaurantAdapter.CategoryVH>() {
    val context=mcontext
    var categorylist=data
    class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title=itemView.findViewById<FarsiTextview>(R.id.txt_title)
        var img_category=itemView.findViewById<AppCompatImageView>(R.id.img_category)
        var card_item=itemView.findViewById<CardView>(R.id.card_item)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        var view:View=LayoutInflater.from(context).inflate(R.layout.restaurant_row,null)
        return CategoryVH(view)

    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        var resturant=categorylist.get(position)
        holder.txt_title.setText(resturant.restaurantName)
        holder.img_category.load(resturant.restaurantImage)
        holder.card_item.setOnClickListener({
            val intent = Intent(context , ResturantActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("restaurant" , resturant);
            context.startActivity(intent)
        })



    }

    override fun getItemCount(): Int {
        return categorylist.size
    }
}