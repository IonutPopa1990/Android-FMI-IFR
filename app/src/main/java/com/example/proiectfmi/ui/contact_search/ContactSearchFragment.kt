package com.example.proiectfmi.ui.contact_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.room.Room
import com.example.proiectfmi.databinding.FragmentContactSearchBinding
import com.example.proiectfmi.db.contacts.ContactData
import com.example.proiectfmi.db.contacts.ContactDataDao
import com.example.proiectfmi.db.contacts.ContactDataRoomDatabase

class ContactSearchFragment : Fragment() {

    private lateinit var contactSearchViewModel: ContactSearchViewModel
    private var _binding: FragmentContactSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactSearchViewModel =
                ViewModelProvider(this).get(ContactSearchViewModel::class.java)

        _binding = FragmentContactSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val roomDatabase : ContactDataRoomDatabase = Room.databaseBuilder(
            this.requireContext(),
            ContactDataRoomDatabase::class.java,
            "contact_database.db"
        ).build()
        val dao : ContactDataDao = roomDatabase.contactDataDao()

        dao.getAll().observe(
            this,
            Observer<List<ContactData>> { t ->

                var contactList = arrayListOf<ContactData> ( )
                for (contact in t) {
                    contactList.add(contact)
                }

                var contactListCopy = arrayListOf<ContactData> ()
                for (contact in contactList){
                    contactListCopy.add(contact)
                }

                val recyclerAdapter = ContactsRecyclerAdapter(contactList, contactListCopy )
                binding.recyclerView.adapter = recyclerAdapter
                binding.recyclerView.apply{
                    adapter = recyclerAdapter
                    addItemDecoration(DividerItemDecoration( this.context, DividerItemDecoration.VERTICAL))
                    setHasFixedSize(true)
                }

                binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                    override fun onQueryTextSubmit(query: String): Boolean {
                        recyclerAdapter.filter(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        recyclerAdapter.filter(newText)
                        return true
                    }

                })

            }
        )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}