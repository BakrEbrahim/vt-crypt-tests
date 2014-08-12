/*
  $Id: Algorithm.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt;

import java.security.SecureRandom;

/**
 * Describes the basic behavior of all crytographic algorithms.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public interface Algorithm
{


  /**
   * Gets the algorithm name.
   *
   * @return  Algorithm name.
   */
  String getAlgorithm();


  /**
   * Sets the source of random data for cryptographic operations needing a
   * random data source, such as generating a random salt value.
   *
   * @param  random  Provider of cryptographically strong random data.
   */
  void setRandomProvider(final SecureRandom random);


  /**
   * Gets random bytes from the random provider of this instance in the amount
   * specified.
   *
   * @param  nBytes  Number of bytes of random data to retrieve.
   *
   * @return  Byte array of random data.
   */
  byte[] getRandomData(final int nBytes);
}
