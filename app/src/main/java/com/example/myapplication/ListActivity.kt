package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), OnClickListener{

    private lateinit var mBinding: ActivityListBinding
    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //mBinding.btnSave.setOnClickListener(){
    //        val store = Store(name = mBinding..text.toString().trim())
      //      mAdapter.add(store)
        //}

        setupRecycleView()
    }

    private fun setupRecycleView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridLayoutManager = GridLayoutManager(this, 2)
        mBinding.recyclerView.apply{
            setHasFixedSize(true)
            layoutManager = mGridLayoutManager
            adapter = mAdapter
        }

    }

    override fun onclick(store: Store) {

    }
}