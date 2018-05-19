package spb.android.academy.fragments.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Collection {

  private int id;
  private String title;
  private String description;
  @SerializedName("preview_photos")
  private List<Photo> previewPhotos;
  private Links links;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public List<Photo> getPreviewPhotos() {
    return previewPhotos;
  }

  public String getBrowserLink() {
    return links.html;
  }

  static class Links {
    String html;
  }
}
