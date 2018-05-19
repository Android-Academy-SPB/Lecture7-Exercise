package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ViewPager viewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewPager = findViewById(R.id.activity_main_view_pager);

    initViewPager();
  }

  private void initViewPager() {
    List<CollectionFragment> fragments = new ArrayList<>();
    fragments.add(CollectionFragment.newInstance(1));
    fragments.add(CollectionFragment.newInstance(2));
    fragments.add(CollectionFragment.newInstance(3));
    CollectionsPagerAdapter adapter = new CollectionsPagerAdapter(getSupportFragmentManager(), fragments);
    viewPager.setAdapter(adapter);
  }
}
