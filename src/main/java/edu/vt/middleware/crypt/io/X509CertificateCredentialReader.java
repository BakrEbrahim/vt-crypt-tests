/*
  $Id: X509CertificateCredentialReader.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.io;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import edu.vt.middleware.crypt.CryptException;

/**
 * Reads X.509 certificates from encoded representation. Both PEM and DER
 * encodings are supported.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class X509CertificateCredentialReader
  extends AbstractX509CredentialReader<X509Certificate>
{

  /** {@inheritDoc} */
  public X509Certificate read(final InputStream in)
    throws IOException, CryptException
  {
    try {
      return
        (X509Certificate) getX509CertificateFactory().generateCertificate(in);
    } catch (CertificateException e) {
      throw new CryptException("Failed reading X.509 certificate.", e);
    }
  }
}
