package com.example.android_sprint2_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sprint2_challenge.model.ItemsList
import com.example.android_sprint2_challenge.model.Values.Companion.myShoppingList
import kotlinx.android.synthetic.main.shopping_item_layout.view.*

class ShoppingListAdapter(private val data: MutableList<ItemsList>) : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = data[position].item
        holder.iconView.setImageDrawable(ContextCompat.getDrawable(holder.iconView.context, data[position].icon))
        holder.cardView.id = position

        if (data[position].share){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context, R.color.colorPrimary))
        }
        if (!data[position].share){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context, R.color.colorAccent))
        }

        holder.cardView.setOnClickListener {
            // the line following after is a cheese way of getting view color to immediately
            // look selected aka the only way I know
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context, R.color.colorPrimary))
            data[position].share = !myShoppingList[position].share
            ShoppingListAdapter(myShoppingList).notifyDataSetChanged()
            //and this below is also a cheese way of switching it back. aka the only way I know
            if (!data[position].share){
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context, R.color.colorAccent))
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.item_name
        val iconView: ImageView = view.icon_view
        var cardView: CardView = view.card_view
    }
}