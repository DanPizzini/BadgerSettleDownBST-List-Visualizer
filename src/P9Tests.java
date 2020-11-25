//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P09 Badgers Settle Down)
// Files: (Sett.java, Badger.java, P9Tests.java)
// Course: (300, fall, 2018-2019)
//
// Author: (Dante Pizzni)
// Email: (pizzini@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Joseph Cambio)
// Partner Email: (jcambio@wisc.edu)
// Partner Lecturer's Name: (Gary Dahl)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This Class contains the Badger and Sett tests methods and reports if they passed or failed
 * 
 * @author jdcam
 *
 */
public class P9Tests {

  /**
   * This method runs all of the Badger tests
   * 
   * @return a boolean if the tests passed or failed
   */
  public static boolean runAllBadgerTests() { // returns true when all Badger tests pass
    if (LeftLowerTest() && RightLowerTest() && BadgerConstrTest()) { // if metohds are true
      System.out.println("All Badger Tests passed!"); // report to console
      return true;
    } // return true
    System.out.println("One or more Badger tests failed"); // if they are false report to console
    return false;
  }

  /**
   * This method runs all of the Sett tests and reports if they passed or failed to the console
   * 
   * @return
   */
  public static boolean runAllSettTests() { // returns true when all Sett tests pass
    if (getTopBadgerTest() && isEmptyTest() && settleBadgerTest() && findBadgerTest()
        && countBadgerTest() && getAllBadgersTest() && getheightTest() && getLargestBadgerTest()
        && clearTest() && settConstrTest()) { // if statement that if all tests pass

      System.out.println("All Sett tests passed!"); // reports they passed to console
      return true;
    }
    System.out.println("One or more Sett tests failed!"); // if they fail it also reports it to the
                                                          // console
    return false;
  }

  /**
   * Tets the gettopBadger method in sett
   * 
   * @return
   */
  public static boolean getTopBadgerTest() {
    Sett sett1 = new Sett(); // creates a sett
    sett1.settleBadger(50); // Settles a top badger in the sett
    sett1.settleBadger(70);// settles rest of badgers in sett
    sett1.settleBadger(40);

    if (sett1.getTopBadger().getSize() == 50) // makes sure that get top badger returns the actual
                                              // top badger
      return true;
    System.out.println("Test1 fail");
    return false;
  }

  /**
   * Checks to see if Sett is empty
   * 
   * @return
   */
  public static boolean isEmptyTest() {
    Sett sett1 = new Sett(); // creates a sett with out any badgers

    if (sett1.isEmpty()) // If isEmpty works this method returns true
      return true;
    System.out.println("Test2 fail");

    return false;
  }

  /**
   * Checks to see if settleBadger works
   * 
   * @return
   */
  public static boolean settleBadgerTest() {
    try { // uses a try catch block to see if it throws exception
      Sett sett1 = new Sett();
      sett1.settleBadger(50); // two badgers of the same size are added
      sett1.settleBadger(50);
    } catch (IllegalArgumentException e) { // catches the exception and returns true if caught
      return true;
    }
    System.out.println("Test3 fail");

    return false;
  }

  /**
   * Checks to see if findBadger method works
   * 
   * @return
   */
  public static boolean findBadgerTest() {
    Sett sett1 = new Sett(); // creates sett
    sett1.settleBadger(60);// add badgers
    sett1.settleBadger(70);
    try { // using try catch to check if an exception is thrown
      sett1.findBadger(69); // finding a badger that isn't in the sett
    } catch (NoSuchElementException e) { // Catches exception and returns true
      return true;
    }
    System.out.println("Test4 fail");

    return false;
  }

  /**
   * Test the countBadger method
   * 
   * @return
   */
  public static boolean countBadgerTest() {
    Sett sett = new Sett(); // creates a sett
    sett.settleBadger(55); // settles 4 badgers
    sett.settleBadger(40);
    sett.settleBadger(66);
    sett.settleBadger(32);

    if (sett.countBadger() == 4) // if the count method works return true
      return true;
    System.out.println("Test5 fail");

    return false;
  }

  /**
   * Tests the getAllBadgers mxethod
   * 
   * @return
   */
  public static boolean getAllBadgersTest() {
    Sett sett = new Sett(); // creates a sett
    sett.settleBadger(32); // adds badgers
    sett.settleBadger(14);// the smallest badger
    sett.settleBadger(35); 
    java.util.List<Badger> Bt; // created a list with type badger
    Bt = sett.getAllBadgers();
    if (Bt.get(0).getSize() == 14) // if the badger at element 0 size is 14 (the smallest badger) the
                                   // test passed
      return true;
    System.out.println("Test6 fail");
    return false;

  }

  /**
   * Tests the getHeightMethod
   * 
   * @return
   */
  public static boolean getheightTest() {
    Sett sett = new Sett(); // creates sett
    sett.settleBadger(32); // adds badgers to BST with height of three
    sett.settleBadger(31);
    sett.settleBadger(34);
    sett.settleBadger(35);

    if (sett.getHeight() == 3) // if its computes the correct height the test passed
      return true;
    System.out.println("Test7 fail");

    return false;

  }

  /**
   * Test the getLargestBadger mthod
   * 
   * @return
   */
  public static boolean getLargestBadgerTest() {
    Sett sett = new Sett(); // creates a sett
    sett.settleBadger(34);// adds badgers
    sett.settleBadger(98); // largest badger
    sett.settleBadger(91);
    sett.settleBadger(15);

    if (sett.getLargestBadger().getSize() == 98) // if the method returns 98 test passed
      return true;
    System.out.println("Test8 fail");

    return false;


  }

  /**
   * test the clear method
   * 
   * @return
   */
  public static boolean clearTest() {
    Sett sett = new Sett(); // creates a sett
    sett.settleBadger(30); // adds badgers
    sett.settleBadger(34);
    sett.settleBadger(35);
    sett.clear(); // runs the clear method
    if (sett.getHeight() == 0) { // if the height of the sett is now zero the test passed
      return true;
    }
    System.out.println("Test9 fail");

    return false;
  }

  /**
   * Tests the constructor of sett class
   * 
   * @return
   */
  public static boolean settConstrTest() {
    Sett sett = new Sett(); // creates sett

    if (sett != null) // makes sure sett is not null
      // note that while the sett is empty it is not null 
      return true;
    System.out.println("Test10 fail");

    return false;



  }

  /**
   * tests the LeftLowerNeightbor method
   * 
   * @return
   */
  public static boolean LeftLowerTest() {
    Badger B1 = new Badger(50); // creates two new badgers
    Badger B2 = new Badger(44);
    B1.setLeftLowerNeighbor(B2); // sets b2 as lower left neighbor of B1

    if (B1.getLeftLowerNeighbor().getSize() == 44) // Checks to see if the getLeftLowerNeighbor
                                                   // returns the neighbor set
      return true;

    return false;

  }

  /**
   * Tests RightLowerNeighbor method
   * 
   * @return
   */
  public static boolean RightLowerTest() {
    Badger B1 = new Badger(50); // adds two badgers
    Badger B2 = new Badger(44);
    B1.setRightLowerNeighbor(B2); // sets B2 as B1 right lower neighbor

    if (B1.getRightLowerNeighbor().getSize() == 44) // checks to see if B2 is actually B1 left lower
                                                    // neighbor
      return true;
    return false;
  }

  /**
   * Tests the constructor of the class Badger
   * 
   * @return
   */
  public static boolean BadgerConstrTest() {
    Badger B1 = new Badger(30); // creates a badger with size 30

    if (B1 != null) // makes sure there actually is a badger present
      return true;
    return false;

  }

  /**
   * Main method calls the two test method runners
   * 
   * @param args
   */
  public static void main(String[] args) {
    runAllBadgerTests();
    runAllSettTests();
  }

}
