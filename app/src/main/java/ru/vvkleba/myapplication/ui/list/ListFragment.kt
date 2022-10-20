package ru.vvkleba.myapplication.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vvkleba.myapplication.R
import ru.vvkleba.myapplication.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var _binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return _binding.root
    }


    private fun initView() {
        val model = ViewModelProvider(this)[ListViewModel::class.java]
        model._list.observe(viewLifecycleOwner) { list ->
            _binding.recyclerView.layoutManager = LinearLayoutManager(context)
            _binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    _binding.recyclerView.context,
                    DividerItemDecoration.VERTICAL
                )
            )

            _binding.recyclerView.adapter = Adapter(list, model)
        }
        viewModel = model

        val button = _binding.button
        val result = _binding.result
        val addedButton = _binding.button2
        val editTextTextPersonName = _binding.editTextTextPersonName
        button.setOnClickListener {
            if (viewModel.isEmpty()) {
                Toast.makeText(
                    context,
                    "Список должен быть заполнен",
                    5
                )
                    .show()
                return@setOnClickListener
            }
            result.text = viewModel.pickRandom()
        }

        addedButton.setOnClickListener {
            val text = editTextTextPersonName.text
            if (text.isBlank()) {
                Toast.makeText(
                    context,
                    "Текст должен содержать хоть один символ",
                    5
                )
                    .show()
                return@setOnClickListener
            }

            viewModel.addItem(text.toString())
            text.clear()
        }
    }


    class Adapter(
        private val data: List<String>,
        private val viewModel: ListViewModel
    ) :
        RecyclerView.Adapter<ViewH>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewH {
            return ViewH(LayoutInflater.from(p0.context)
                .inflate(R.layout.list_el, p0, false))

        }

        override fun getItemCount(): Int {
            return data.size

        }

        override fun onBindViewHolder(p0: ViewH, p1: Int) {
            p0.bindItems(data[p1]) {
                viewModel.deleteItem(p1)
            }
        }
    }

    class ViewH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(string: String, remove: () -> Unit) {
            itemView.findViewById<TextView>(R.id.textView3)
                .text = string
            itemView.findViewById<ImageButton>(R.id.imageButton).setOnClickListener {
                remove.invoke()
            }
        }
    }
}