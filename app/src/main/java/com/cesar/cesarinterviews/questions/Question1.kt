package com.cesar.cesarinterviews.questions

import android.util.Log

object Question1 {

    /* 1. Replacing characters in place:
    * Given an array of characters, write a method to replace all the spaces with “&32”.
    *  You may assume that the array has sufficient slots at the end to hold the additional characters,
    *  and that you are given the “true” length of the array.
    *  (Please perform this operation in place with no other auxiliary structure).
    *  Example:
    *  Input: “User is not allowed “, 19
    *  Output: “User&32is&32not&32allowed”, 25
    */

    fun questionOne() {
        val word = "Romel Jose Boada Blanco      ".toCharArray()
        Log.e("----->", "Question One")
        Log.e("----->", replaceWhiteSpace(word))
        Log.e("----->", "Size: ${word.size}")
    }

    private fun replaceWhiteSpace(word: CharArray): String {
        while (word.contains(' ')) {
            val space = word.indexOf(' ')
            val lastIndex = word.indexOfLast { v -> v != ' ' }

            for (i in lastIndex downTo space) {
                word[i + 2] = word[i]
            }
            word[space] = '&'
            word[space + 1] = '3'
            word[space + 2] = '2'
        }
        return String(word)
    }
}