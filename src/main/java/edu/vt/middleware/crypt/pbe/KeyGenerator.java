/*
  $Id: KeyGenerator.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.pbe;

/**
 * Generates secret keys from passwords for password-based encryption schemes.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public interface KeyGenerator
{

  /**
   * Generates a symmetric key from a password for use in password-based
   * encryption schemes.
   *
   * @param  password  Password used as basis for generated key.
   * @param  size  Size of generated key in bits, unless otherwise noted.
   *
   * @return  Secret key bytes.
   */
  byte[] generate(char[] password, int size);
}
