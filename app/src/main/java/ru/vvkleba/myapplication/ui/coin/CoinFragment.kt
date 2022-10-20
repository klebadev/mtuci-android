package ru.vvkleba.myapplication.ui.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vvkleba.myapplication.databinding.FragmentCoinBinding

class CoinFragment : Fragment() {


    private lateinit var _binding: FragmentCoinBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinBinding.inflate(inflater, container, false)
        return _binding.root
    }


    private fun initView() {
        val button = _binding.button
        val result = _binding.result
        button.setOnClickListener {
            result.text = if (kotlin.random.Random.nextBoolean()) "Орел" else "Решка"
        }
    }
}