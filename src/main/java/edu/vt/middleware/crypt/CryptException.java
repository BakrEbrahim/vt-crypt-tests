/*
  $Id: CryptException.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt;

/**
 * <p><code>CryptException</code> encapsulates the many exceptions that can
 * occur when working with the crypt libs.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */

public final class CryptException extends Exception
{

  /** CryptException.java. */
  private static final long serialVersionUID = -1041478966786912109L;


  /**
   * <p>This creates a new <code>CryptException</code>.</p>
   */
  public CryptException() {}


  /**
   * <p>This creates a new <code>CryptException</code> with the supplied
   * message.</p>
   *
   * @param  msg  <code>String</code>
   */
  public CryptException(final String msg)
  {
    super(msg);
  }


  /**
   * <p>This creates a new <code>CryptException</code> with the supplied cause.
   * </p>
   *
   * @param  cause  <code>Exception</code>
   */
  public CryptException(final Throwable cause)
  {
    super(cause);
  }


  /**
   * <p>This creates a new <code>CryptException</code> with the supplied message
   * and cause.</p>
   *
   * @param  msg  <code>String</code>
   * @param  cause  <code>Throwable</code>
   */
  public CryptException(final String msg, final Throwable cause)
  {
    super(msg, cause);
  }
}
