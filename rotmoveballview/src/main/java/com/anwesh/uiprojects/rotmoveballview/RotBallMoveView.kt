package com.anwesh.uiprojects.rotmoveballview

/**
 * Created by anweshmishra on 19/10/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val nodes : Int = 5
val scGap : Float = 0.01f
val delay : Long = 30
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val backDeg : Float = 90f
val rFactor : Float = 3f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(Math.PI * this).toFloat()

fun Canvas.drawRotBallMove(size : Float, w : Float, sc : Float, paint : Paint) {
    val sc1 : Float = sc.divideScale(0, 2)
    val sc2 : Float = sc.divideScale(1, 2)
    val r : Float = size / rFactor
    val sf : Float = sc1.sinify()
    save()
    rotate(backDeg * sf)
    drawLine(0f, -size, 0f, size, paint)
    restore()
    drawCircle(r + w * sc2, -size, r, paint)
}

fun Canvas.drawRBMNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(size, gap * (i + 1))
    drawRotBallMove(size, w, scale, paint)
    restore()
}

class RotBallMoveView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}