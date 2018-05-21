package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import spb.android.academy.fragments.domain.Collection;

import static spb.android.academy.fragments.CollectionFragment.ARG_COLLECTION_ID;

public class PreviewFragment extends Fragment {

  private Collection collection;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final int collectionId = getArguments().getInt(ARG_COLLECTION_ID);
    collection = CollectionsRepository.getInstance().getById(collectionId);
  }

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_preview, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    final RecyclerView recyclerView = (RecyclerView) view;
    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    recyclerView.setAdapter(new PhotosAdapter(Picasso.get(), collection.getPreviewPhotos()));
  }

  public static PreviewFragment newInstance(int collectionId) {
    final PreviewFragment fragment = new PreviewFragment();
    final Bundle bundle = new Bundle();
    bundle.putInt(ARG_COLLECTION_ID, collectionId);
    fragment.setArguments(bundle);
    return fragment;
  }
}
