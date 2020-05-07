package com.example.fragmenttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_headlines.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        toast("main activity")
        // check the activity is using adaptable version with our layout
        if (findViewById<View>(R.id.fragment_container) != null) {
//            if we were already being restored prev state, we'll do nothing.
            if (savedInstanceState != null) {
                return
            }

//            create a new Fragment as the first, in the activity layout.
            val firstFragment = HeadlinesFragment()


            // I can't understand below yet.
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.arguments = intent.extras


//            add the fragment(first fragment, in this case : HeadlinesFragment) to the 'fragment_container' : news_articles.xml

            supportFragmentManager.beginTransaction().add(R.id.fragment_container, firstFragment)
                .commit()

        }
    }
    //해서니는 환지니를 사랑해
    public fun test(s: String) {
        toast(s)
    }

}
