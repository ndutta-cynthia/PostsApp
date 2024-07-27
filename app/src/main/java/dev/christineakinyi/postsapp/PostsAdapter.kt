package dev.christineakinyi.postsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.christineakinyi.postsapp.databinding.ActivityMainBinding
import dev.christineakinyi.postsapp.databinding.PostsListItemBinding

class PostsAdapter(var postsList: List<Posts>, val context: Context): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = postsList[position]
        holder.binding.apply {
            tvBody.text = post.body
            tvTitle.text = post.title
            clPost.setOnClickListener{
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID", post.id)
                context.startActivity(intent)
            }
        }
    }
}

class PostsViewHolder(val binding: PostsListItemBinding) :
RecyclerView.ViewHolder(binding.root){

}