package com.cesar.cesarinterviews.ui

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cesar.cesarinterviews.R
import com.cesar.cesarinterviews.questions.Question1.questionOne
import com.cesar.cesarinterviews.questions.Question2.questionTwo
import com.cesar.cesarinterviews.questions.Question3.questionThree
import com.cesar.cesarinterviews.questions.Question5.questionFive
import com.cesar.cesarinterviews.questions.Question7.questionSeven
import com.cesar.cesarinterviews.utils.CesarToolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val toolbar: CesarToolbar by lazy {
        findViewById<CesarToolbar>(R.id.cesar_toolbar)
    }

    private val list: MutableList<ListResponse> = mutableListOf(
        ListResponse("0", "pale"),
        ListResponse("1", "ple"),
        ListResponse("2", "pales"),
        ListResponse("3", "pale"),
        ListResponse("4", "bale"),
        ListResponse("5", "bake")
    )

    private val controller: MainController by lazy { MainController(null) }

    var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionOne()
        questionTwo()
        questionThree()

        /*------- Question Four -------*/
        rv_main.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        rv_main.setControllerAndBuildModels(controller)
        searchView = toolbar.selectedMenuItem?.actionView as SearchView?
        setupObservers(controller)
        /*------- Question Four -------*/

        questionFive()
        questionSeven()

    }

    private fun setupObservers(controller: MainController) {
        controller.updateList(list)
    }

    override fun onResume() {
        super.onResume()
        searchView?.setOnQueryTextListener(controller)
    }
}