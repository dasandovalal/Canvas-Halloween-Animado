package mx.edu.ittepic.ladm_u2_tarea2_procesamientoenparalelo_marioavalosdanielsandoval

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import android.view.View

class Lienzo(activity: MainActivity):View(activity) {

    val murcielago = Figura(this, R.drawable.muercielago, 50f, 600f)
    val fondo = Figura(this, R.drawable.fondo_hallo, 0f, 0f)
    val coco = Figura(this, R.drawable.groovy, 600f, 800f)
    val jack = Figura(this, R.drawable.jack, 475f, 950f)
    val murciegaLuna = Figura(this, R.drawable.murcielagoluna, 600f, 50f)
    val tumba = Figura(this, R.drawable.tumba1, 25f, 950f)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()

        fondo.pintar(c)
        tumba.pintar(c)
        jack.pintar(c)
        murcielago.pintar(c)
        murciegaLuna.pintar(c)
        coco.pintar(c)

    }

    init {
        val animarJack = HiloJackAnimado(this)
        animarJack.start()
        val murcielagote = HiloVampiroteVolador(this)
        murcielagote.start()
    }

}

class HiloJackAnimado(lienzo: Lienzo):Thread(){
    val l = lienzo
    override fun run() {
        super.run()
        animarAJack()
    }

    fun animarAJack(){
        var vanish = 1
        while (true){
            l.jack.p.alpha -= vanish
            if (l.jack.p.alpha<=0 || l.jack.p.alpha>=255) {
                vanish *=-1
                sleep(3000)
            }
            l.invalidate()
            sleep(50)
        }
    }
}

class HiloVampiroteVolador(lienzo: Lienzo):Thread(){
    val l = lienzo
    override fun run() {
        super.run()
        volarMurcielago()
    }

    fun volarMurcielago(){
        var dirX = 5
        var dirY = 5
        while (true){
            l.murciegaLuna.x -= dirX
            l.murciegaLuna.y += dirY
            if (l.murciegaLuna.x<-800 || l.murciegaLuna.x>1600){
                dirX *= -1
            }
            if (l.murciegaLuna.y<-1500 || l.murciegaLuna.y>3000){
                dirY *= -1
            }
            l.invalidate()
            sleep(15)
        }
    }
}