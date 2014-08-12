/*
  $Id: PBKDF2KeyGenerator.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.pbe;

import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;

/**
 * Implements the PBKDF2 key generation function defined in PKCS#5v2.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class PBKDF2KeyGenerator extends AbstractPKCSKeyGenerator
{

  /**
   * Creates a new instance that uses SHA1 hash for pseudorandom function to
   * generate derived keys.
   *
   * @param  saltBytes  Key derivation function salt bytes.
   */
  public PBKDF2KeyGenerator(final byte[] saltBytes)
  {
    this(saltBytes, DEFAULT_ITERATION_COUNT);
  }


  /**
   * Creates a new instance that uses SHA1 hash for pseudorandom function to
   * generate derived keys.
   *
   * @param  saltBytes  Key derivation function salt bytes.
   * @param  iterations  Key derivation function iteration count.
   */
  public PBKDF2KeyGenerator(final byte[] saltBytes, final int iterations)
  {
    this.salt = saltBytes;
    setIterationCount(iterations);
  }


  /** {@inheritDoc} */
  protected PBEParametersGenerator newParamGenerator()
  {
    return new PKCS5S2ParametersGenerator();
  }


  /** {@inheritDoc} */
  protected byte[] toBytes(final char[] password)
  {
    return PBEParametersGenerator.PKCS5PasswordToBytes(password);
  }
}
