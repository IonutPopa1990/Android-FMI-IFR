package com.example.proiectfmi.ui.maps

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.proiectfmi.R
import com.example.proiectfmi.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private lateinit var mapsViewModel: MapsViewModel
    private var _binding: FragmentMapsBinding? = null

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap
    private val LOCATION_REQUEST_CODE = 101

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mapsViewModel =
                ViewModelProvider(this).get(MapsViewModel::class.java)

        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mapFragment = this.childFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback{ mapReadyCallback(it) } )

        val textView: TextView = binding.textMaps
        mapsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    private fun mapReadyCallback( it: GoogleMap ){
        googleMap = it

        var location1 = LatLng(44.426996, 26.100965)
        googleMap.addMarker(MarkerOptions().position(location1).title("Piata Unirii").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)))


        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 12f) )


        //adaugam sigla overlay
        val newarkSigla = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.logo))
            .anchor(0f, 1f)
            .position(LatLng(44.436809669707614, 26.102201216110473), 8600f, 8600f);

        val groudOverlay = googleMap.addGroundOverlay(newarkSigla)
        groudOverlay.tag = "Android icon"

        val permission = ContextCompat.checkSelfPermission( this.requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission == PackageManager.PERMISSION_GRANTED) {
            googleMap.isMyLocationEnabled = true
        } else {
            requestPermission(Manifest.permission.ACCESS_FINE_LOCATION,  LOCATION_REQUEST_CODE)
        }

    }

    private fun requestPermission(permissionType: String,
                                   requestCode: Int) {

        ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(permissionType), requestCode )
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                             permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            LOCATION_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] !=
                    PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this.context,
                        "Unable to show location - permission required",
                        Toast.LENGTH_LONG).show()
                } else {

                    val mapFragment = this.childFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
                    mapFragment.getMapAsync(OnMapReadyCallback{ mapReadyCallback(it) } )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}