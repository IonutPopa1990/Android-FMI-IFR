package com.example.proiectfmi.ui.contact_add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.proiectfmi.databinding.FragmentContactAddBinding
import com.example.proiectfmi.db.contacts.ContactData
import com.example.proiectfmi.db.contacts.ContactDataDao
import com.example.proiectfmi.db.contacts.ContactDataRoomDatabase
import kotlinx.android.synthetic.main.fragment_contact_add.view.*


class ContactAddFragment : Fragment() {

    private lateinit var contactAddViewModel: ContactAddViewModel
    private var _binding: FragmentContactAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactAddViewModel =
                ViewModelProvider(this).get(ContactAddViewModel::class.java)

        _binding = FragmentContactAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textContactAdd
        contactAddViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val roomDatabase : ContactDataRoomDatabase = Room.databaseBuilder(
            this.requireContext(),
            ContactDataRoomDatabase::class.java,
            "contact_database.db"
        ).build()
        val dao : ContactDataDao = roomDatabase.contactDataDao()

        val btnAddContact: Button = root.btn_add_contact
        btnAddContact.setOnClickListener {

            //it requires from a thread
            Thread(
                Runnable {
                    try{
                        dao.insert(ContactData(root.editLastName.text.toString() , root.editFirstName.text.toString() ))
                        this.requireActivity().runOnUiThread(java.lang.Runnable {
                            Toast.makeText( activity, "Contactul "+root.editLastName.text.toString()+" a fost adaugat!", Toast.LENGTH_LONG).show()
                        })
                    }catch(e: Exception){
                        this.requireActivity().runOnUiThread(java.lang.Runnable {
                            Toast.makeText( activity, "Eroare salvand contactul de mai sus", Toast.LENGTH_LONG).show()
                        })
                    }
                }
            ).start()

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}