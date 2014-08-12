/*
  $Id: AbstractRandomizableAlgorithm.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt;

/**
 * Abstract base class for all algorithms that can be initialized with an
 * arbitrary amount of random data.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public abstract class AbstractRandomizableAlgorithm extends AbstractAlgorithm
  implements Randomizable
{

  /** Default number of random bytes. */
  private static final int DEFAULT_RANDOM_BYTE_SIZE = 256;

  /** Number of bytes used for random data needs. */
  protected int randomByteSize = DEFAULT_RANDOM_BYTE_SIZE;


  /**
   * Gets the number of random bytes used for calculations that need random
   * data.
   *
   * @return  Number of bytes of random data.
   */
  public int getRandomByteSize()
  {
    return this.randomByteSize;
  }


  /**
   * Sets the number of random bytes used for calculations that need random
   * data.
   *
   * @param  size  Number of bytes to obtain from random provider.
   */
  public void setRandomByteSize(final int size)
  {
    this.randomByteSize = size;
  }
}
