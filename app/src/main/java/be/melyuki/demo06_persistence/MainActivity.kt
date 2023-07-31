package be.melyuki.demo06_persistence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.melyuki.demo06_persistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainDemoBundle.setOnClickListener { openDemoBundle() }
        binding.btnMainDemoPref.setOnClickListener { openDemoPref() }
        binding.btnMainDemoDatastore.setOnClickListener { openDemoDatastore() }
        binding.btnMainDemoFile.setOnClickListener { openDemoFile() }
    }

    private fun openDemoDatastore() {
        val intent : Intent = Intent(this, PersistenceDataStoreActivity::class.java)
        startActivity(intent)
    }

    private fun openDemoFile() {
        val intent : Intent = Intent(this, PersistenceFileActivity::class.java)
        startActivity(intent)
    }

    private fun openDemoPref() {
        val intent : Intent = Intent(this, PersistencePrefActivity::class.java)
        startActivity(intent)
    }

    private fun openDemoBundle() {
        val intent : Intent = Intent(this, PersistenceBundleActivity::class.java)
        startActivity(intent)
    }

}