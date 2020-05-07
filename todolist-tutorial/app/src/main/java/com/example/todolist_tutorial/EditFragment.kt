package com.example.todolist_tutorial

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_edit.*
import layout.Todo
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        doneFab.setOnClickListener {
            insertTodo()
        }
    }


    // Create Calendar object as Today(default opt)
    private val calendar: Calendar = Calendar.getInstance()

    private fun insertTodo() {
//        realm.beginTransaction()
        val toast = Toast.makeText(context, "Hi", Toast.LENGTH_SHORT)
        toast.show()

    }

//    private fun insertTodo() {
//        realm.beginTransaction()
//
//        val newItem = realm.createObject()
//
//        newItem.title = todoEditText.text.toString()
//        newItem.date = calendar.timeInMillis
//
//        realm.commitTransaction()
//    }
//
//    private fun nextId(): Int {
//        val maxId = realm.where<Todo>().max("id")
//        if (maxId != null) {
//            return maxId.toInt() + 1
//        }
//        return 0
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_edit, container, false)
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
