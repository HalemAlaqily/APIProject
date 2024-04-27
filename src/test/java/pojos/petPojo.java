package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class petPojo {
    private Integer id;
    private categoryPojo category;
    private String name;
    private ArrayList<String> photoUrls;
    // data type must be the pojo class we created for that.
    private ArrayList<tagPojo> tag;
    private String status;

    public petPojo() {
    }
    public petPojo(Integer id , categoryPojo category ,String name, ArrayList<String> photoUrls ,ArrayList<tagPojo> tag, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tag = tag;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public categoryPojo getCategory() {
        return category;
    }

    public void setCategory(categoryPojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = (photoUrls);
    }

    public ArrayList<tagPojo> getTag() {
        return tag;
    }

    public void setTag(ArrayList<tagPojo>tag) {
        this.tag = tag;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "petPojo{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", name=" + name +
                ", photoUrls=" + photoUrls +
                ", tag=" + tag +
                ", status='" + status + '\'' +
                '}';
    }
}
