/*
  $Id: CAST5.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.symmetric;

/**
 * Provider of symmetric encryption/decryption operations using CAST5 cipher.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public class CAST5 extends SymmetricAlgorithm
{

  /** Algorithm name. */
  public static final String ALGORITHM = "CAST5";

  /** Available key lengths in bits. */
  public static final int[] KEY_LENGTHS = new int[] {
    128,
    120,
    112,
    104,
    96,
    88,
    80,
    72,
    64,
    56,
    48,
    40,
  };


  /**
   * Creates a default CAST5 symmetric encryption algorithm using CBC mode and
   * PKCS5 padding.
   */
  public CAST5()
  {
    this(DEFAULT_MODE, DEFAULT_PADDING);
  }


  /**
   * Creates a default CAST5 symmetric encryption algorithm using the given mode
   * and padding style.
   *
   * @param  mode  Cipher mode name.
   * @param  padding  Cipher padding style name.
   */
  public CAST5(final String mode, final String padding)
  {
    super(ALGORITHM, mode, padding);
  }


  /** {@inheritDoc} */
  public int[] getAllowedKeyLengths()
  {
    return KEY_LENGTHS;
  }
}
