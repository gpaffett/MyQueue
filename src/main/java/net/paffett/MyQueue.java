package net.paffett;

import java.util.Iterator;
import java.util.Stack;

interface Queue {

  /**
   * Add object o to the tail of the queue.
   */
  void addBack(Object o);

  /**
   * Removes and removes the object that is the head of the queue.
   */
  Object removeFront();
}

public class MyQueue implements Queue {
  
  private Stack<Object> addStack = new Stack<Object>();
  private Stack<Object> removeStack = new Stack<Object>();; 

  @Override
  public void addBack(Object obj) {
    addStack.push(obj);
  }

  @Override
  public Object removeFront() {
    if (removeStack.isEmpty()) {
      migrateStack();
    }
    return removeStack.pop();
  }
  
  private void migrateStack() {
    while(!addStack.isEmpty()) {
      removeStack.push(addStack.pop());
    }
  }
  
}
