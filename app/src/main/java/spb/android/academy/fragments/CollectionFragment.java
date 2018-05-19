package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CollectionFragment extends Fragment {
  private static final String ARGS_NUM = "args:number";

  @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_collection, container, false);
    TextView textView = view.findViewById(R.id.textView);
    textView.setText("Fragment " + getArguments().getInt(ARGS_NUM));

    return view;
  }

  public static CollectionFragment newInstance(int collectionId) {
    final CollectionFragment fragment = new CollectionFragment();
    final Bundle bundle = new Bundle();
    bundle.putInt(ARGS_NUM, collectionId);
    fragment.setArguments(bundle);
    return fragment;
  }
}
