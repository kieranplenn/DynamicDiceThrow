package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    private lateinit var buttonFragment: ButtonFragment
    private lateinit var dieFragment: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFragment = ButtonFragment()
        dieFragment = DieFragment()

        /* TODO 1: Load fragment(s)
            - Show only Button Fragment if portrait
            - show both fragments if Landscape
        */
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            // Show only Button Fragment if portrait
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, buttonFragment) // Replace with ButtonFragment
                .commit()
        } else {
            // Show both fragments if landscape
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, buttonFragment) // Replace ButtonFragment
                .add(R.id.container2, dieFragment) // Add DieFragment on top
                .commit()
        }
    }

    /* TODO 2: Switch fragments if portrait (no need to switch fragments if Landscape)
        */
    // Remember to place Fragment transactions on BackStack so they can be reversed
    override fun buttonClicked() {
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            // Switch to DieFragment when the button is clicked
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, dieFragment) // Replace ButtonFragment with DieFragment
                .addToBackStack(null) // Add to back stack for navigation
                .commit()
        }
    }
}
