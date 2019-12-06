package com.swdec.paxan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.swdec.paxan.setup.FinishFragment
import com.swdec.paxan.setup.NameFragment
import com.swdec.paxan.setup.PlanFragment
import com.swdec.paxan.setup.WelcomeFragment

class SetupActivity : AppCompatActivity() {

    private var currentFragment = WELCOME_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        swapContentFragment(WelcomeFragment())

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            when (currentFragment) {
                NO_FRAGMENT -> {
                    swapContentFragment(WelcomeFragment())
                    currentFragment = WELCOME_FRAGMENT
                }
                WELCOME_FRAGMENT -> {
                    swapContentFragment(NameFragment())
                    currentFragment = NAME_FRAGMENT
                }
                NAME_FRAGMENT -> {
                    swapContentFragment(PlanFragment())
                    currentFragment = PLAN_FRAGMENT
                }
                PLAN_FRAGMENT -> {
                    swapContentFragment(FinishFragment())
                    currentFragment = FINISH_FRAGMENT
                }
                FINISH_FRAGMENT -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (currentFragment > NO_FRAGMENT) currentFragment--
    }

    private fun swapContentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(R.id.content, fragment, null)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    companion object {
        const val NO_FRAGMENT = 0
        const val WELCOME_FRAGMENT = 1
        const val NAME_FRAGMENT = 2
        const val PLAN_FRAGMENT = 3
        const val FINISH_FRAGMENT = 4
    }
}
