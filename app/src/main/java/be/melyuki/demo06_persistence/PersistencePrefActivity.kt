package be.melyuki.demo06_persistence

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import java.util.prefs.Preferences

class PersistancePrefActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistence_pref)


        // Récuperation du fichier Preferences
        // ***********************************

        // - Fichier de pref pour l'activité uniquement :(
        val prefs1: SharedPreferences = getPreferences(MODE_PRIVATE)

        // - Fichier partagé custom
        val prefs2: SharedPreferences = getSharedPreferences("test.pref", MODE_PRIVATE)

        // - Fichier partagé par defaut (Déprécié depuis API 29)
        val prefs3: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)


        // Modification des Preferences
        // ****************************

        // - Créer d'un editor
        val editor: SharedPreferences.Editor = prefs3.edit()

        // - Add / Modify data
        editor.putString("Username", "Della")
        editor.putBoolean("IsAdmin", true)
        editor.putInt("NbChoice", 42)

        // - Sauvegarde des données
        editor.apply()  // Autre possibilité : editor.commit()


        // - Exemple en utilisant le "chainage"
        prefs1.edit()
            .putString("Username", "Zaza")
            .putBoolean("IsAdmin", false)
            .putInt("NbChoice", 1337)
            .apply()


        // Récuperation des valeurs
        // ****************************

        val username = prefs3.getString("Username", "Zaza")
        val isAdmin = prefs3.getBoolean("IsAdmin", false)
        val number = prefs3.getInt("NbChoice", 0)
    }
}