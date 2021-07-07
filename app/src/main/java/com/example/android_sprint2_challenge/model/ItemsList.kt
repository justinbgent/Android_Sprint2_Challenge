package com.example.android_sprint2_challenge.model

class ItemsList(icon: Int, item: String, share: Boolean) {
    val icon = icon
    val item = item
    var share = share
}

class Values {
    companion object {
        var myShoppingList = mutableListOf<ItemsList>()
    }
}