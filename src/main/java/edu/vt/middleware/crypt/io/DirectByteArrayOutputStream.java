/*
  $Id: DirectByteArrayOutputStream.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.io;

import java.io.ByteArrayOutputStream;

/**
 * Extends {@link java.io.ByteArrayOutputStream} by allowing direct access to
 * the internal byte buffer.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class DirectByteArrayOutputStream extends ByteArrayOutputStream
{

  /** Creates a new instance with a buffer of the default size. */
  public DirectByteArrayOutputStream()
  {
    super();
  }


  /**
   * Creates a new instance with a buffer of the given initial capacity.
   *
   * @param  capacity  Initial capacity of internal buffer.
   */
  public DirectByteArrayOutputStream(final int capacity)
  {
    super(capacity);
  }


  /**
   * Gets the internal byte buffer.
   *
   * @return  Internal buffer that holds written bytes.
   */
  public byte[] getBuffer()
  {
    return buf;
  }
}
