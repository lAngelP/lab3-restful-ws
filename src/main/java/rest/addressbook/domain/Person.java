package rest.addressbook.domain;

import rest.addressbook.utils.CloneUtils;
import rest.addressbook.utils.EqualsUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A person entry in an address book
 */
public class Person implements Cloneable {

  private String name;
  private int id;
  private String email;
  private URI href;
  private List<PhoneNumber> phoneList = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void addPhone(PhoneNumber phone) {
    getPhoneList().add(phone);
  }

  public List<PhoneNumber> getPhoneList() {
    return phoneList;
  }

  public void setPhoneList(List<PhoneNumber> phones) {
    this.phoneList = phones;
  }

  public boolean hasEmail() {
    return getEmail() != null;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Person)) return false;
    Person other = (Person) obj;
    return EqualsUtils.checkObject(this.name, other.name)
            && this.id == other.id
            && EqualsUtils.checkObject(this.email, other.email)
            && EqualsUtils.checkObject(this.href, other.href)
            && EqualsUtils.checkList(this.phoneList, other.phoneList);
  }

  @Override
  public Person clone() throws CloneNotSupportedException {
    Person p = new Person();
    p.name = CloneUtils.clone(this.name);
    p.id = this.id;
    p.email = CloneUtils.clone(this.email);
    try {
      p.href = this.href != null ? new URI(this.href.getPath()) : null;
    } catch (URISyntaxException e) {
      throw new CloneNotSupportedException("Cannot clone person due to URI exception: " + e.getMessage());
    }
    p.phoneList = this.phoneList.stream().map(PhoneNumber::clone).collect(Collectors.toList());
    return p;
  }

  @Override
  public String toString() {
    return "Person[id=" + id + ",name=" + name + ",email=" + email + ",href=" + href + ",phones=" + Arrays.toString(phoneList.toArray()) + ", ]";
  }
}
