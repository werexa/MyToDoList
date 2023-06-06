package com.example.mytodolist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mytodolist.data.IMPORTANCE
import com.example.mytodolist.data.TaskItem
import com.example.mytodolist.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [TaskItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MytaskRecyclerViewAdapter(
    private val values: List<TaskItem>,
    private val eventListener: ToDoListListener
) : RecyclerView.Adapter<MytaskRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val resource = when(item.importance){
            IMPORTANCE.LOW -> R.drawable.circle_drawable_green
            IMPORTANCE.NORMAL -> R.drawable.circle_drawable_orange
            IMPORTANCE.HIGH -> R.drawable.circle_drawable_red
        }
        holder.imgView.setImageResource(resource)
        holder.contentView.text = item.title

        holder.itemContainer.setOnClickListener {
            eventListener.onItemClick(position)
        }
        holder.itemContainer.setOnLongClickListener() {
            eventListener.onItemLongClick(position)
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgView: ImageView = binding.itemImg
        val contentView: TextView = binding.content
        val itemContainer: LinearLayout = binding.root

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}