package br.ufpe.cin.gossip

import android.widget.TextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class ChatFromItem(val text: String): Item<GroupieViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.chat_item_layout
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        var sended_message = viewHolder.itemView.findViewById<TextView>(R.id.text_view_from)
        sended_message.text = text
    }
}