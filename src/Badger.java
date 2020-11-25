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

/**
 * 
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a BST (known as a Sett)
 *
 * @author Dante Pizzini, Joseph Cambio
 *
 */
public class Badger {

  private Badger leftLowerNeighbor; // the badger object's lower left neighbor in the BST
  private Badger rightLowerNeighbor; // the badger object's lower right neighbor in the BST
  private final int size; // the size of the badger

  /**
   * constructor for the badger class, creates new badger object of specified size
   * 
   * @param size the desired size of the badger object
   */
  public Badger(int size) {
    this.size = size; // set the desired size of the badger

  }

  /**
   * retrieves the neighboring badger that is smaller than the current one
   * 
   * @return left neighbor below current badger (smaller neighbor)
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor; // the current badger node's left neighbor, has a smaller size than
                              // the current badger
  }

  /**
   * Changes this badger's lower left neighbor to the desired one
   * 
   * @param badger the lower left neihgbor to be assigned to this badger
   */
  public void setLeftLowerNeighbor(Badger badger) {
    leftLowerNeighbor = badger; // the new badger is passed in to be the new neighbor
  }

  /**
   * retrieves the neighboring badger that is larger than the current one
   * 
   * @return right lower badger (larger than the current badger)
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor; // the current badger node's right neighbor, has a larger size than
                               // the current badger
  }

  /**
   * changes the current badgers lower right neighbor to the desired one
   * 
   * @param badger lower right neighbor to be assigned to the current badger
   */
  public void setRightLowerNeighbor(Badger badger) {
    rightLowerNeighbor = badger; // the new badger is passed in to be the new neighbor()
  }

  /**
   * retrieves the size of this badger object
   * 
   * @return size
   */
  public int getSize() {
    return this.size; // the current badgers size
  }

}
