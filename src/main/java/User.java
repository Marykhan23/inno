import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang3.RandomStringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
//@JsonIgnoreProperties
public class User /*implements  Serializable*/{
    private FullName fullName;
    private Date birthday;
    private String registrationDate;
    private String login;
    private String password;

    public User(FullName name) {
        this.fullName = name;
    }

    public User(FullName name, Date birthday, String registrationDate, String login, String password) {
        this.fullName = name;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }

    public User() {
        this.fullName = randomName();
        this.birthday = randomDate();
        this.registrationDate = randomRegistrationDate();
        this.login = randomLogin(6);
        this.password = randomPassword(6);
    }

    private FullName randomName(){
        return new FullName();
    }

    private String getFullName(FullName fullName){
        return fullName.secondName + " " + fullName.firstName + " " + fullName.middleName;
    }
    private Date randomDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(ThreadLocalRandom.current().nextInt() * 1000L);
    }
    private String randomRegistrationDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }
    private String randomLogin(int count){
        return RandomStringUtils.randomAlphanumeric(count);
    }
    private String randomPassword(int count){
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public FullName getFullName() {
        return fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getLogin() {
        return login;
    }
    @JacksonXmlProperty(localName = "Masha_Password")
    public String getPassword() {
        return password;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class FullName /*implements  Serializable*/{
        private String firstName;
        private String secondName;
        private String middleName;
        @Override
        public String toString() {
            return "FullName{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    '}';
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }
        @JsonIgnore
        public String getMiddleName() {
            return middleName;
        }

        public FullName() {
            this.firstName = generateRandomFirstName();
            this.secondName = generateRandomLastName();
            this.middleName = generateRandomMiddleName();
        }
        private String generateRandomFirstName(){
            String[] root = {"John","Scarlett","Bill","Kira","Sasha"};
            return root[new Random().nextInt(root.length)] ;
        }
        private String generateRandomLastName(){
            String[] root = {"Clinton","Lebovich","Bush","Obama","Castillo"};
            return root[new Random().nextInt(root.length)];
        }
        private String generateRandomMiddleName(){
            String[] root = {"Ivanov","Sidorov","Petrov","Sosov"};
            String[] suf = {"ich","ova"};
            return root[new Random().nextInt(root.length)]  + suf[new Random().nextInt(suf.length)];
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", registrationDAte=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}