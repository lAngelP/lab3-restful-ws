package rest.addressbook.domain;

import rest.addressbook.utils.EqualsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A really simple Address Book. This class is not thread safe.
 */
public class AddressBook implements Cloneable {

  private int nextId = 1;
  private List<Person> personList = new ArrayList<>();

  /**
   * The value of next unique identifier.
   *
   * @return the next unique identifier.
   */
  public int getNextId() {
    return nextId;
  }

  public void setNextId(int nextId) {
    this.nextId = nextId;
  }

  /**
   * The list of persons in this address book.
   *
   * @return a person list.
   */
  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> persons) {
    this.personList = persons;
  }

  /**
   * Returns the old next identifier and increases the new value in one.
   *
   * @return an identifier.
   */
  public int nextId() {
    int oldValue = nextId;
    nextId++;
    return oldValue;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AddressBook)) return false;
    AddressBook other = (AddressBook) obj;
    return other.nextId == this.nextId && EqualsUtils.checkList(this.personList, other.personList);
  }

  @Override
  public AddressBook clone() throws CloneNotSupportedException {
    AddressBook abCloned = (AddressBook) super.clone();
    abCloned.nextId = this.nextId;
    Stream<Person> stream = this.personList.stream().map(p -> {
      try {
        return p.clone();
      } catch (CloneNotSupportedException e) {
        return null;
      }
    });
    abCloned.personList = stream.collect(Collectors.toList());
    return abCloned;
  }
}
