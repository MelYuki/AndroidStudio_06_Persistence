package be.melyuki.demo06_persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.File
import java.io.FileWriter

class PersistanceFileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistence_file)

        // Utilisation de la classe "File"
        // *******************************

        // Création du fichier dans l'app
        val file1 = File(filesDir, "arnaud.txt")

        val fileWriter : FileWriter = FileWriter(file1, false)
        fileWriter.write("Hello Arnaud :o")
        fileWriter.close()

        // Création du fichier dans le cache de l'app
        val file2 = File(cacheDir, "nicolas.json")

        val fileWriter2 : FileWriter = FileWriter(file2, false)
        fileWriter2.write("{ 'name' : 'Nico' }")
        fileWriter2.close()


        // Utilisation des flux (file stream)
        // **********************************

        // Créer / Modifier un fichier
        val content : String = "Du rose (✿◕‿◕✿)"
        val filename : String = "melvin.txt"

        openFileOutput(filename, MODE_APPEND).use { fos ->
            fos.write(content.toByteArray())
            fos.write("\n".toByteArray())
        }

        // Lire le fichier
        openFileInput(filename).bufferedReader().useLines { lines ->

            val text : String = lines.joinToString(", ")

            Log.d("DEMO_FILE", text)
        }

        // Récuperation des fichiers de l'app
        // **********************************
        val files : Array<String> =  fileList()
        Log.d("DEMO_FILE", "Liste des fichiers : " + files.joinToString(", "))
    }
}