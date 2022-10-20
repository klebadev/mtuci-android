package ru.vvkleba.myapplication.ui.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.vvkleba.myapplication.databinding.FragmentDiceBinding

class DiceFragment : Fragment() {


    private lateinit var _binding: FragmentDiceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiceBinding.inflate(inflater, container, false)
        return _binding.root
    }


    private fun initView() {
        val button = _binding.button
        val result = _binding.result
        button.setOnClickListener {
            val count = _binding.count.text.toString().toIntOrNull()

            if (count == null || count <= 0) {
                Toast.makeText(
                    context,
                    "Количество должно быть больше 0",
                    5
                )
                    .show()
                return@setOnClickListener
            }

            result.text = (1..count)
                    .map { kotlin.random.Random.nextInt(1, 7) }
                    .joinToString(" ")
        }
    }
}