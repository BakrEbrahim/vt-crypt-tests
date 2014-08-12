/*
  $Id: RipeMD256.java 2744 2013-06-25 20:20:29Z dfisher $

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
import org.bouncycastle.crypto.digests.RIPEMD256Digest;

/**
 * <p><code>RipeMD256</code> contains functions for hashing data using the
 * RipeMD256 algorithm. This algorithm outputs a 256 bit hash, but offers the
 * same level of security as RipeMD128.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public class RipeMD256 extends DigestAlgorithm
{

  /** Creates an uninitialized instance of an RipeMD256 digest. */
  public RipeMD256()
  {
    super(new RIPEMD256Digest());
  }


  /**
   * Creates a new RipeMD256 digest that may optionally be initialized with
   * random data.
   *
   * @param  randomize  True to randomize initial state of digest, false
   * otherwise.
   */
  public RipeMD256(final boolean randomize)
  {
    super(new RIPEMD256Digest());
    if (randomize) {
      setRandomProvider(new SecureRandom());
      setSalt(getRandomSalt());
    }
  }


  /**
   * Creates a new RipeMD256 digest and initializes it with the given salt.
   *
   * @param  salt  Salt data used to initialize digest computation.
   */
  public RipeMD256(final byte[] salt)
  {
    super(new RIPEMD256Digest());
    setSalt(salt);
  }
}
