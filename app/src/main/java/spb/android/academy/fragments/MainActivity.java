package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spb.android.academy.fragments.domain.Collection;
import spb.android.academy.fragments.network.NetworkManager;

public class MainActivity extends AppCompatActivity {

  private ViewPager viewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewPager = findViewById(R.id.activity_main_view_pager);

    initViewPager();
    NetworkManager.getApiInstance().getFeaturedCollections().enqueue(new Callback<List<Collection>>() {
      @Override
      public void onResponse(@NonNull Call<List<Collection>> call, @NonNull Response<List<Collection>> response) {
        List<Collection> collections = response.body();
        if (collections != null) {
          Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
        } else {
          showErrorMessage();
        }
      }

      @Override public void onFailure(@NonNull Call<List<Collection>> call, @NonNull Throwable t) {
        showErrorMessage();
      }
    });
  }

  private void initViewPager() {
    List<CollectionFragment> fragments = new ArrayList<>();
    fragments.add(CollectionFragment.newInstance(1));
    fragments.add(CollectionFragment.newInstance(2));
    fragments.add(CollectionFragment.newInstance(3));
    CollectionsPagerAdapter adapter = new CollectionsPagerAdapter(getSupportFragmentManager(), fragments);
    viewPager.setAdapter(adapter);
  }

  private void showErrorMessage() {
    Toast.makeText(this, "Something went wrong :(", Toast.LENGTH_SHORT).show();
  }
}
