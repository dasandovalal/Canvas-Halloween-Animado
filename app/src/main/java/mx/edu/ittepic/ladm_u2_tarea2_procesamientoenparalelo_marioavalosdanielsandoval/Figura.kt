package mx.edu.ittepic.ladm_u2_tarea2_procesamientoenparalelo_marioavalosdanielsandoval

import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint

class Figura(lienzo:Lienzo, imagen:Int, x:Float, y:Float) {
    val l = lienzo
    val img = BitmapFactory.decodeResource(l.resources,imagen)
    var x=x
    var y=y

    val p = Paint()

    fun pintar(c:Canvas){
        c.drawBitmap(img,x,y,p)
    }
}