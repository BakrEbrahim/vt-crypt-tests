/*
  $Id: RSA.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.asymmetric;

/**
 * <p><code>RSA</code> contains functions for encrypting and decrypting using
 * the RSA algorithm. The encryption mode is set to 'NONE'. The padding is set
 * to 'OAEP'. This classes defaults to a key creation length of 2048 bits.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public class RSA extends AsymmetricAlgorithm
{

  /** Algorithm name. */
  public static final String ALGORITHM = "RSA";


  /**
   * Creates a default RSA asymmetric encryption algorithm that uses OAEP
   * padding.
   */
  public RSA()
  {
    super(ALGORITHM);
  }

}
