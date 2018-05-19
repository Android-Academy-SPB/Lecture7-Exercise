package spb.android.academy.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import spb.android.academy.fragments.domain.Collection;

public class CollectionFragment extends Fragment {
  private static final String ARGS_COLLECTION_ID = "args:collection_id";

  private TextView nameTextView;
  private TextView descriptionTextView;
  private ImageView previewImage;

  private Collection collection;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final int collectionId = getArguments().getInt(ARGS_COLLECTION_ID);
    collection = CollectionsRepository.getInstance().getById(collectionId);
  }

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_collection, container, false);

    nameTextView = view.findViewById(R.id.fragment_collection_name);
    descriptionTextView = view.findViewById(R.id.fragment_collection_description);
    previewImage = view.findViewById(R.id.fragment_collection_preview_image);

    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    nameTextView.setText(collection.getTitle());
    descriptionTextView.setText(collection.getDescription());
    final String imageUrl = collection.getPreviewPhotos().get(0).getUrlForSmall();
    Picasso.get().load(imageUrl).into(previewImage);
  }

  public static CollectionFragment newInstance(int collectionId) {
    final CollectionFragment fragment = new CollectionFragment();
    final Bundle bundle = new Bundle();
    bundle.putInt(ARGS_COLLECTION_ID, collectionId);
    fragment.setArguments(bundle);
    return fragment;
  }
}
