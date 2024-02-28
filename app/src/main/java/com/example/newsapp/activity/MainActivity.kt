package com.example.newsapp.activity;

import Api_Interface
import RecyclerAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryan.recyclerview.models.NewsData
import com.aryan.recyclerview.util.Utils
import com.example.newsapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.newsapp.databinding.ActivityMainBinding

val BASE_URL = Utils.baseurl

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var apiInterface: Api_Interface
    private lateinit var response : NewsData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiInterface = RetrofitHelper.getInstance().create(Api_Interface::class.java)
        getNews()
    }

    private fun setUpRecyclerView(){
        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerview.adapter = RecyclerAdapter(response)
    }

    private fun getNews() {
        lifecycleScope.launch(Dispatchers.IO){
            try{
                response = apiInterface.getData()
                // Updating  the UI after fetching data
                withContext(Dispatchers.Main){
                    setUpRecyclerView()
                }
            } catch (e: Exception){
                Log.e("MainActivity", e.toString())
            }
        }
    }
}
