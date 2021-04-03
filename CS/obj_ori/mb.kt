// MovingBall.kt
import java.awt.*
import java.awt.event.*

class Movingball :Frame(), Runnable {
internal var x = 150
internal var y = 140
internal var r = 15
internal var dx = 8
internal var dy = 5
internal var width = 320
internal var height = 200
internal var anim:Thread? = null
internal var mvb:Movingball? = null
internal var msw:Boolean = false
init{
setAnim()
}
internal fun setAnim() {
//if ((msw == true){
//if (anim == null)
//{
anim = Thread(this)
anim!!.start()
}
//}
//}
internal fun endAnim() {
// anim.stop();
 anim = null
}
/*  public void start() { anim = new Thread(this); anim.start(); }
 */
public override fun run() {
while (anim != null)
{
if ((x - r + dx < 0) || (x + r + dx > width))
dx = -dx
if ((y - r + dy < 0) || (y + r + dy > height))
dy = -dy
x += dx
y += dy
repaint()
try
{
Thread.sleep(75)
//anim!!.stop()
}
catch (e:InterruptedException) {}
}
}
public override fun paint(g:Graphics?) {
// g.setColor(Color.red);
 // g.fillRect(30, 30, 150, 150);
 g!!.fillOval(x - r, y - r, r * 2, r * 2)
}
}

fun main(arg:Array<String>){
val mvb = Movingball()
mvb.setSize(320, 200)
mvb.setBackground(Color.lightGray)
mvb.setForeground(Color.green)
mvb.setVisible(true)
}
