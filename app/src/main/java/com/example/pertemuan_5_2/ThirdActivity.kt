package com.example.pertemuan_5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuan_5_2.databinding.ActivitySecondBinding
import com.example.pertemuan_5_2.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hasilUsername = intent.getStringExtra(SecondActivity.EXTRA_LOGINNAME)
        val hasilEmail = intent.getStringExtra(SecondActivity.EXTRA_LOGINEMAIL)
        val hasilPhone = intent.getStringExtra(SecondActivity.EXTRA_LOGINPHONE)

        with(binding){
            descUsername.text = hasilUsername
            descEmail.text = hasilEmail
            descPhone.text = hasilPhone
        }
    }
}