package be.melyuki.demo06_persistence

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// Pour utiliser le DataStore (Nouvelle alternative au SharedPrefs)
// - Dans les dependencies du grade  ajouter :
//   implementation("androidx.datastore:datastore-preferences:1.0.0")
// Doc : https://developer.android.com/topic/libraries/architecture/datastore

// Création du "Data Store"
val Context.dataStore : DataStore<Preferences> by preferencesDataStore("demo-datastore")

class PersistanceDataStoreActivity : AppCompatActivity() {

    val KEY_COUNTER = intPreferencesKey("COUNTER")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistence_data_store)

        // Lecture dans le dataStore
        val data : Flow<Int> = dataStore.data.map { prefs ->
            prefs[KEY_COUNTER] ?: 0
        }

        // Async moche ↓
        runBlocking {
            initCount()
            incrCount()
            incrCount()
        }
    }

    suspend fun initCount() {
        dataStore.edit { prefs ->
            // Initialisation la valeur
            prefs[KEY_COUNTER] = 0
        }
    }

    suspend fun incrCount() {
        dataStore.edit { prefs ->
            // Modifie la valeur
            prefs[KEY_COUNTER] = (prefs[KEY_COUNTER] as Int) + 1
        }
    }
}