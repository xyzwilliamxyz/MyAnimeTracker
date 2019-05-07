package com.think4software.myanimetracker.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.ui.home.seasonal.SeasonalAnimeFragment
import com.think4software.myanimetracker.ui.home.tracking.TrackingAnimeFragment
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf




class HomeActivity : AppCompatActivity(), HomeContract.View, NavigationView.OnNavigationItemSelectedListener {

    private val presenter: HomeContract.Presenter by inject { parametersOf(this) }
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initView()

        presenter.onStart()
    }

    private fun initView() {
        drawerLayout = drawer_layout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.nav_tracking)
        onNavigationItemSelected(navigation_view.menu.findItem(R.id.nav_tracking))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true

        return super.onOptionsItemSelected(item)
    }

    override fun showLoading(showHide: Boolean) {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.nav_tracking -> {
                transaction.replace(R.id.content_frame, TrackingAnimeFragment()).commit()
            }
            R.id.nav_seasonal -> {
                transaction.replace(R.id.content_frame, SeasonalAnimeFragment()).commit()
            }
            R.id.nav_settings -> {
                // TODO not implemented
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
