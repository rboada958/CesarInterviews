package com.cesar.cesarinterviews.questions

import android.util.Log

object Question3 {

    /* 3. Check words with typos:
    *  There are three types of typos that can be performed on strings: insert a character, remove a character, or replace a character.
    *  Given two strings, write a function to check if they are one typo (or zero typos) away.
    *  Examples:
    *  pale, ple -> true
    *  pales, pale -> true
    *  pale, bale -> true
    * pale, bake -> false
    */

    fun questionThree() {
        Log.e("----->", "Question Three")
        Log.e("----->", "${hasOneTypos("pale", "ple")}")
        Log.e("----->", "${hasOneTypos("pales", "pale")}")
        Log.e("----->", "${hasOneTypos("pale", "bale")}")
        Log.e("----->", "${hasOneTypos("pale", "bake")}")
    }

    private fun hasOneTypos(first: String, second: String): Boolean {

        if (first == second) return false

        var diffCount = 0
        var secondAux = second
        var firstAux = first
        when {
            first.length == second.length -> {
                first.forEachIndexed { index, c ->
                    if (second[index] != c) {
                        diffCount++
                    }
                }
            }
            first.length > second.length -> {
                var diffLength = first.length - second.length
                while (diffLength > 0) {
                    secondAux += " "
                    diffLength--
                }
                first.forEachIndexed { index, c ->
                    if (c != secondAux[index]) {
                        secondAux = secondAux.substring(0, index) + c + secondAux.substring(
                            index,
                            secondAux.length - 1
                        )
                        diffCount++
                    }
                }
            }
            else -> {
                var diffLength = second.length - first.length
                while (diffLength > 0) {
                    firstAux += " "
                    diffLength--
                }
                second.forEachIndexed { index, c ->
                    if (c != firstAux[index]) {
                        firstAux = firstAux.substring(0, index) + c + firstAux.substring(
                            index,
                            firstAux.length - 1
                        )
                        diffCount++
                    }
                }
            }
        }
        return diffCount == 1
    }
}