package com.example.yourrecycler

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.yourrecycler.registerLogin.RegistrationPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val adapter = GroupAdapter<ViewHolder>()
        home_recyler_view.adapter = adapter


        adapter.add(AddRecycleItem());
        adapter.add(AddRecycleItem());
        adapter.add(AddRecycleItem());
        adapter.add(AddRecycleItem());

    }
}

class AddRecycleItem(): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.user_items_recycle
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {

    }

}

//class ChatFromItem(): Item<ViewHolder>() {
//
//    override fun bind(viewHolder: ViewHolder, position: Int) {
////            viewHolder.itemView.textView_from_row.text = text
////            Picasso.get().load(image).into(viewHolder.itemView.imageView_from_row)
//    }
//    override fun getLayout(): Int {
//        return R.layout.user_items_recycle
//    }
//
//}