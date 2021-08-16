
import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.util.Log
import timber.log.Timber
import java.io.File
import java.io.FileWriter
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class FileLoggingTree(
    private val context: Context
) : Timber.DebugTree() {

    @SuppressLint("LogNotTimber")
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)

        try {
            val path = "Log"
            val fileNameTimeStamp: String = SimpleDateFormat(
                "dd-MM-yyyy",
                Locale.getDefault()
            ).format(Date())
            val logTimeStamp: String = SimpleDateFormat(
                TIMESTAMP_PATTERN,
                Locale.getDefault()
            ).format(Date())
            val fileName = "$fileNameTimeStamp.html"

            // Create file
            val file: File? = generateFile(path, fileName, context)

            // If file created or exists save logs
            if (file != null) {
                val writer = FileWriter(file, true)
                writer.append(
                    "<p style=\"background:lightgray;\"><strong "
                            + "style=\"background:lightblue;\">&nbsp&nbsp"
                )
                    .append(logTimeStamp)
                    .append(" :&nbsp&nbsp</strong><strong>&nbsp&nbsp")
                    .append(tag)
                    .append("</strong> - ")
                    .append(message)
                    .append("</p>")
                writer.flush()
                writer.close()
            }
            //Log.d(LOG_TAG, message)
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error while logging into file : $e")
        }
    }

    override fun createStackElementTag(element: StackTraceElement): String? {
        // Add log statements line number to the log
        return super.createStackElementTag(element) + " - " + element.lineNumber
    }

    companion object {
        private const val LOG_TAG = "CallBlocker"
        private const val TIMESTAMP_PATTERN = "dd-MM-yyyy 'at' hh:mm:ss:SSS"

        /*  Helper method to create file*/
        @SuppressLint("LogNotTimber")
        private fun generateFile(path: String, fileName: String, context: Context): File? {
            var file: File? = null
            if (isExternalStorageAvailable) {

                val root = File(context.getExternalFilesDir(null), path)
                var dirExists = true
                if (!root.exists()) {
                    dirExists = root.mkdirs()
                    Log.d("TimberLoggingTree", "Generated Logs file at: ${root.absolutePath}")
                }
                if (dirExists) {
                    file = File(root, fileName)
                }
            }

            return file
        }

        /* Helper method to determine if external storage is available*/
        private val isExternalStorageAvailable: Boolean
            get() = Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
    }
}