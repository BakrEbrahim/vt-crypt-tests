/*
  $Id: PKCS12EncryptionScheme.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.pbe;

import edu.vt.middleware.crypt.digest.DigestAlgorithm;
import edu.vt.middleware.crypt.pkcs.PBEParameter;
import edu.vt.middleware.crypt.symmetric.SymmetricAlgorithm;

/**
 * Implements the password-based encryption scheme in section B of PKCS#12.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class PKCS12EncryptionScheme
  extends AbstractVariableKeySizeEncryptionScheme
{

  /**
   * Creates a new instance with the given parameters.
   *
   * @param  alg  Symmetric cipher algorithm used for encryption/decryption.
   * @param  digest  Digest algorithm used for PBE pseudorandom function.
   * @param  params  Key generation function salt and iteration count.
   * @param  keyBitLength  Size of derived keys in bits.
   */
  public PKCS12EncryptionScheme(
    final SymmetricAlgorithm alg,
    final DigestAlgorithm digest,
    final PBEParameter params,
    final int keyBitLength)
  {
    setCipher(alg);
    setGenerator(
      new PKCS12KeyGenerator(
        digest,
        params.getSalt(),
        params.getIterationCount()));
    setKeyLength(keyBitLength);
  }
}
