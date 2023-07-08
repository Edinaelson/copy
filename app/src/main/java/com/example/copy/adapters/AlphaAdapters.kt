package com.example.copy.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.copy.Copys
import com.example.copy.MainActivity2
import com.example.copy.R
import com.example.copy.model.AlphaChar

class AlphaAdapters(
    private val context: Context,
    private val arrayList: ArrayList<AlphaChar>
) : RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_layout_grid_view, parent, false)
        return ItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val alphaChar: AlphaChar = arrayList[position]

        holder.icons.setImageResource(alphaChar.iconsChar!!)
        holder.alphas.text = alphaChar.alphaChar

        holder.itemView.setOnClickListener {
            Toast.makeText(context, alphaChar.alphaChar, Toast.LENGTH_SHORT).show()
            when (position) {
                1 -> {
                    val intent = Intent(context, Copys::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
                // Adicione mais casos aqui, se necessário
            }
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icons: ImageView = itemView.findViewById(R.id.icons_image)
        val alphas: TextView = itemView.findViewById(R.id.alpha_text_view)
    }
}
