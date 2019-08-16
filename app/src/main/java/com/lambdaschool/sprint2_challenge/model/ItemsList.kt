package com.lambdaschool.sprint2_challenge.model

import android.graphics.drawable.Drawable

class ItemsList(icon: Drawable, item: String) {
    val icon = icon
    val item = item
}

class Values {
    companion object {
        var myShoppingList = mutableListOf<ItemsList>()
    }
}