//-6---181018-Draw.kt
import java.awt.Color
import java.awt.Frame
import java.awt.Graphics
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

fun main(args:Array<String>) {
Draw()
}

class Draw:Frame() {
init{
this.setSize(10000, 10000)
this.setVisible(true)
this.addWindowListener(object:WindowAdapter() {
public override fun windowClosing(ev:WindowEvent?) {
System.exit(0)
}
})
}
public override fun paint(g:Graphics?){
// TODO 自動生成されたメソッド・スタブ
	g!!.setColor(Color.green)
    g.fillOval(50, 50, 100, 100)
    g.setColor(Color.blue)
    g.drawRect(200, 200, 100, 100)
}

}