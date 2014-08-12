/*
  $Id: SecretKeyCredentialReader.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import edu.vt.middleware.crypt.CryptException;

/**
 * Reads symmetric algorithm secret keys.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class SecretKeyCredentialReader implements CredentialReader<SecretKey>
{

  /** Secret key algorithm. */
  private final String algorithm;


  /**
   * Creates a new instance that can read keys for the given symmetric cipher
   * algorithm.
   *
   * @param  cipherAlgorithm  Cipher algorithm name, e.g. AES.
   */
  public SecretKeyCredentialReader(final String cipherAlgorithm)
  {
    this.algorithm = cipherAlgorithm;
  }


  /** {@inheritDoc} */
  public SecretKey read(final File file)
    throws IOException, CryptException
  {
    final byte[] data = IOHelper.read(new FileInputStream(file).getChannel());
    try {
      return new SecretKeySpec(data, algorithm);
    } catch (Exception e) {
      throw new CryptException("Invalid key format.", e);
    }
  }


  /** {@inheritDoc} */
  public SecretKey read(final InputStream in)
    throws IOException, CryptException
  {
    final byte[] data = IOHelper.read(in);
    try {
      return new SecretKeySpec(data, algorithm);
    } catch (Exception e) {
      throw new CryptException("Invalid key format.", e);
    }
  }

}
