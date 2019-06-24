package com.jinwoo.withgithub.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.entity.Person
import com.jinwoo.withgithub.presentation.entity.Repo
import com.jinwoo.withgithub.presentation.main.MainContract
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

class FollowingListAdapter(val presenter: MainContract.Presenter, val models: ArrayList<Person>): RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_owner_follow, parent, false)
        return FollowingListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: FollowingListViewHolder, position: Int) = holder.bind(models[position])

    inner class FollowingListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.find<TextView>(R.id.follow_name)

        fun bind(model: Person) {
            with(model) {
                itemName.text = id
                itemView.onClick { getUserData(id) }
            }
        }

        private fun getUserData(id: String) {
            presenter.getProfile(id)
            presenter.getFollowingList(id)
            presenter.getFollowerList(id)
            presenter.getRepoList(id)
        }
    }
}