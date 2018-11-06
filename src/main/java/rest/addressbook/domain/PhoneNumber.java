package rest.addressbook.domain;

import rest.addressbook.utils.CloneUtils;
import rest.addressbook.utils.EqualsUtils;

/**
 * A phone number
 */
public class PhoneNumber implements Cloneable {

  private String number;
  private PhoneType type = PhoneType.HOME;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PhoneType getType() {
    return type;
  }

  public void setType(PhoneType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PhoneNumber)) return false;
    PhoneNumber other = (PhoneNumber) obj;
    return EqualsUtils.checkObject(this.number, other.number) && EqualsUtils.checkObject(this.type, other.type);
  }

  @Override
  protected PhoneNumber clone() {
    PhoneNumber phoneCloned = new PhoneNumber();
    phoneCloned.number = CloneUtils.clone(this.number);
    phoneCloned.type = this.type;
    return phoneCloned;
  }
}
