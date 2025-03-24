package java8.stream.dao;

import java.util.List;
import java.util.Optional;

public class Customer {

    private Integer id;
    private String name;
    private String email;
    public List<Integer> mobileno;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, List<Integer> mobileno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getMobileno() {
        return mobileno;
    }

    public void setMobileno(List<Integer> mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileno=" + mobileno +
                '}';
    }
}
