package com.example.proiectfmi.ui.videoshow

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.proiectfmi.databinding.FragmentVideoshowBinding
import kotlinx.android.synthetic.main.fragment_videoshow.*
import kotlinx.android.synthetic.main.fragment_videoshow.view.*

class VideoshowFragment : Fragment() {

    private lateinit var videoshowViewModel: VideoshowViewModel
    private var _binding: FragmentVideoshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        videoshowViewModel =
                ViewModelProvider(this).get(VideoshowViewModel::class.java)

        _binding = FragmentVideoshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val mediaController = MediaController(this.requireContext() )
        mediaController.setAnchorView(root.videoView)

        val onlineUri = Uri.parse("https://dl8.webmfiles.org/big-buck-bunny_trailer.webm")

        root.videoView.setMediaController(mediaController)
        root.videoView.setVideoURI(onlineUri)
        root.videoView.requestFocus()
        root.videoView.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}