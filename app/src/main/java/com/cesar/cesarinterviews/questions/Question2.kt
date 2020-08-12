package com.cesar.cesarinterviews.questions

import android.util.Log

object Question2 {

    /* 2. Check words with jumbled letters:
    *  Our brain can read texts even if letters are jumbled, like the following sentence:
    *  “Yuo cna porbalby raed tihs esaliy desptie teh msispeillgns.”
    *  Given two strings, write a method to decide if one is a partial-permutation of the other.
    *  Consider a partial-permutation only if:
    *  The first letter hasn’t changed place
    *  If word has more than 3 letters, up to 2/3 of the letters have changed place
    *  Examples:
    *  you, yuo -> true
    *  probably, porbalby -> true
    *  despite, desptie -> true
    *  moon, nmoo -> false
    *  misspellings, mpeissngslli -> false
    */

    fun questionTwo() {
        Log.e("----->", "Question Two")
        Log.e("----->", "${partialPermutation("you", "yuo")}")
        Log.e("----->", "${partialPermutation("probably", "porbalby")}")
        Log.e("----->", "${partialPermutation("despite", "desptie")}")
        Log.e("----->", "${partialPermutation("moon", "nmoo")}")
        Log.e("----->", "${partialPermutation("misspellings", "mpeissngslli")}")
    }

    private fun partialPermutation(firstWord: String, secondWord: String): Boolean {

        if (firstWord.length == secondWord.length) {
            if (firstWord[0] == secondWord[0]) {

                var countLetters = 0

                secondWord.forEachIndexed { index, c ->
                    val indexFirst = firstWord.indexOf(c)

                    if (indexFirst == -1) {
                        return false
                    }
                    if (index != indexFirst) {
                        countLetters++
                    }
                }

                if (firstWord.length > 3) {
                    if (countLetters < (firstWord.length * (2f / 3f))) {
                        return true
                    }
                } else {
                    return countLetters > 0
                }
            }
        }

        return false
    }
}