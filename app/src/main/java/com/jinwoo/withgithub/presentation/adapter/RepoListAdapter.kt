package com.jinwoo.withgithub.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.entity.Repo
import com.jinwoo.withgithub.presentation.main.MainContract
import org.jetbrains.anko.find

class RepoListAdapter(val models: ArrayList<Repo>): RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_owner_repo, parent, false)
        return RepoListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) = holder.bind(models[position])

    inner class RepoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.find<TextView>(R.id.repo_name)
        val itemDescription = itemView.find<TextView>(R.id.repo_desc)
        val itemLanguage = itemView.find<TextView>(R.id.repo_language)
        val itemStargazersCount = itemView.find<TextView>(R.id.repo_star)
        fun bind(model: Repo) {
            with(model) {
                itemName.text = name
                itemDescription.text = description
                itemLanguage.text = language
                itemStargazersCount.text = stargazersCount.toString()
            }
        }
    }
}