package org.example;

public class user {       // declare new class (user ) for enter to app

    private String firsName;      // use private modifier to save code and store the first, last, username
    private String lastName;
    private String Username;

// constructor

    public user (String firsName, String lastName, String username){
       this.firsName = firsName;
       this.lastName = lastName;
       this.Username = username;
    }
    // getter and Setter
    public String getFirsName(){  //  getter methods that return the value
        return firsName;
    }

    public void setFirsName(String lastName) {  // setter methods allowing to set or change the value from outside
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
