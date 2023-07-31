package be.melyuki.demo06_persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.melyuki.demo06_persistence.databinding.ActivityPersistenceBundleBinding

class PersistenceBundleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPersistenceBundleBinding
    private var choiceNumber : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersistenceBundleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener onClick
        binding.btnDemoBundleValid.setOnClickListener{ validNumber() }


        // Restauration des données
        if(savedInstanceState != null && savedInstanceState.getBoolean("HasChoice", false)) {
            choiceNumber = savedInstanceState.getInt("MyChoice")
        }

        // Update du visuel
        if(choiceNumber != null) {
            binding.tvDemoBundleChoice.setText(getString(R.string.choice_number).format(choiceNumber))
        }
        else {
            binding.tvDemoBundleChoice.setText(R.string.no_choice_val)
        }
    }

    private fun validNumber() {
        choiceNumber = binding.etDemoBundleNumber.text.toString().toInt()
        binding.tvDemoBundleChoice.setText(getString(R.string.choice_number).format(choiceNumber))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Sauvegarde des données
        if(choiceNumber != null) {
            outState.putBoolean("HasChoice", true)
            outState.putInt("MyChoice", choiceNumber!!)
        } else {
            outState.putBoolean("HasChoice", false)
        }
    }
}