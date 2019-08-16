package com.lambdaschool.sprint2_challenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sprint2_challenge.R
import com.lambdaschool.sprint2_challenge.ShoppingListAdapter
import com.lambdaschool.sprint2_challenge.model.ItemsList
import com.lambdaschool.sprint2_challenge.model.ShoppingItemConstants.ICON_IDS
import com.lambdaschool.sprint2_challenge.model.ShoppingItemConstants.ITEM_NAMES_RAW
import com.lambdaschool.sprint2_challenge.model.Values.Companion.myShoppingList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..ICON_IDS.size){
            myShoppingList.add(ItemsList(ICON_IDS[i], ITEM_NAMES_RAW[i]))
        }

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ShoppingListAdapter(myShoppingList)
        list_view.layoutManager = manager
        list_view.adapter = adapter


    }
}
