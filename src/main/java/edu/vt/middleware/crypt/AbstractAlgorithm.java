/*
  $Id: AbstractAlgorithm.java 2745 2013-06-25 21:16:10Z dfisher $

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract cryptographic algorithm that is the basis of digest, encryption, and
 * signature algorithms.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public abstract class AbstractAlgorithm implements Algorithm
{

  /** Default number of random bytes. */
  private static final int DEFAULT_RANDOM_BYTE_SIZE = 256;

  /** Logger instance. */
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  /** Algorithm name. */
  protected String algorithm;

  /** Provider of secure random data. */
  protected SecureRandom randomProvider;

  /** Number of bytes used for random data needs. */
  protected int randomByteSize = DEFAULT_RANDOM_BYTE_SIZE;


  /** {@inheritDoc} */
  public String getAlgorithm()
  {
    return this.algorithm;
  }


  /** {@inheritDoc} */
  public void setRandomProvider(final SecureRandom random)
  {
    this.randomProvider = random;
  }


  /** {@inheritDoc} */
  public String toString()
  {
    return this.algorithm;
  }


  /** {@inheritDoc} */
  public byte[] getRandomData(final int nBytes)
  {
    if (this.randomProvider == null) {
      throw new IllegalStateException("No random provider available.");
    }

    final byte[] data = new byte[nBytes];
    randomProvider.nextBytes(data);
    return data;
  }
}
