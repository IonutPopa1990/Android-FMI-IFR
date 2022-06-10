package com.example.proiectfmi.ui.contact_search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectfmi.R
import com.example.proiectfmi.db.contacts.ContactData
import com.google.android.material.snackbar.Snackbar


class ContactsRecyclerAdapter(var contactList: ArrayList<ContactData>, var contactListCopy: ArrayList<ContactData>) :

    RecyclerView.Adapter<ContactsRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int{
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val contact = contactList[position]
        holder.bind(contact)
    }

    fun filter(text: String) {
        var text = text
        contactList.clear()
        if (text.isEmpty()) {
            contactList.addAll(contactListCopy)
        } else {
            text = text.lowercase()
            for (item in contactListCopy) {
                if (item.firstName.lowercase().contains(text) || item.lastName.lowercase().contains(text)
                ) {
                    contactList.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



        fun bind(contact: ContactData) {
            val contactFirstNameTextView = itemView.findViewById(R.id.contactFirstNameTextView) as TextView
            val contactLastNameTextView = itemView.findViewById(R.id.contactLastNameTextView) as TextView

            contactFirstNameTextView.text = contact.firstName
            contactLastNameTextView.text = contact.lastName
        }

    }

}
