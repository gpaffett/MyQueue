package net.paffett.test.harness;

public class TestModelObject {
  
  Object value;

  /**
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value.toString();
  }
  
  
}
