package com.example.fragmenttutorial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.jetbrains.anko.toast

class ArticlesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }


    fun test() {
        toast("it's just test")
    }

}
