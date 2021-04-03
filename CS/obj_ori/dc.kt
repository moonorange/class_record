import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Graphics2D
import java.util.Calendar
import javax.swing.JComponent
import javax.swing.JFrame

fun main(args:Array<String>){
A_DClock("デジタル時計")
}

class A_DClock(title:String?):JFrame(title) {
internal var aClock:A_DClockView? = null
init{
val winWidth = 384
val winHeight = 128




getContentPane()!!.setLayout(null)
setVisible(true)
aClock = A_DClockView(winWidth, winHeight)
aClock!!.setLocation(0, 0)
getContentPane()!!.add(aClock)
repaint()
}
}


internal class A_DClockView(w:Int, h:Int):JComponent(), Runnable {
var thread:Thread? = null
var ihour:Int = 0
var imin:Int = 0
var isec:Int = 0
var myfont:Font? = null
init{
setSize(w, h)


setHMS()
thread = Thread(this)
thread!!.start()
repaint()
}
fun setHMS() { // 時刻の取得



}
public override fun paintComponent(g:Graphics?) {
val g2 = g as Graphics2D?
g2!!.setColor(Color.white)
g2.fillRect(0, 0, getWidth(), getHeight())


g2.setFont(myfont)
val now = Calendar.getInstance()
var ihour:Int = 19
var imin:Int = 24
var isec:Int = 34
val clock = String.format("%02d:%02d:%02d", ihour, imin, isec)
g2.drawString(clock, 56, 72)
}
public override fun run() {
Thread.currentThread()!!.setPriority(Thread.NORM_PRIORITY - 3)
while (thread != null)
{
try
{


repaint()
Thread.sleep(20)
}
catch (e:InterruptedException) {}
}
thread = null
}

}