package com.jinwoo.withgithub.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.entity.Person
import com.jinwoo.withgithub.presentation.entity.Repo
import org.jetbrains.anko.find

class FollowerListAdapter(val models: ArrayList<Person>): RecyclerView.Adapter<FollowerListAdapter.FollowerListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_owner_follow, parent, false)
        return FollowerListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: FollowerListViewHolder, position: Int) = holder.bind(models[position])

    inner class FollowerListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.find<TextView>(R.id.follow_name)

        fun bind(model: Person) {
            with(model) {
                itemName.text = id
            }
        }
    }
}