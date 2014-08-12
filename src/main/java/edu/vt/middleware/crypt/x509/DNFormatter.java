/*
  $Id: DNFormatter.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509;

import javax.security.auth.x500.X500Principal;

/**
 * Strategy pattern interface for producing a string representation of an X.500
 * distinguished name.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public interface DNFormatter
{


  /**
   * Produces a string representation of the given X.500 principal.
   *
   * @param  dn  Distinguished name as as X.500 principal.
   *
   * @return  String representation of DN.
   */
  String format(X500Principal dn);
}
