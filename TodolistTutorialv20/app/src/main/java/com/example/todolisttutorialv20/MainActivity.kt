package com.example.todolisttutorialv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toolbar

class MainActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the first page to the list view activity
        setContentView(R.layout.activity_main)
        toast("main activity created!")

        val realmRecyclerView = findViewById<RealmRecyclerView>(R.id.realmRecyclerView)


        val realmResult = realm.where<Todo>().findAll().sort("date", Sort.DESCENDING)
//

        val adapter = TodoListAdapter(this, realmResult, true)
        realmRecyclerView.setAdapter(adapter)
//        recyclerView.adapter = adapter
//
//        realmResult.addChangeListener { _ -> adapter.notifyDataSetChanged() }
////        recyclerView.setOnClickListener()
//        recycler

        fab.setOnClickListener {
            startActivity<EditActivity>()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
