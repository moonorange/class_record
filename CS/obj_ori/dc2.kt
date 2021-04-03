import java.time.LocalTime
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Graphics2D
import java.util.Calendar
import javax.swing.JComponent
import javax.swing.JFrame





val date: Date = Date()

val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);

//Dateに格納された時刻をフォーマットに従って出力
val test1: String = DateFormat.format("yyyy/MM/dd kk:mm:ss", date).toString()