/*
  $Id: Tiger.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.digest;

import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.TigerDigest;

/**
 * <p><code>Tiger</code> contains functions for hashing data using the Tiger
 * algorithm. This algorithm outputs a 192 bit hash.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public class Tiger extends DigestAlgorithm
{

  /** Creates an uninitialized instance of an Tiger digest. */
  public Tiger()
  {
    super(new TigerDigest());
  }


  /**
   * Creates a new Tiger digest that may optionally be initialized with random
   * data.
   *
   * @param  randomize  True to randomize initial state of digest, false
   * otherwise.
   */
  public Tiger(final boolean randomize)
  {
    super(new TigerDigest());
    if (randomize) {
      setRandomProvider(new SecureRandom());
      setSalt(getRandomSalt());
    }
  }


  /**
   * Creates a new Tiger digest and initializes it with the given salt.
   *
   * @param  salt  Salt data used to initialize digest computation.
   */
  public Tiger(final byte[] salt)
  {
    super(new TigerDigest());
    setSalt(salt);
  }
}
