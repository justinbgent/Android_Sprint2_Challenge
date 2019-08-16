package com.example.android_sprint2_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sprint2_challenge.model.ItemsList
import com.example.android_sprint2_challenge.model.Values.Companion.myShoppingList
import com.example.android_sprint2_challenge.model.Values.Companion.shoppingListStrings
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

        val cardviewSwitch = Switch(holder.cardView.context)
        cardviewSwitch.isChecked = false

        holder.cardView.setOnClickListener {
            cardviewSwitch.isChecked = !cardviewSwitch.isChecked
            if (cardviewSwitch.isChecked){
                shoppingListStrings.add(data[position].item)
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context, R.color.colorPrimary))
                ShoppingListAdapter(myShoppingList).notifyDataSetChanged()
            }else{
                for (i in 0 until shoppingListStrings.size)
                    if (shoppingListStrings[i] == data[position].item){
                        shoppingListStrings.removeAt(i)
                    }
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