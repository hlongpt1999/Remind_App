package com.example.remind_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.remind_app.Objects._Note
import com.example.remind_app.R

class Adapter_Note_Kotlin(val context : Context,val listNote : List<_Note>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private lateinit var context: Context
//    private lateinit var listNote: List<_Note>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater : LayoutInflater = LayoutInflater.from(parent.context)
        var note_view : View = inflater.inflate(R.layout.item_note, parent, false)
        var viewHolder : ViewHolder = ViewHolder(note_view)
        return viewHolder
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView
        val txtItemContent:TextView
        val txtItemDetail : TextView
        init{
            imgItem = itemView.findViewById(R.id.imgItem)
            txtItemContent = itemView.findViewById(R.id.txtItemContent)
            txtItemDetail = itemView.findViewById(R.id.txtItemDetail)
        }

    }

    override fun getItemCount() = listNote.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var note : _Note = listNote.get(position)

////        (ViewHolder) holder.txtItemContent.text = note.content
//        holder.txtItemDetail.text = note.detail
    }

}