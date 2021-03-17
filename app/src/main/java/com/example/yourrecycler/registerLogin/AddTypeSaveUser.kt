package com.example.yourrecycler.registerLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.yourrecycler.vendor.Home
import com.example.yourrecycler.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_type_save_user.*

class AddTypeSaveUser : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var type = "User"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_type_save_user)

        spinner()

        button_choose_category.setOnClickListener {
            saveUserToFirebaseDatabase()
        }

    }

    private fun spinner()
    {
        val spinner: Spinner = findViewById(R.id.action_bar_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }
    }

    private fun saveUserToFirebaseDatabase(){

        val user = intent.getParcelableExtra<Users>("USER")
        user?.type = type
        val ref = FirebaseDatabase.getInstance().getReference("/Users/${user?.uid}")
        ref.setValue(user)
            .addOnSuccessListener {

                val user = FirebaseAuth.getInstance().currentUser

                user!!.sendEmailVerification()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("RegistrationPage.TAG","Email sent")
                        }
                    }
                    Toast.makeText(this, "Account created successfully. Email sent to confirm.", Toast.LENGTH_SHORT).show()

                if(type=="Vendor")
                {
                    val intent = Intent(this, Home::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or ( Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this, Home::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or ( Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }

            }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        type = parent?.getItemAtPosition(position).toString()
    }

}
