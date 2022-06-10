package com.example.proiectfmi.ui.camera

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.proiectfmi.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {

    private val cameraRequest = 1888
    private lateinit var cameraViewModel: CameraViewModel
    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var ivCamera: ImageView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        cameraViewModel =
                ViewModelProvider(this).get(CameraViewModel::class.java)

        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCamera
        this.ivCamera = binding.ivCamera

        cameraViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        binding.btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequest) {
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            ivCamera.setImageBitmap(photo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}