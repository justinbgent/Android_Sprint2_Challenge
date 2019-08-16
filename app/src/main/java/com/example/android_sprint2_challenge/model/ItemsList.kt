package com.example.android_sprint2_challenge.model

class ItemsList(icon: Int, item: String) {
    val icon = icon
    val item = item
}

class Values {
    companion object {
        var myShoppingList = mutableListOf<ItemsList>()
        var shoppingListStrings = mutableListOf<String>()
    }
}