package com.anwesh.uiprojects.linkedrotmoveballview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.rotmoveballview.RotBallMoveView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RotBallMoveView.create(this)
    }
}
