package ru.vvkleba.myapplication.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private var list = mutableListOf<String>()
    val _list = MutableLiveData<MutableList<String>>()

    fun addItem(item: String) {
        list.add(item)
        _list.value = list
    }

    fun deleteItem(index: Int) {
        list.removeAt(index)
        _list.value = list
    }

    fun isEmpty(): Boolean = list.isEmpty()

    fun pickRandom(): String = list.random()
}