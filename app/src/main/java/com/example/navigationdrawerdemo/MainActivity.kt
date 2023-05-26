package com.example.navigationdrawerdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.navigationdrawerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.open -> {
                        Toast.makeText(this@MainActivity, "First Item Clicked", Toast.LENGTH_SHORT)
                            .show()
                        drawerLayout.closeDrawer(GravityCompat.START, true)

//                        var fm=supportFragmentManager;
//                        var ft=fm.beginTransaction();
//                        var f=FirstFragment();
//                        ft.replace(R.id.frame,f)
//                        ft.commit();

                    }
                    R.id.share -> {
                        Toast.makeText(this@MainActivity, "Second Item Clicked", Toast.LENGTH_SHORT)
                            .show()
                        drawerLayout.closeDrawer(GravityCompat.START, true)

                        supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        var i= Intent(applicationContext,MainActivity2::class.java)
                       startActivity(i);
                    }
                    R.id.close -> {
                        Toast.makeText(this@MainActivity, "third Item Clicked", Toast.LENGTH_SHORT)
                            .show()
                        drawerLayout.closeDrawer(GravityCompat.START, true)

                    }
                }
                false
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}