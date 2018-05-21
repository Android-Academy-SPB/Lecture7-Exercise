package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CollectionFragment.CollectionFragmentListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      openFragment(MainFragment.newInstance(), false);
    }
  }

  @Override public void onPreviewCollection(int collectionId) {
    openFragment(PreviewFragment.newInstance(collectionId), true);
  }

  private void openFragment(Fragment fragment, boolean addToBackStack) {
    final FragmentTransaction transaction = getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content, fragment);

    if (addToBackStack) {
      transaction.addToBackStack(null);
    }

    transaction.commit();
  }
}
