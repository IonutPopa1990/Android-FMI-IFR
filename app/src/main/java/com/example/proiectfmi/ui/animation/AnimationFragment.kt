package com.example.proiectfmi.ui.animation

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proiectfmi.databinding.FragmentAnimationBinding
import kotlinx.android.synthetic.main.fragment_actions.view.*
import kotlinx.android.synthetic.main.fragment_animation.*
import kotlinx.android.synthetic.main.fragment_animation.view.*


class AnimationFragment : Fragment() {

    private lateinit var animationViewModel: AnimationViewModel
    private var _binding: FragmentAnimationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        animationViewModel =
                ViewModelProvider(this).get(AnimationViewModel::class.java)

        _binding = FragmentAnimationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var c = 0

        root.btn_object_animator.setOnClickListener{

            if (c % 2 == 0) {
                animate(root.redView,
                    android.view.View.TRANSLATION_Y,
                    redView.translationY,
                    redView.translationY + 100f,
                    500,
                    android.view.animation.DecelerateInterpolator()
                )

                animate(root.redView,
                    android.view.View.ALPHA,
                    1.0f,
                    0.0f,
                    500,
                    android.view.animation.LinearInterpolator()
                )

            } else {
                animate(root.redView,
                    View.ALPHA,
                    0.0f,
                    1.0f,
                    500,
                    LinearInterpolator () )

                animate(root.redView,
                    View.TRANSLATION_Y,
                    redView.translationY,
                    redView.translationY - 100f,
                    500,
                    DecelerateInterpolator() )

            }
            c++

        }

        return root
    }

    fun animate(target: View,
                property: Property<View, Float>,
                from: Float,
                to: Float,
                duration: Long,
                interpolator: TimeInterpolator
    )
    {

        val tY = ObjectAnimator.ofFloat(target, property, from, to)
        tY.duration = duration
        tY.interpolator = interpolator
        tY.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}