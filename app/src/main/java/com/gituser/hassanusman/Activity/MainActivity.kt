package com.gituser.hassanusman.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gituser.hassanusman.Provider.GithubSearchProvider
import com.gituser.hassanusman.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSearch.setOnClickListener {
            val repository = GithubSearchProvider.provideGithubSearch()
//            compositeDisposable.add(
//                    repository.searchUsers("Lagos", "Java")
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribeOn(Schedulers.io())
//                            .subscribe({ result ->
//                                Log.d("Result", "There are ${result.items.size} Java developers in Lagos ${result.items}")
//                            }, { error ->
//                                error.printStackTrace()
//                            }))

            compositeDisposable.add(
                    repository.searchUser("HassanUsman")
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result2 ->
                                Log.d("Result", "There are ${result2.item}")
                            }, { error ->
                                error.printStackTrace()
                            }))
        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
