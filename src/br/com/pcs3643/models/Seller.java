package br.com.pcs3643.models;

public class Seller {
  private int id;
  private String name;
  private String cpf;
  private String email;
  private String phone;
  private String address;
  private String password;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
