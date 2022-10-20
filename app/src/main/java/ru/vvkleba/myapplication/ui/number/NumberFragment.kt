package ru.vvkleba.myapplication.ui.number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.vvkleba.myapplication.databinding.FragmentNumberBinding

class NumberFragment : Fragment() {

    private lateinit var _binding: FragmentNumberBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        return _binding.root
    }


    private fun initView() {
        val button = _binding.button
        val result = _binding.result
        button.setOnClickListener {
            val min = _binding.minEt.text.toString().toIntOrNull()
            val max = _binding.maxEt.text.toString().toIntOrNull()

            if(min == null || max == null || min >= max){
                Toast.makeText(context, "Минимальное значение должно быть меньше чем максимальное", 5)
                    .show()
                return@setOnClickListener
            }

            val randomValue = kotlin.random.Random.nextInt(min,max)
            result.text = randomValue.toString()
        }
    }
}