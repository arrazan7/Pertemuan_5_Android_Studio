package com.example.pertemuan_5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.pertemuan_5_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object{
        const val EXTRA_LOGINNAME = "extra_loginname"
        const val EXTRA_LOGINEMAIL = "extra_loginemail"
        const val EXTRA_LOGINPHONE = "extra_loginphone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedUsername = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        val savedPassword = intent.getStringExtra(MainActivity.EXTRA_PASSWORD)
        val savedEmail = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        val savedPhone = intent.getStringExtra(MainActivity.EXTRA_PHONE)


        with(binding){
            btnToHomePage.setOnClickListener {
                val loginUser = loginUsername.text.toString()
                val loginPass = loginPassword.text.toString()

                val intentToThirdActivity =
                    Intent(this@SecondActivity, ThirdActivity::class.java)
                intentToThirdActivity.putExtra(EXTRA_LOGINNAME,loginUser)
                intentToThirdActivity.putExtra(EXTRA_LOGINEMAIL,savedEmail)
                intentToThirdActivity.putExtra(EXTRA_LOGINPHONE,savedPhone)

                if (loginUser == savedUsername && loginPass == savedPassword) {
                    startActivity(intentToThirdActivity)
                } else {
                    // Login salah, tampilkan pesan kesalahan
                    Toast.makeText(this@SecondActivity, "Login Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}