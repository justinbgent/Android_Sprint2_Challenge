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

        val cardviewSwitch = Switch(holder.cardView.context)
        if (cardviewSwitch.isChecked){
            shoppingListStrings.add(holder.itemName.text.toString())
        }else{
            for (i in 0..shoppingListStrings.size-1)
                if (shoppingListStrings[i] == holder.itemName.text.toString()){
                shoppingListStrings.removeAt(i)
            }
        }

        holder.itemName.text = data[position].item
        holder.iconView.setImageDrawable(ContextCompat.getDrawable(holder.iconView.context, data[position].icon))
//        holder.cardView.setOnClickListener {
//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//                type = "text/plain"
//            }
//            startActivity(sendIntent)
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.item_name
        val iconView: ImageView = view.icon_view
        val cardView: CardView = view.card_view
    }
}