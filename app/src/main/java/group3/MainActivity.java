package group3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.cp102group3maple.violethsu.maple.R;

import java.util.ArrayList;
import java.util.List;
import group3.explore.ExploreFragment;
import group3.friend.FriendsList;
import group3.mypage.MypageFragment;

// need to debug mypage頁面一開始沒有tablayout
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        final BottomNavigationView navigation =findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_mypage:
                        getSupportActionBar().show();
                        viewPager.setCurrentItem(0);
                        return true;

                    case R.id.navigation_explore:
                        getSupportActionBar().hide();
                        viewPager.setCurrentItem(1);
                        return true;
                    //點擊下方朋友選單時，跑出朋友清單
                    case R.id.navigation_friends:
                        getSupportActionBar().show();
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_mypage);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_explore);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_friends);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    private void initContent() {
        getActionBar().show();
        viewPager.setCurrentItem(0);
//        Fragment fragment = new MypageFragment();
//        changeFragment(fragment);
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
    private void setupViewPager(ViewPager viewPager) {
        BottomNavPagerAdapter adapter = new BottomNavPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MypageFragment());
        adapter.addFragment(new ExploreFragment());
        adapter.addFragment(new FriendsList());
        viewPager.setAdapter(adapter);
    }
    public class BottomNavPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mainFragmentList = new ArrayList<>();

        public BottomNavPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mainFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mainFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mainFragmentList.add(fragment);
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        int id = getIntent().getIntExtra("id", 0);
        if (id == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mypagetest,new MypageFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }
}

