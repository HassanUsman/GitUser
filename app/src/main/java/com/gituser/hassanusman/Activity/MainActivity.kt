package com.gituser.hassanusman.Activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gituser.hassanusman.BR
import com.gituser.hassanusman.Provider.GithubSearchProvider
import com.gituser.hassanusman.R
import com.gituser.hassanusman.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        btnSearch.setOnClickListener {
            val repository = GithubSearchProvider.provideGithubSearch()
            /*compositeDisposable.add(
                    repository.searchUsers("Lagos", "Java")
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                Log.d("Result", "There are ${result.items.size} Java developers in Lagos ${result.items}")
                            }, { error ->
                                error.printStackTrace()
                            }))
*/
            if(etSearch.text.isNotEmpty()){
                compositeDisposable.add(
                        repository.searchUser(etSearch.text.toString())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe({ result ->
                                    Log.d("Result", "There are ${result}")
                                    binding.setVariable(BR.userInfo, result)
                                    binding.executePendingBindings()
                                    //Glide.with(this).load(result.avatar_url)

                                }, { error ->
                                    error.printStackTrace()
                                }))
            }else
                etSearch.error = "Username is required"

        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
