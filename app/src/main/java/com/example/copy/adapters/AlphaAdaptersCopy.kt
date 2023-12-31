package com.example.copy.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.copy.R
import androidx.recyclerview.widget.RecyclerView
import com.example.copy.model.Copy

class AlphaAdaptersCopy (
    var context: Context,
    var arrayList: ArrayList<Copy>)
    : RecyclerView.Adapter<AlphaAdaptersCopy.ItemHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.list_layout_copy_view, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val copy: Copy = arrayList.get(position)

        holder.textViewText.text = copy.textCopy
        holder.textViewCopys.text = copy.textCopyText

        holder.itemView.setOnClickListener{
//            Toast.makeText(context, copy.textCopyText, Toast.LENGTH_SHORT).show()
            val clipboard = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Label", copy.textCopyText)
            clipboard.setPrimaryClip(clip)

            //ToastCustomizado

            val layoutResId = R.layout.custom_toast // ID do layout customizado
            val textViewId = R.id.txt_message // ID do TextView dentro do layout
            val messages = copy.textCopyText

            if (messages != null) {
                showToastWithCustomLayout(holder.itemView.context, layoutResId, textViewId, messages)
            }
            //Toast.makeText(holder.itemView.context, "copiado: " + copy.textCopyText, Toast.LENGTH_SHORT).show()
        }

    }

    fun showToastWithCustomLayout(context: Context, layoutResId: Int, textViewId: Int, message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(layoutResId, null)
        val textView = view.findViewById<TextView>(textViewId)
        textView.text = message
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.show()
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var iconDelete = itemView.findViewById<ImageView>(R.id.icons_delete)
        var iconEdit = itemView.findViewById<ImageView>(R.id.icons_edit)
        var iconCopy = itemView.findViewById<ImageView>(R.id.icons_copy)
        var textViewText = itemView.findViewById<TextView>(R.id.text_view)
        var textViewCopys = itemView.findViewById<TextView>(R.id.text_view_copy)
    }

}