/*
  $Id: Converter.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.util;

/**
 * Interface describing conversion of bytes to string and vice versa.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public interface Converter
{

  /**
   * Converts a byte array to a formatted/encoded string.
   *
   * @param  input  Input bytes.
   *
   * @return  Formatted/encoded string derived from input bytes.
   */
  String fromBytes(byte[] input);


  /**
   * Converts a byte array to a formatted/encoded string.
   *
   * @param  input  Input bytes.
   * @param  offset  Offset into input bytes at which to begin processing.
   * @param  length  Number of bytes of input data to process.
   *
   * @return  Formatted/encoded string derived from input bytes.
   */
  String fromBytes(byte[] input, int offset, int length);


  /**
   * Converts a formatted/encoded string to raw bytes.
   *
   * @param  input  Formatted/encoded input string.
   *
   * @return  Byte array corresponding to input string.
   */
  byte[] toBytes(String input);
}
