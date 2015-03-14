package net.paffett;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

public class MyQueueTest {

 MyQueue q = new MyQueue(); 
 
  @Test
  public void testContinuiousAdd() {
  
    String[] testArray = {"Twitter", "Facebook", "LinkedIn", "Instagram", "SnapChat" };
    
    for (String socialNetwork  : testArray) {
      q.addBack(socialNetwork);  
    }
    
    for (String socialNetwork  : testArray) {
      Object dequedSocialNetwork = q.removeFront();
      assertEquals(socialNetwork, (String)dequedSocialNetwork);
    }
    
  }

  @Test
  public void testInteruptedAdd() {
    
    String[] testArray1 = {"Twitter", "Facebook" };
    String[] testArray2 = {"LinkedIn", "Instagram", "SnapChat" };
    
    for (String socialNetwork  : testArray1) {
      q.addBack(socialNetwork);  
    }
    
    for (String socialNetwork  : testArray1) {
      Object dequedSocialNetwork = q.removeFront();
      assertEquals(socialNetwork, (String)dequedSocialNetwork);
    }
    
    for (String socialNetwork  : testArray2) {
      q.addBack(socialNetwork);  
    }
    
    for (String socialNetwork  : testArray2) {
      Object dequedSocialNetwork = q.removeFront();
      assertEquals(socialNetwork, (String)dequedSocialNetwork);
    }
    
  }
  
  @Test
  public void testStaggeredAddAndRemove() {
    
    String[] testAddArray1 = {"Twitter", "Facebook" };
    String[] testAddArray2 = {"LinkedIn", "Instagram", "SnapChat" };
    
    String[] testRemoveArray1 = {"Twitter"};
    String[] testRemoveArray2 = {"Facebook", "LinkedIn", "Instagram", "SnapChat" };
    
    //Add 2
    for (String socialNetwork  : testAddArray1) {
      q.addBack(socialNetwork);  
    }
    
    //Remove one and check
    for (String socialNetwork  : testRemoveArray1) {
      Object dequedSocialNetwork = q.removeFront();
      assertEquals(socialNetwork, (String)dequedSocialNetwork);
    }
    
    //Add 3 move
    for (String socialNetwork  : testAddArray2) {
      q.addBack(socialNetwork);  
    }
    
    //Remove 4 and check
    for (String socialNetwork  : testRemoveArray2) {
      Object dequedSocialNetwork = q.removeFront();
      assertEquals(socialNetwork, (String)dequedSocialNetwork);
    }
    
  }
  
  @Test(expected = EmptyStackException.class)
  public void testEmptyRemove() {
    q.removeFront();
  }

}
