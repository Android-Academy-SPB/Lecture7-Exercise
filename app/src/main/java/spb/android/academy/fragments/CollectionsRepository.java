package spb.android.academy.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spb.android.academy.fragments.domain.Collection;

public class CollectionsRepository {

  private static final CollectionsRepository INSTANCE = new CollectionsRepository();

  public static CollectionsRepository getInstance() {
    return INSTANCE;
  }

  private Map<Integer, Collection> storage;

  private CollectionsRepository() {
    this.storage = new HashMap<>();
  }

  public Collection getById(int id) {
    return storage.get(id);
  }

  public void save(Collection collection) {
    storage.put(collection.getId(), collection);
  }

  public List<Collection> getAll() {
    return new ArrayList<>(storage.values());
  }
}
