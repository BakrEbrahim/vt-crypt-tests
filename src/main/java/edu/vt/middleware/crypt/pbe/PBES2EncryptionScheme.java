/*
  $Id: PBES2EncryptionScheme.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.pbe;

import edu.vt.middleware.crypt.pkcs.PBKDF2Parameters;
import edu.vt.middleware.crypt.symmetric.SymmetricAlgorithm;

/**
 * Implements the PBES2 encryption scheme defined in PKCS#5v2.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class PBES2EncryptionScheme
  extends AbstractVariableKeySizeEncryptionScheme
{

  /**
   * Creates a new instance with the given parameters.
   *
   * @param  alg  Symmetric cipher algorithm used for encryption/decryption. The
   * cipher is expected to be initialized with whatever initialization data is
   * required for encryption/decryption, e.g. initialization vector.
   * @param  params  Container for required salt, iterations, and key length.
   */
  public PBES2EncryptionScheme(
    final SymmetricAlgorithm alg,
    final PBKDF2Parameters params)
  {
    setCipher(alg);
    setGenerator(
      new PBKDF2KeyGenerator(params.getSalt(), params.getIterationCount()));
    setKeyLength(params.getLength() * 8);
  }
}
