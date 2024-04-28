package pojos;

public class categoryPojo {
    private int id;
    private String name;

    public categoryPojo() {
    }
//
    public categoryPojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "categoryPojo{" +
            "id='" + id + '\''+
                ", name='" + name + '\''+
                '}';
        }
}
