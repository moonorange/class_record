// 1) AWTのフレームを作成・表示する　
//181024-Frametest.kt
import java.awt.*
class FrameTest : Frame(){
}

fun main(args:Array<String>) {
var f = FrameTest()
f.setSize(300, 400)
f.setVisible(true)
}