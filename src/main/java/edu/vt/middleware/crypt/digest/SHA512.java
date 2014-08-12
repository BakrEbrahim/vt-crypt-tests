/*
  $Id: SHA512.java 2744 2013-06-25 20:20:29Z dfisher $

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
import org.bouncycastle.crypto.digests.SHA512Digest;

/**
 * <p><code>SHA512</code> contains functions for hashing data using the SHA-512
 * algorithm. This algorithm outputs a 512 bit hash.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public class SHA512 extends DigestAlgorithm
{

  /** Creates an uninitialized instance of an SHA512 digest. */
  public SHA512()
  {
    super(new SHA512Digest());
  }


  /**
   * Creates a new SHA512 digest that may optionally be initialized with random
   * data.
   *
   * @param  randomize  True to randomize initial state of digest, false
   * otherwise.
   */
  public SHA512(final boolean randomize)
  {
    super(new SHA512Digest());
    if (randomize) {
      setRandomProvider(new SecureRandom());
      setSalt(getRandomSalt());
    }
  }


  /**
   * Creates a new SHA512 digest and initializes it with the given salt.
   *
   * @param  salt  Salt data used to initialize digest computation.
   */
  public SHA512(final byte[] salt)
  {
    super(new SHA512Digest());
    setSalt(salt);
  }
}
