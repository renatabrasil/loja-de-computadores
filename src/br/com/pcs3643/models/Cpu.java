package br.com.pcs3643.models;

public class Cpu extends Product {
  private Integer id;
  private String name;
  private String socket;

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

  public String getSocket() {
    return socket;
  }

  public void setSocket(String socket) {
    this.socket = socket;
  }
}
