package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent;
import android.os.Build
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.myapp.models.Credential
import com.example.myapp.models.NewUser
import com.example.myapp.utils.AppPreferences
import com.example.myapp.utils.DataHolder
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var preferences: AppPreferences
    private val gson = Gson()
    private lateinit var credential: Credential

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferences = AppPreferences(this)

        val strCredentials = preferences.getData("credentials")
        if(!strCredentials.contentEquals("0")){
            credential = gson.fromJson(strCredentials, Credential::class.java)
            navigateToHome(credential.email, credential.password)
        }

        val errorV = findViewById<TextView>(R.id.txError)
        val error = savedInstanceState?.getString("error") ?: "no"
        if(error != "no"){
            showError(error, errorV)
        }

        findViewById<Button>(R.id.login_btn).setOnClickListener {
            onLoginClicked(it)
        }

        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToHome(emailAddress:String,password:String){
        val user = NewUser(password =  password, email = emailAddress)
        val intent = Intent(this,HomeActivity::class.java)
        //intent.putExtra("email",emailAddress)
        //intent.putExtra("password",password)
        //intent.putExtra("user",user)
        DataHolder.user = user
        startActivity(intent)
        finish()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val errorV = findViewById<TextView>(R.id.txError)
        if(errorV.visibility == View.VISIBLE)
            outState.putString("error",errorV.text.toString())
    }


    private fun onLoginClicked(view: View){
        val email = findViewById<EditText>(R.id.email_field).text.trim().toString()
        val password = findViewById<EditText>(R.id.pass_field).text.trim().toString()
        val error = findViewById<TextView>(R.id.txError)

        if (email.isEmpty()) {
            showError("Please fill your email!", error)
        }else if(password.isEmpty()){
            showError("Please fill you password!", error)
        } else{
            //hideError(error)
            //val user = User(email = email, password = password)
            //intent.putExtra("user", user)
//                intent.putExtra("email", email)
//                intent.putExtra("password", password)
//            val intent = Intent(this, HomeActivity::class.java)
//            val newUser = NewUser(email = email, password = password)
//            DataHolder.user = newUser
//            startActivity(intent)
            credential = Credential(email, password)
            val strCredentials = gson.toJson(credential)
            val chb = findViewById<CheckBox>(R.id.ckbox1)
            if(chb.isChecked)
                preferences.setData("credentials",strCredentials)
            navigateToHome(email,password)

        }
    }

    private fun showMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String, error: TextView) {
        error.visibility = View.VISIBLE
        error.text = message
    }


    private fun hideError(error: TextView){
        error.visibility = View.GONE
    }

}
//        findViewById<Button>(R.id.btn2).setOnClickListener{
//            showMsg("on Button 2 Sarim")
//        }

//        findViewById<Button>(R.id.btn3).setOnClickListener{
//            showMsg("on Button 3 Moosa")
//        }
//
//        findViewById<Button>(R.id.btn4).setOnClickListener{
//            showMsg("on Button 4 Najeeb")
//        }
//
//        findViewById<Button>(R.id.btn2).setOnClickListener{
//            showMsg("on Button 2 Clicked")
//        }





//    fun onButton1Clicked(view: View) {
//        showMsg("on Button 1 Clicked")
//    }

//    fun onButton2Clicked(view: View) {
//        showMsg("on Button 2 Clicked")
//    }
//
//

//
//    fun onClick(view: View?) {
//        if(view?.id == R.id.btn1){
//            showMsg("on Button 1 Clicked")
//        }
//        else if(view?.id == R.id.btn2){
//            showMsg("on Button 2 Clicked")
//        }
//
//        when(view?.id){
//            R.id.btn1 -> {
//                showMsg("on Button 1 Clicked")
//            }
//            R.id.btn2 -> {
//                showMsg("on Button 2 Clicked")
//            }
//        }
//    }
