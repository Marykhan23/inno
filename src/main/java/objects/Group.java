package objects;

import org.apache.commons.lang3.RandomStringUtils;

public class Group {
    private Boolean active;
    private int company_id;
    private String created;
    private int id;
    private String name;
    private String type;
    public Group(int company_id) {
        this.company_id = company_id;
        this.name = RandomStringUtils.randomAlphanumeric(6);
    }

    public Group(Boolean active, int company_id, String created, int id, String name, String type) {
        this.active = active;
        this.company_id = company_id;
        this.created = created;
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Group() {
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public int getCompany_id() {
        return company_id;
    }
    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Group{" +
                "active=" + active +
                ", company_id=" + company_id +
                ", created='" + created + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

