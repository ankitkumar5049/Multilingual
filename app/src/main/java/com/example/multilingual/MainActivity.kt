package com.example.multilingual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var hindi: Button? = null
    private var english: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<BlankFragment>(R.id.fragment_container_view)
            }
        }
    }

    private fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}