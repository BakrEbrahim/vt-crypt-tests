/*
  $Id: X509CRLCredentialReader.java 2744 2013-06-25 20:20:29Z dfisher $

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
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import edu.vt.middleware.crypt.CryptException;

/**
 * Credential reader for handling X.509 CRLs. Both PEM and DER encoding of CRL
 * data is supported.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $ $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
 */
public class X509CRLCredentialReader
  extends AbstractX509CredentialReader<X509CRL>
{

  /** {@inheritDoc} */
  public X509CRL read(final InputStream in)
    throws IOException, CryptException
  {
    try {
      return (X509CRL) getX509CertificateFactory().generateCRL(in);
    } catch (CRLException e) {
      throw new CryptException("Failed reading X.509 CRL.", e);
    }
  }
}
