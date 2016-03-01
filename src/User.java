package javademo;


public class User {
    public  String name;
    public  String address;
    public  String picture;
    public  String information;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }
    public String getPicture(){
        return picture;
    }

    public void setInformation(String information){
        this.information = information;
    }
    public String getInformation(){
        return information;
    }
}
