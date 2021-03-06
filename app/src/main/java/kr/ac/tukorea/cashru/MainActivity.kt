package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers.Main

// import me.relex.circleindicator.CircleIndicator
// import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  //      val indicator: CircleIndicator3 = findViewById(R.id.indicator) 인디케이터
        val view_pager: ViewPager2 = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val pagerAdapter = ParentFragmentPagerAdapter(this)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_view)

        view_pager.adapter = pagerAdapter
        view_pager.setAdapter(pagerAdapter)

       /*
        indicator.setViewPager(view_pager)
        indicator.createIndicators(5,0);
        indicator.animatePageSelected(2)
*/

        TabLayoutMediator(tabLayout, view_pager) { tab, position ->
            val tabNames = listOf("홍보","축제","명소")
            tab.text = tabNames[position]
        }.attach()

        bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_event -> {
                    val intent = Intent(this,EventPage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_transfer -> {
                    val intent = Intent(this,TransferMain::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_settings -> {
                    val intent = Intent(this,optionActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

}