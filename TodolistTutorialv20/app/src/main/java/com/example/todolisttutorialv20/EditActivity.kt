package com.example.todolisttutorialv20

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import java.util.*

class EditActivity : AppCompatActivity() {

    private val realm = Realm.getDefaultInstance()

    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        toast("Calendar View Created!")


        val id = intent.getLongExtra("id", -1L)

        if (id == -1L) {
            insertMode()
        } else {
            updateMode(id)
        }


        val calendarView: CalendarView = findViewById(R.id.calendarView)
//        sync calendarView object with calendar instance
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendar.set(
                Calendar.YEAR, year
            )
            calendar.set(
                Calendar.MONTH, month
            )
            calendar.set(
                Calendar.DAY_OF_MONTH, dayOfMonth
            )
        }

    }

    //    initialize insertMode
    private fun insertMode() {
        // hide deleteFab
//        deleteFab.visibility = View.GONE

        // doneFab click => call insertTodo fx
        doneFab.setOnClickListener { insertTodo() }
    }

    //    update mode initialize
    private fun updateMode(id: Long) {
        val todo = realm.where<Todo>().equalTo("id", id).findFirst()!!
        todoEditText.setText(todo.title)
        calendarView.date = todo.date

        doneFab.setOnClickListener {
            updateTodo(id)
        }
        deleteFab.setOnClickListener {
            deleteTodo(id)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }


    private fun insertTodo() {
        realm.beginTransaction()

        val newItem = realm.createObject<Todo>(nextId())

        newItem.title = todoEditText.text.toString()
        newItem.date = calendar.timeInMillis

        realm.commitTransaction()

        alert("Todo is successfully added") { yesButton { finish() } }.show()
    }

    private fun nextId(): Int {
        val maxId = realm.where<Todo>().max("id")
        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }

    private fun updateTodo(id: Long) {
        realm.beginTransaction()

        val updateItem = realm.where<Todo>().equalTo("id", id).findFirst()!!

        updateItem.title = todoEditText.toString()
        updateItem.date = calendar.timeInMillis

        realm.commitTransaction()

        alert("Update has applied.") { yesButton { finish() } }.show()

    }

    private fun deleteTodo(id: Long) {
        realm.beginTransaction()
        val deleteItem = realm.where<Todo>().equalTo("id", id)!!.findFirst()!!

        deleteItem.deleteFromRealm()
        realm.commitTransaction()

        alert("Succesfully deleted!") { yesButton { finish() } }.show()
    }
}
