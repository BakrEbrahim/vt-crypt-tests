/*
  $Id: AbstractVariableKeySizeEncryptionScheme.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.pbe;

import javax.crypto.spec.SecretKeySpec;

/**
 * Base class for all encryption schemes that use a variable-length key to
 * perform encryption, e.g. the PBES2 encryption scheme described in PKCS#5v2
 * and the PKCS#12 PBE scheme.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public abstract class AbstractVariableKeySizeEncryptionScheme
  extends AbstractEncryptionScheme
{

  /** Key generator. */
  private KeyGenerator generator;

  /** Size of derived key in bits. */
  private int keyLength;


  /**
   * Sets the derived key length in bits.
   *
   * @param  l  Derived key length in bits.
   */
  protected void setKeyLength(final int l)
  {
    if (l < 1) {
      throw new IllegalArgumentException(
        "Derived key length must be positive integer.");
    }
    this.keyLength = l;
  }


  /**
   * Sets the key generator.
   *
   * @param  keyGen  Key generator instance.
   */
  protected void setGenerator(final KeyGenerator keyGen)
  {
    if (keyGen == null) {
      throw new IllegalArgumentException("Key generator cannot be null.");
    }
    this.generator = keyGen;
  }


  /**
   * Initializes the cipher with the given PBE derived key bytes.
   *
   * @param  password  PBE password.
   */
  protected void initCipher(final char[] password)
  {
    final byte[] key = generator.generate(password, keyLength);
    cipher.setKey(new SecretKeySpec(key, cipher.getAlgorithm()));
    if ("CBC".equals(cipher.getMode()) && !cipher.hasIV()) {
      // Generate an IV from the password
      cipher.setIV(generator.generate(password, cipher.getBlockSize() * 8));
    }
  }
}
