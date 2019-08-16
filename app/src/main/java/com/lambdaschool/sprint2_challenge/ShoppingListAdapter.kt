package com.lambdaschool.sprint2_challenge

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.lambdaschool.sprint2_challenge.model.ItemsList
import com.lambdaschool.sprint2_challenge.model.Values
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

        val cardviewSwitch = Switch(holder.cardView.context)
        holder.cardView.setOnClickListener {
            Values.isChecked = !Values.isChecked
            cardviewSwitch.isChecked = Values.isChecked
        }
//        holder.cardView.setOnClickListener {
//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//                type = "text/plain"
//            }
//            startActivity(sendIntent)
//        }

        holder.itemName.text = data[position].item
        holder.iconView.setImageDrawable(ContextCompat.getDrawable(holder.iconView.context, data[position].icon))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.item_name
        val iconView: ImageView = view.icon_view
        val cardView: CardView = view.card_view
    }
}