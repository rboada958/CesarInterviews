package com.cesar.cesarinterviews.questions

import android.util.Log

object Question5 {

    /* 5. Remove duplicates on email thread:
    *  When different email clients are used on a same thread, the discussion get messy because old messages are included again and get duplicated.
    *  Given a email thread (represented by a singly unsorted linked list of messages),
    *  write a function that remove duplicated messages from it.
    */

    fun questionFive() {
        val list: MutableList<String> = listOf("one", "two", "one", "three", "four", "one").toMutableList()
        Log.e("----->", "Question Five")
        Log.e("----->", "$list")
        Log.e("----->", "${deleteDuplicates(list)}")
    }

    private fun deleteDuplicates(list: MutableList<String>): MutableList<String> {
        val newList: MutableList<String> = arrayListOf()

        for (element in list) {
            if (!newList.contains(element)) {
                newList.add(element)
            }
        }
        return newList
    }
}