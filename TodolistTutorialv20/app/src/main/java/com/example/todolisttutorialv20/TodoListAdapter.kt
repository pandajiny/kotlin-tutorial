package com.example.todolisttutorialv20

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.*

class TodoListAdapter(
    context: Context,
    realmResults: RealmResults<Todo>,
    autoUpdate: Boolean
) :
    RealmBasedRecyclerViewAdapter<Todo, TodoListAdapter.ViewHolder>(
        context, realmResults
        , autoUpdate, false
    ) {

    class ViewHolder(itemView: View) : RealmViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.text1)
        val textTextView: TextView = itemView.findViewById(R.id.text2)
    }

    override fun onBindRealmViewHolder(p0: ViewHolder, p1: Int) {
//        val item = realmResults!![position]

        val item: Todo = realmResults[p1]!!
        p0.textTextView.text = item.title
        p0.dateTextView.text = DateFormat.format("yyyy/MM/dd", item.date)
    }

    override fun onCreateRealmViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view: View =
            LayoutInflater.from(p0?.context).inflate(R.layout.item_todo, p0, false)

        return ViewHolder(view)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//        val view: View =
//            LayoutInflater.from(parent?.context).inflate(R.layout.item_todo, parent, false)
//
//        return ViewHolder(view)
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = data!![position]
//        holder.textTextView.text = item.title
//        holder.dateTextView.text = DateFormat.format("yyyy/MM/dd", item.date)
//
//    }
//
//    override fun getItemId(position: Int): Long {
//        if (data != null) {
//            return data!![position].id
//        }
//        return super.getItemId(position)
//    }


//    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val dateTextView: TextView = view.findViewById<TextView>(R.id.text1)
//        val textTextView: TextView = view.findViewById<TextView>(R.id.text2)
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val vh: MyViewHolder
//        val view: View
//
//
//        if (convertView == null) {
//            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_todo, parent, false)
//            vh = MyViewHolder(view)
//            view.tag = vh
//        } else {
//            view = convertView
//            vh = view.tag as MyViewHolder
//        }
//
//        if (adapterData != null) {
//            val item = adapterData!![position]
//            vh.textTextView.text = item.title
//            vh.dateTextView.text = DateFormat.format("yyyy/MM/dd", item.date)
//        }
//
//        return view
//    }
//
//    override fun getItemId(position: Int): Long {
//        if (adapterData != null) {
//            return adapterData!![position].id
//        }
//        return super.getItemId(position)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        TODO("Not yet implemented")
//    }
}