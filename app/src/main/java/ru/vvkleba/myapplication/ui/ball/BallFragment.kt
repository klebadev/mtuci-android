package ru.vvkleba.myapplication.ui.ball

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vvkleba.myapplication.databinding.FragmentBallBinding

class BallFragment : Fragment() {

    private lateinit var _binding: FragmentBallBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBallBinding.inflate(inflater, container, false)
        return _binding.root
    }


    private fun initView() {
        val button = _binding.button
        val result = _binding.result
        val list = listOf(
            // Положительные
            "Бесспорно",
            "Предрешено",
            "Никаких сомнений",
            "Определённо да",
            "Можешь быть уверен в этом",

            // Нерешительно положительные
            "Мне кажется — «да»",
            "Вероятнее всего",
            "Хорошие перспективы",
            "Знаки говорят — «да»",
            "Да",

            // Нейтральные
            "Пока не ясно, попробуй снова",
            "Спроси позже",
            "Лучше не рассказывать",
            "Сейчас нельзя предсказать",
            "Сконцентрируйся и спроси опять",

            // Отрицательные
            "Даже не думай",
            "Мой ответ — «нет»",
            "По моим данным — «нет»",
            "Перспективы не очень хорошие",
            "Весьма сомнительно"
        )
        button.setOnClickListener {
            result.text = list.random()
        }
    }
}