package com.pako.githubsearch.view.main.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.arlib.floatingsearchview.FloatingSearchView
import com.google.android.material.navigation.NavigationView
import com.pako.githubsearch.R
import com.pako.githubsearch.presentation.main.MainPresenter
import com.pako.githubsearch.presentation.main.MainView
import com.pako.githubsearch.view.base.BaseFragment
import com.pako.githubsearch.view.search.ui.ScrollingSearchFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), BaseFragment.BaseExampleFragmentCallbacks,
    NavigationView.OnNavigationItemSelectedListener, MainView {

    override fun onAttachSearchViewToDrawer(searchView: FloatingSearchView) {
        searchView.attachNavigationDrawerToMenuButton(findViewById(R.id.drawer_layout))
    }

    @Inject
    internal lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        presenter.attach(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_bookmarks -> {
                presenter.onDrawerOptionBookmarkClick()
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showSearchFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ScrollingSearchFragment()).commit()
    }

    override fun showBookmarkFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
