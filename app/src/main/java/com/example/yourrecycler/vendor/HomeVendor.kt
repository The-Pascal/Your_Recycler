package com.example.yourrecycler.vendor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yourrecycler.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        add_item_button.setOnClickListener {
            val intent = Intent(this, SelectUser::class.java)
            startActivity(intent)
        }

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