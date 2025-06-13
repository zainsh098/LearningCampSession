package com.zain.learningcampsession.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zain.learningcampsession.databinding.ItemPostBinding
import com.zain.learningcampsession.data.model.PostModelDTO

// Created by Zain Shakoor
// on 6/13/2025

class PostAdapter : ListAdapter<PostModelDTO, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(post: PostModelDTO) {
            binding.titleText.text = post.title
            binding.bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<PostModelDTO>() {
    override fun areContentsTheSame(oldItem: PostModelDTO, newItem: PostModelDTO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: PostModelDTO, newItem: PostModelDTO): Boolean {
        return oldItem.id == newItem.id
    }
}

