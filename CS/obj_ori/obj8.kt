1)AWTのボタンテストのアプリに無名内部クラス
//181025-ButtonTest.kt
import java.awt.*
import java.awt.event.*
internal class ButtonTestAnony : Frame(), ActionListener {
var b1:Button? = null
var b2:Button? = null
var b3:Button? = null
init{
setTitle("ButtonのGUI Application")
setSize(300, 200)
//addWindowListener(A_WindowAdapter())
addWindowListener(object: WindowAdapter(){
    public override fun windowClosing(e:WindowEvent?){
System.exit(0)
}
})
setLayout(FlowLayout())
b1 = Button("Button1")
b2 = Button("Button2")
b3 = Button("Button3")
b1?.addActionListener(this)
b2?.addActionListener(this)
b3?.addActionListener(this)
add(b1)
add(b2)
add(b3)
}
public override fun actionPerformed(ae:ActionEvent?) {
if (ae?.getSource() == b1)
println("Button1をクリックした ")
else if (ae?.getSource() == b2)
println("Button2をクリックした ")
else if (ae?.getSource() == b3)
println("Button3をクリックした ")
}
}
/* class A_WindowAdapter : WindowAdapter(){
    public override fun windowClosing(e:WindowEvent?){
System.exit(0)
}
}
*/

fun main(args:Array<String>) {
val f = ButtonTestAnony()
 f.setVisible(true)
}

2)AWTコンポーネントの例
//181027-AWTComponents.kt
import java.awt.*
import java.awt.event.*
class GraphicsC1 internal constructor():Frame() {
init{
setLayout(FlowLayout())
val b = Button("ボタン")
add(b)
val ca = FirstCanvas()
ca.setSize(Dimension(200, 100))
ca.setBackground(Color(91,202,255))
add(ca)
val che = Checkbox()
add(che)
val cho = Choice()
cho.add("選択1")
cho.add("選択2")
cho.add("選択3")
cho.add("選択4")
cho.add("選択5")
add(cho)
val la = Label("ラベル")
add(la)
val li = List()
li.add("リスト1")
li.add("リスト2")
li.add("リスト3")
li.add("リスト4")
li.add("リスト5")
add(li)
val sb = Scrollbar()
add(sb)
val ta = TextArea()
ta.setBackground(Color.white)
ta.append("テキスト領域")
add(ta)
val tf = TextField("テキスト行", 50)
tf.setBackground(Color.white)
add(tf)
val mb = MenuBar()
val m = Menu("GUI Menu")
m.add("Menu1")
m.add("Menu2")
m.add("Menu3")
mb.add(m)
setMenuBar(mb)
addWindowListener(WinAdapter())
}
internal inner class WinAdapter:WindowAdapter() {
public override fun windowClosing(we:WindowEvent?) {
System.exit(0)
}
}
internal inner class FirstCanvas:Canvas() {
public override fun paint(g:Graphics?) {
g!!.setColor(Color.yellow)
g.drawString("キャンバス", 0, 16)
g.fillOval(75, 25, 50, 50)
}
}
}
fun main(ar:Array<String>){
val f = GraphicsC1()
f.setTitle("GUIコンポーネント")
f.setSize(640, 400)
f.setBackground(Color(155,219,171))
f.setVisible(true)
}

3) Canvasの使用
//181026-ex9-1-Canvas.kt
import java.awt.*
import java.awt.event.*
class Ex9_1 :Canvas(){
    private var color:Color? = null
private var poly:Polygon? = null
	private val x = intArrayOf(320, 270, 370)
	private val y = intArrayOf(10, 60, 60)
private val x2 = intArrayOf(290, 310, 330, 350, 350, 330, 310, 290)
private val y2 = intArrayOf(90, 70, 70, 90, 110, 130, 130, 110)
private val x3 = intArrayOf(290, 310, 330, 350, 350, 330, 310, 290)
private val y3 = intArrayOf(160, 140, 140, 160, 180, 200, 200, 180)
//キャンバス上の描画で呼ばれるメソッド
	public override fun paint(g:Graphics?) {
		g!!.setColor(Color.red)
		g.drawLine(250, 10, 280, 310)
		g.setColor(Color.green)
		g.drawRect(10, 10, 100, 50)
		g.fillRect(10, 70, 100, 50)
		g.drawRoundRect(10, 130, 100, 50, 10, 20)
		g.draw3DRect(10, 190, 100, 50, true)
		g.fill3DRect(10, 250, 100, 50, false)
		g.setColor(Color.orange)
		g.drawOval(120, 210, 100, 50)
		g.fillArc(120, 270, 100, 50, 90, 180)
		color = Color(87,40,210)
		g.setColor(color)
		poly = Polygon(x, y, 3)
		g.drawPolygon(poly)
		poly = Polygon(x2, y2, 8)
		g.fillPolygon(poly)
		g.drawPolyline(x3, y3, 8)
		color = Color(87,40,210, 160)
    	g.setColor(color)
		g.fillRect(290, 210, 100, 50)
}
}
fun main(args:Array<String>) {
//Canvas,Frameを生成
		val canvas = Ex9_1()
		var f : Frame = Frame()
		f.addWindowListener(object: WindowAdapter(){
          public override fun windowClosing(e:WindowEvent?){
            System.exit(0)
          }
        })
//CanvasをFrameに配置
        f.setSize(500,400)
		f.add(canvas)
        f.setTitle("Ex9-1 Canvas")
        f.setVisible(true)
}

4) 霧吹きのように描画(draw)
//SprayDraw.kt
import java.awt.*
import java.awt.event.*
class SprayDraw internal constructor():Frame(), AdjustmentListener {
internal var cp:Point? = null
internal var radius = 1
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

5) 動くボール（マルチスレッドの例）
// MovingBall.kt
import java.awt.*
import java.awt.event.*

class Movingball :Frame(), Runnable {
internal var x = 250
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
if (y - r + dy < 0 || y + r + dy > height)
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
// g.setColor(Color.green);
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

6) Celsius-Fahrenheit converter
import java.awt.*
import java.awt.event.*
import javax.swing.*
class CFconverter:ActionListener {
internal var cvFrame:JFrame? = null
internal var cvPanel:JPanel? = null
internal var tCelsius:JTextField? = null
internal var celLabel:JLabel? = null
internal var faLabel:JLabel? = null
internal var cvTemp:JButton? = null
init{
cvFrame = JFrame("Convert Celsius to Fahrenheit")
cvFrame!!.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
cvFrame!!.setSize(Dimension(340, 180))
cvPanel = JPanel(FlowLayout()) // --
// Add the widgets.
 addWidgets()
// Set the default button.
 cvFrame!!.getRootPane()!!.setDefaultButton(cvTemp)
// Add the panel to the window.
 cvFrame!!.getContentPane()!!.add(cvPanel, BorderLayout.CENTER)
// Display the window.
 // cvFrame.pack();
 cvFrame!!.setVisible(true)
}

 private fun addWidgets() {
// Create widgets.
 tCelsius = JTextField(2)
celLabel = JLabel("Celsius", SwingConstants.LEFT)
cvTemp = JButton("Convert")
faLabel = JLabel(" Fahrenheit", SwingConstants.LEFT)
// Listen to events from the Convert button.
 cvTemp!!.addActionListener(this)
// Add the widgets to the container.
 cvPanel!!.add(tCelsius)
cvPanel!!.add(celLabel)
cvPanel!!.add(cvTemp)
cvPanel!!.add(faLabel)
celLabel!!.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
faLabel!!.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
}
public override fun actionPerformed(event:ActionEvent?) {
// Parse degrees Celsius as a double and convert to Fahrenheit.
 val tempFahr = ((java.lang.Double.parseDouble(tCelsius!!.getText())) * 1.8 + 32).toInt()
faLabel!!.setText("$tempFahr   Fahrenheit")
}
}
fun main(args:Array<String>){
CFconverter()
}

7) デジタルクロック
//A_DClock.kt
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
....
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
.....
thread!!.start()
repaint()
}
fun setHMS() { // 時刻の取得
val now = Calendar.getInstance()
.....

public override fun paintComponent(g:Graphics?) {
val g2 = g as Graphics2D?
g2!!.setColor(Color.white)
g2.fillRect(0, 0, getWidth(), getHeight())
// Digital Clock
.....
public override fun run() {
Thread.currentThread()!!.setPriority(Thread.NORM_PRIORITY - 3)
while (thread != null)
{
try
{
setHMS()
repaint()
Thread.sleep(20)
}
catch (e:InterruptedException) {}
}
thread = null
}
}