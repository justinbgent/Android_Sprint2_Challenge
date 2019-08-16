package com.example.android_sprint2_challenge.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sprint2_challenge.R
import com.example.android_sprint2_challenge.ShoppingListAdapter
import com.example.android_sprint2_challenge.model.ItemsList
import com.example.android_sprint2_challenge.model.ShoppingItemConstants.ICON_IDS
import com.example.android_sprint2_challenge.model.ShoppingItemConstants.ITEM_NAMES_RAW
import com.example.android_sprint2_challenge.model.Values.Companion.myShoppingList
import com.example.android_sprint2_challenge.model.Values.Companion.shoppingListStrings
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..ICON_IDS.size-1){
            myShoppingList.add(ItemsList(ICON_IDS[i], ITEM_NAMES_RAW[i]))
        }

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ShoppingListAdapter(myShoppingList)
        list_view.layoutManager = manager
        list_view.adapter = adapter

        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelID = "Basic Notification"

        btn_send.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shoppingListStrings.toString())
                type = "text/plain"
            }
            startActivity(sendIntent)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val name = "Shopping List Channel"
                val notifChannel = NotificationChannel(channelID, name, NotificationManager.IMPORTANCE_HIGH)
                notifChannel.description = "Shared Notification"
                notifManager.createNotificationChannel(notifChannel)
            }

            val notifBuilder = NotificationCompat.Builder(this, channelID)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setContentTitle("List Shared")
                .setContentText(shoppingListStrings.toString())
                .setSmallIcon(R.drawable.ic_launcher_foreground_arrow)
                .setAutoCancel(true)
            notifManager.notify(1, notifBuilder.build())
        }
    }
}
