/*
  $Id: CredentialReader.java 2744 2013-06-25 20:20:29Z dfisher $

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
import java.io.IOException;
import java.io.InputStream;
import edu.vt.middleware.crypt.CryptException;

/**
 * Reads a security credential (e.g. key, certificate) from a resource.
 *
 * @param  <T>  Type of credential to read.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public interface CredentialReader<T>
{

  /**
   * Reads a credential, commonly in encoded format, from the given file.
   *
   * @param  file  File from which to read credential.
   *
   * @return  Credential read from file.
   *
   * @throws  IOException  On IO exceptions.
   * @throws  CryptException  On cryptography errors such as invalid formats,
   * unsupported ciphers, illegal settings.
   */
  T read(File file)
    throws IOException, CryptException;


  /**
   * Reads a credential, commonly in encoded format, from the given input
   * stream.
   *
   * @param  in  Input stream from which to read credential.
   *
   * @return  Credential read from input stream.
   *
   * @throws  IOException  On IO exceptions.
   * @throws  CryptException  On cryptography errors such as invalid formats,
   * unsupported ciphers, illegal settings.
   */
  T read(InputStream in)
    throws IOException, CryptException;
}
