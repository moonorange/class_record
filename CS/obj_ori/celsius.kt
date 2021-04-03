import java.awt.*
import java.awt.event.*
import javax.swing.*

fun createAndShowGUI() {
//Make sure we have nice window decorations.
 JFrame.setDefaultLookAndFeelDecorated(true)
//val converter = CelsiusConverter()
MileConverter()
}
// 
fun main(args:Array<String>) {
//Schedule a job for the event-dispatching thread:
 //creating and showing this application's GUI.
 javax.swing.SwingUtilities.invokeLater(object:Runnable {
public override fun run() {
createAndShowGUI()
}
})
}
//
class MileConverter:ActionListener {
internal var converterFrame:JFrame? = null
internal var converterPanel:JPanel? = null
internal var tempMile:JTextField? = null
internal var mileLabel:JLabel? = null
internal var kmLabel:JLabel? = null
internal var convertTemp:JButton? = null
init{
//Create and set up the window.
 converterFrame = JFrame("Convert Mile to Km")
converterFrame!!.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
converterFrame!!.setSize(Dimension(120, 40))
//Create and set up the panel.
 converterPanel = JPanel(GridLayout(2, 2))
//Add the widgets.
 addWidgets()
//Set the default button.
 converterFrame!!.getRootPane()!!.setDefaultButton(convertTemp)
//Add the panel to the window.
 converterFrame!!.getContentPane()!!.add(converterPanel, BorderLayout.CENTER)
//Display the window.
 converterFrame!!.pack()
converterFrame!!.setVisible(true)
}
/**
 * Create and add the widgets.
 */
 private fun addWidgets() {
//Create widgets.
 tempMile = JTextField(2)
mileLabel = JLabel("Mile", SwingConstants.LEFT)
convertTemp = JButton("Convert")
kmLabel = JLabel("Km", SwingConstants.LEFT)
//Listen to events from the Convert button.
 convertTemp!!.addActionListener(this)
//Add the widgets to the container.
 converterPanel!!.add(tempMile)
converterPanel!!.add(mileLabel)
converterPanel!!.add(convertTemp)
converterPanel!!.add(kmLabel)
mileLabel!!.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
kmLabel!!.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
}
public override fun actionPerformed(event:ActionEvent?) {
//Parse degrees Celsius as a double and convert to Fahrenheit.
 val tempKm = ((((java.lang.Double.parseDouble(tempMile!!.getText())) / 0.62137) )).toInt()
kmLabel!!.setText(tempKm.toString() + " km")
 }
}

//-----