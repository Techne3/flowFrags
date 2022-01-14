package com.example.flowfrags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting initial fragment to FragmentContainerView when
        // activity is created

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, FormFragment() )
                .commit()
        }
    }
}