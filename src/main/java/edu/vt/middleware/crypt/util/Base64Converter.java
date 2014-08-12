/*
  $Id: Base64Converter.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.util;

import org.bouncycastle.util.encoders.Base64Encoder;
import org.bouncycastle.util.encoders.Encoder;

/**
 * Converts bytes to base-64 encoded strings and vice versa.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public class Base64Converter extends AbstractEncodingConverter
{

  /** Does encoding work. */
  private final Base64Encoder encoder = new Base64Encoder();


  /** {@inheritDoc} */
  protected Encoder getEncoder()
  {
    return encoder;
  }
}
