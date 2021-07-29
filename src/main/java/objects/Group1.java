package objects;

import org.apache.commons.lang3.RandomStringUtils;

public class Group1 {
    private int company_id;
    private String name;

    public Group1() {
    }
    public Group1(int company_id) {
        this.company_id = company_id;
        this.name = RandomStringUtils.randomAlphanumeric(6);
    }
}
