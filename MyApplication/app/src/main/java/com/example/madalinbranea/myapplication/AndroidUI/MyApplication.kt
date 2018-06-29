package com.example.madalinbranea.myapplication.AndroidUI

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log

import com.example.madalinbranea.myapplication.FileManagement.AssetsToInternal
import com.example.madalinbranea.myapplication.FileManagement.AssetsToInternal2

import java.security.AccessController.getContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AssetsToInternal2().copy(applicationContext)
      //  Log.e(TAG,"copied");
    }
}