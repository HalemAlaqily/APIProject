package pojos;

public class UserSetting {
    private String firstName;
    private String lastName;
    private String password;
    private Integer userStatus;
    private String phone;
    private Integer id;
    private String email;
    private String username;

    public UserSetting() {
    }

    public UserSetting( Integer id, String username, String firstName, String lastName , String email, String password, String phone, Integer userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userStatus = userStatus;
        this.phone = phone;
        this.email = email;

    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
    public void setUserStatus(Integer userStatus){
        this.userStatus = userStatus;
    }

    public Integer getUserStatus(){
        return userStatus;
    }

    @Override
    public String toString(){
        return
                "{" +
                        "id = '" + id + '\'' +
                        ",username = '" + username + '\'' +
                        ",firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",email = '" + email + '\'' +
                        ",password = '" + password + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",userStatus = '" + userStatus + '\'' +
                        "}";
    }
}
