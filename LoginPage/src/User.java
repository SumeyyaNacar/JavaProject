public class User {
    public String name;
    public String username;
    public String email;
    public String password;

    //her class olusturulurken default olarak bir parametresiz constructor bulunur.
    // ancak ben olusturdugum instance variable'lari set ederken onu kullanamam.
    // yani degiskenlerime deger atayamam
    // bu nedenle parametreli bir constructor'a ihtiyacim var

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
