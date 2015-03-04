package io.enscene.topophone.model.accompanying;

public class Contact {
  
  private String name;
  private String phone;
  private String email;
  private String address;

  public String getName() {
    return name;
  }

  public Contact setName(String name) {
    this.name = name;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Contact setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Contact setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Contact setAddress(String address) {
    this.address = address;
    return this;
  }

}
