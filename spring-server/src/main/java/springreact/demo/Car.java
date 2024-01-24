package springreact.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity // This tells Hibernate to make a table out of this class
//public class User {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Integer id;
//
//    private String name;
//
//    private String email;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Integer year;

    public String make;

    public String model;

    //public void setYear(int year) {
    //    this.year = year;
    //}

    //public void setMake(String make) {
    //    this.make = make;
    //}

    //public void setModel(String model) {
    //    this.make = model;
    //}
}
