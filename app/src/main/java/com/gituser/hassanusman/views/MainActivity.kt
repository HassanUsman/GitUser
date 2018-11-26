package com.gituser.hassanusman.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gituser.hassanusman.BR
import com.gituser.hassanusman.R
import com.gituser.hassanusman.databinding.ActivityMainBinding
import com.gituser.hassanusman.providers.model.UserObserver
import com.gituser.hassanusman.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        val userData = UserObserver()
        userData.name = "Hassan"
        userData.avatar_url = "https://media.giphy.com/media/zv8PVZLXBj81a/giphy.gif"
        userData.followers = "100k"
        val userViewModel = UserViewModel(userData)

        binding.setVariable(BR.userData, userViewModel)

        /*btnSearch.setOnClickListener {
            val repository = GithubSearchProvider.provideGithubSearch()
            *//*compositeDisposable.add(
                    repository.searchUsers("Lagos", "Java")
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                Log.d("Result", "There are ${result.items.size} Java developers in Lagos ${result.items}")
                            }, { error ->
                                error.printStackTrace()
                            }))
*//*
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
*/
    }

    override fun onDestroy() {
        //compositeDisposable.clear()
        super.onDestroy()
    }
}




