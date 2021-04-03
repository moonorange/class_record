
//SprayDraw.kt
import java.awt.*
import java.awt.event.*
class SprayDraw internal constructor():Frame(), AdjustmentListener {
internal var cp:Point? = null
internal var radius = 100
internal var sb:Scrollbar? = null
init{
    setTitle("Spray")
setSize(640, 400)
sb = Scrollbar(Scrollbar.HORIZONTAL)
sb?.setMaximum(50)
add(sb, "South")
sb?.addAdjustmentListener(this)
addWindowListener(WinAdapter())
addMouseMotionListener(MouMotionAdapter())
addMouseListener(MouAdapter())
}
internal inner class MouMotionAdapter:MouseMotionAdapter() {
public override fun mouseDragged(me:MouseEvent?) {
cp = me!!.getPoint()
repaint()
}
}
internal inner class MouAdapter:MouseAdapter() {
public override fun mousePressed(me:MouseEvent?) {
cp = me!!.getPoint()
repaint()
}
}
internal inner class WinAdapter:WindowAdapter() {
public override fun windowClosing(we:WindowEvent?) {
System.exit(0)
}
}
public override fun paint(g:Graphics?) {
update(g)
}
public override fun update(g:Graphics?) {
if (cp != null)
{
var r:Double
var a:Double
var rx:Int
var ry:Int
for (i in 1..30)
{
r = Math.random() * radius
a = Math.random() * Math.PI * 2.0
rx = (r * Math.cos(a)).toInt()
ry = (r * Math.sin(a)).toInt()
g!!.drawLine(cp!!.x + rx, cp!!.y + ry, cp!!.x + rx, cp!!.y + ry)
}
}
}
public override fun adjustmentValueChanged(ae:AdjustmentEvent?) {
radius = ae!!.getValue()
repaint()
}
}
fun main(ar:Array<String>) {
val f = SprayDraw()
f.setVisible(true)
}


