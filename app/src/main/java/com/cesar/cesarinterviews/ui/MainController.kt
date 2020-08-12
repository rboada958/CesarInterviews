package com.cesar.cesarinterviews.ui

import android.util.Log
import androidx.appcompat.widget.SearchView
import com.airbnb.epoxy.EpoxyController
import com.cesar.cesarinterviews.main

class MainController(private var list: MutableList<ListResponse>?) : EpoxyController(),
    SearchView.OnQueryTextListener {

    /* 4. [Android] Search on a list:
    *  Write an application with one activity that shows a list of items and a search box.
    *  The user expects that the search returns a result even if word typed is partially
    *  permuted or it has one typo (like explained on previous problems), but not both.
    * */

    private var filteredList: List<ListResponse?>? = list
    private var searchWord: String? = null
    private val selectedItems = mutableListOf<ListResponse>()

    override fun buildModels() {
        Log.e("----->", "filteredList: $filteredList")
        filteredList?.forEach {
            main {
                id(it!!.id)
                item(it)
            }
        }
    }

    fun updateList(it: MutableList<ListResponse>?) {
        list = it
        filterPhotoList()
        requestModelBuild()
    }

    private fun filterPhotoList() {
        filteredList =
            if (selectedItems.isEmpty()) list?.filter { containsPair(it.id!!, it.text!!) }
            else {
                val builder = StringBuilder()
                selectedItems.forEach { builder.append(it.text!!) }
                val filterWord = builder.toString()
                list?.filter { filterWord.contains(it.id.toString(), ignoreCase = true)  || filterWord.contains(it.text!!, ignoreCase = true)
                            && containsPair(it.id!!, it.text)
                }
            }
    }

    private fun containsPair(id: String, username: String): Boolean {
        return if (searchWord.isNullOrEmpty()) true
        else id.contains(searchWord!!, ignoreCase = true) || username.contains(
            searchWord!!,
            ignoreCase = true
        )
    }

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean {
        searchWord = newText
        filterPhotoList()
        requestModelBuild()
        return true
    }
}