package com.example.snappfood.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.snappfood.R
import com.example.snappfood.ui.fooddetail.FoodActivity
import com.example.snappfood.models.Food
import ir.android.filimo.customview.FarsiTextview


class FoodAdapter(mContext: Context , foods : List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodVh>() {

    val  context = mContext
    var foodsList =  foods



    class FoodVh(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtTitle = itemView.findViewById<FarsiTextview>(R.id.txt_title)
        val imgFood = itemView.findViewById<AppCompatImageView>(R.id.img_food)
        val rateFood = itemView.findViewById<AppCompatRatingBar>(R.id.rate_food)
        val cardFood = itemView.findViewById<CardView>(R.id.card_food)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVh {

        val view : View = LayoutInflater.from(context).inflate(R.layout.food_row , null)
        return FoodVh(view)

    }

    override fun onBindViewHolder(holder: FoodVh, position: Int) {

        var food : Food =  foodsList.get(position);


        holder.imgFood.load(food.book_thumbnail_b)
        holder.txtTitle.setText(food.book_title)
        holder.rateFood.rating = food.rate_avg.toFloat()

        holder.cardFood.setOnClickListener({
            val intent = Intent(context , FoodActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("food" , food);
            context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {

        return  foodsList.size
    }
}