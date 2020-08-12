package com.cesar.cesarinterviews.questions

import android.util.Log

object Question7 {

    /* 7. Linked List Intersection:
    *  If two requests on the queue have linked lists that intersect (like the example below),
    *  previous service could be improved to process only the difference between them.
    *  Write a method that receives two singly linked lists and return Write a method that receives
    *  two singly linked lists and return the intersecting node of the two lists (if exists).
    *  Note that the intersection is defined by reference, not value. (No need to change previous answer).
    */

    fun questionSeven() {
        val list: MutableList<String> = listOf("10", "20", "30", "40", "50", "60").toMutableList()
        val listTwo: MutableList<String> = listOf("25").toMutableList()

        listTwo.add(list[2])
        listTwo.add(list[3])
        listTwo.add(list[4])
        listTwo.add(list[5])

        Log.e("----->", "Question Seven")

        val intersection = getIntersectionList(list, listTwo)
        if (intersection!!.isBlank()) {
            Log.e("----->", "There is no intersection in the lists")
        } else {
            Log.e("----->", "The lists intersect at $intersection")
        }

    }

    private fun getIntersectionList(
        list: MutableList<String>,
        listTwo: MutableList<String>
    ): String? {

        for (element in list) {
            if (listTwo.contains(element)) {
                return element
            }
        }

        return null
    }
}