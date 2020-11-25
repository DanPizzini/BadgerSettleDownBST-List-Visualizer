//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P09 Badgers Settle Down)
// Files: (Badger.java, Sett.java, P9Tests.java, BadgersSettleDown.java)
//
// Course: (CS300, Fall Semester, 2018)
//
// Author: (Dante Pizzini)
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
// Persons: (none)
// Online Sources: (none)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * This class represents a Sett, where a group of Badgers live together. Each sett is organized as a
 * BST of Badger Nodes
 * 
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class Sett {

  private Badger topBadger; // the top badger in the current sett BST

  /**
   * constructor for the Sett class, creates an empty sett to be populated with Badger nodes
   */
  public Sett() {
    topBadger = null; // any empty sett's topBadger, the BST root node, is a null reference
  }

  /**
   * retrieves the top Badger within this set (the badger that settled first)
   * 
   * @return topBadger
   */
  public Badger getTopBadger() {
    return topBadger; // the current top badger in the Sett
  }

  /**
   * checks whether the Sett is empty
   * 
   * @return true if the Sett is empty, else false
   */
  public boolean isEmpty() {
    if (topBadger == null) { // if the topBadger is a null reference, the sett is empty
      return true;
    } else { // the topBadger is not null, therefore the sett (BST) is not empty
      return false;
    }
  }

  /**
   * creates a new Badger object with the specified size and inserts them it into this Sett (BST)
   * 
   * @param size The desired size of the Badger to be settled
   * @throws IllegalArgumentException exception is thrown when a user attempts to add a Badger of
   *                                  duplicate size to the Sett
   */
  public void settleBadger(int size) throws IllegalArgumentException {
    Badger newBadger = new Badger(size); // creates the new badger that may be added to the sett
    if (isEmpty() == true) { // if the sett is empty, this new badger will be the first, i.e. the
                             // new badger is the root node of our BST
      topBadger = newBadger;
    } else { // if the sett is not empty, call to recursive method settleHelper to insert new badger
             // into sett (BST)
      settleHelper(topBadger, newBadger);
    }
  }

  /**
   * recursive helper method which helps settle a new Badger within the Sett (BST)
   * 
   * @param current   The current Badger (last one to settle in the Sett) that the new Badger will
   *                  settle beneath (to the left or to the right)
   * @param newBadger The new Badger to be settled within the Sett
   * @throws IllegalArgumentException
   */
  private void settleHelper(Badger current, Badger newBadger) throws IllegalArgumentException {

    if (newBadger.getSize() < current.getSize()) { // if the new badger is smaller than the current
                                                   // one
      if (current.getLeftLowerNeighbor() == null) { // if the current badger does not have a left
                                                    // neighbor
        current.setLeftLowerNeighbor(newBadger); // the new badger is made the current badgers left
                                                 // neighbor
      } else {
        settleHelper(current.getLeftLowerNeighbor(), newBadger); // else the current badger has a
                                                                 // left neighbor, method makes
                                                                 // recursive call to itself to move
                                                                 // to the current badger's left
                                                                 // neighbor and check the
                                                                 // neighbor's neighbors
      }
    } else if (newBadger.getSize() > current.getSize()) { // if the new badger is larger than the
                                                          // current one
      if (current.getRightLowerNeighbor() == null) { // if the current badger does not have a right
                                                     // lower neighbor
        current.setRightLowerNeighbor(newBadger); // the new badger is made to be the current
                                                  // badgers right neighbor
      } else {
        settleHelper(current.getRightLowerNeighbor(), newBadger); // else the current badger has a
                                                                  // right neighbor, method makes a
                                                                  // recursive call to itself to
                                                                  // move to the current badger's
                                                                  // right neighbor and check the
                                                                  // neighbor's neighbors
      }
    } else { // else the desired badger to be inserted is currently in the sett (BST)
      throw new IllegalArgumentException("Warning: Duplicate Badger size, badger with size "
          + newBadger.getSize() + " already present.");
    }
  }

  /**
   * finds a Badger of a specified size
   * 
   * @param size desired size of badger to be found
   * @return returns the Badger of the input size if such a Badger is within the BST,
   * @throws NoSuchElementException exception is thrown when a Badger of specified size does not
   *                                exist within the Sett (BST)
   */
  public Badger findBadger(int size) throws NoSuchElementException {
    Badger badgerFound = findHelper(topBadger, size); // call the recursive method findHelper to
                                                      // search for the desired badger
    if (badgerFound == null) { // findHelper returns null if there is no current badger of the
                               // indicated size in the sett (BST)
      throw new NoSuchElementException(
          "Warning! Badger of size " + size + " was not found in the Sett.");
    } else {
      return badgerFound;
    }

  }

  /**
   * recursive helper which helps find a badger within the Sett (BST)
   * 
   * @param current the current Badger that is the root of a sub tree that we are searching for a
   *                Badger with the specified size within
   * 
   * @param size    the size of the Badger objects to search for and return
   * @return returns the badger found with the specified size
   * @throws NoSuchElementException exception is thrown if no such Badger of specified size is
   *                                contained within the Sett (BST)
   */
  private Badger findHelper(Badger current, int size) throws NoSuchElementException {
    if (current.getSize() == size) { // first check the current badgers size
      return current; // return the current badger if it is the desired size
    } else if (current.getSize() > size && current.getLeftLowerNeighbor() != null) { // searches the
                                                                                     // left path of
                                                                                     // the sett
                                                                                     // (BST)
      findHelper(current.getLeftLowerNeighbor(), size);
    } else if (current.getSize() < size && current.getRightLowerNeighbor() != null) { // searches
                                                                                      // the right
                                                                                      // path of the
                                                                                      // sett (BST)
      findHelper(current.getRightLowerNeighbor(), size);
    }

    return null;
  }

  /**
   * counts how many badger are currently in the Sett (BST)
   * 
   * @return the count of Badgers in the Sett (BST)
   */
  public int countBadger() {
    int numBadgers = 0; // intial count is zero

    if (topBadger != null) { // if there exists a topBadger than a call is made to the recursive
                             // method countHelper
      numBadgers = +countHelper(topBadger);
    }

    return numBadgers;
  }

  /**
   * recursive helper which is used to help count number of Badgers currently in the Sett (BST)
   * 
   * @param current
   * @return number of Badger living in the Sett rooted at the current Badger
   */
  private int countHelper(Badger current) {
    int rootNode = 1; // the current badger counts as 1
    int leftPath = 0; // assuming the current badger has no left neighbor
    int rightPath = 0; // assuming the current badger has no right neghbor

    if (current.getLeftLowerNeighbor() != null) { // checks the current badger's left neighbor
      leftPath += countHelper(current.getLeftLowerNeighbor()); // adds one to the count and
      rootNode += leftPath; // method
      // makes a call to itself with the
      // left neighbor passed in as the
      // badger
    }
    if (current.getRightLowerNeighbor() != null) { // checks the current badger's right
                                                   // neighbor
      rightPath += countHelper(current.getRightLowerNeighbor()); // adds one to the count and
      rootNode += rightPath; // method makes a call to itself with the right neighbor passed in as
                             // the badger
    }

    return rootNode;
  }

  /**
   * creates a list of all the badgers living in the Sett, sorted in ascending order based on size
   * with the smallest badger at the front and the largest Badger at the end of the list (index size
   * - 1)
   * 
   * @return the ordered list of all Badger currently living in the Sett (BST)
   */
  public java.util.List<Badger> getAllBadgers() {
    if (isEmpty() == true) { // first checks if the sett (BST) is empty
      return null;
    }

    ArrayList<Badger> allBadgers = new ArrayList<Badger>(); // creates new empty array list that
                                                            // will store all badgers in the sett
                                                            // currently
    getAllHelper(topBadger, allBadgers); // call to recrusrive method to sort array list allBadgers
    return allBadgers;
  }

  /**
   * recursive helper which helps collect the Badgers within the Sett into a list
   * 
   * @param current    the current Badger that is the root of a (sub) tree that we are collecting
   *                   all contained Badgers wihtin, into the allBadgers list
   * @param allBadgers the list of all Badgers living in the Sett (BST) that is rooted at the
   *                   current Badger node, list is in ascending order
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {


    if (current.getLeftLowerNeighbor() != null)
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);

    allBadgers.add(current);

    if (current.getLeftLowerNeighbor() != null)
      allBadgers.add(current);
  }

  /**
   * computes the height of the Sett (BST) as the number of nodes from the root to the deepest leaf
   * Badger node
   * 
   * @return the height/depth of the Sett (BST)
   */
  public int getHeight() {
    int height = 0;
    if (isEmpty() == true) { // check to see if the sett (BST) is empty
      return height; // height is zero if the sett (BST) is empty
    }
    height = getHeightHelper(topBadger); // call to the recursive method getHeightHelper
    return height;


  }

  /**
   * recursive helper which helps compute the height/depth of the Sett(BST)
   * 
   * @param current the current Badger is the root of a (sub) tree that we are calculating the
   *                height of
   * @return the height/depth of the (sub) tree we are calculating
   */
  private int getHeightHelper(Badger current) {
    int height = 1; // height is 1 to account for the root node
    int leftPath = 0; // initial assumption the current badger does not have a left neighbor
    int rightPath = 0; // initial assumption the current badger does not have a right neighbor

    if (current.getLeftLowerNeighbor() == null && current.getRightLowerNeighbor() == null) {
      return height; // the current badger has no neighbors
    }
    if (current.getLeftLowerNeighbor() != null) { // checks if the current badger has a left
                                                  // neighbor
      leftPath += getHeightHelper(current.getLeftLowerNeighbor()); // method makes a call to itself
                                                                   // to check the left neighbor's
                                                                   // neighbor
    }
    if (current.getRightLowerNeighbor() != null) { // checks if the current badger has a right
                                                   // neighbor
      rightPath += getHeightHelper(current.getRightLowerNeighbor()); // method makes a call to
                                                                     // itself to check the right
                                                                     // neighbor's neighbor
    }

    if (leftPath > rightPath) { // if the left path of the BST has a greater height
      return height + leftPath; // the height of the current BST is the root node to the last node
                                // on the left of the BST
    } else if (rightPath > leftPath) { // if the right path of the BST has a greater height
      return height + rightPath; // the height of the current BST is the root node to the last node
                                 // on the right of the BST
    } else { // each path of the BST has the same height

      return height + leftPath; // the root node plus the height of either path is correct
    }

  }


  /**
   * retrieves the largest Badger currently living in the Sett (BST)
   * 
   * @return
   */
  public Badger getLargestBadger() {
    if (isEmpty() == true) { // check to see if the sett (BST) is empty
      return topBadger;
    }
    while (topBadger.getRightLowerNeighbor() != null) { // sorts through the top badgers right
                                                        // (larger) neighbors until the last one is
                                                        // reached
      topBadger = topBadger.getRightLowerNeighbor(); // the largest badger is the last right
                                                     // neighbor in the BST
    }
    return topBadger;

  }

  /**
   * empties the Sett (BST) so no Badgers will be contained within the Sett (BST)
   * 
   */
  public void clear() {
    topBadger = null; // setting the topBadger to null clears the sett (BST)
  }
}
