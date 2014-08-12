/*
  $Id: AlgorithmSpec.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.symmetric;

/**
 * Describes a symmetric cipher algorithm in terms of a (name, mode, padding)
 * tuple.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class AlgorithmSpec
{

  /** Cipher algorithm name. */
  private String name;

  /** Cipher mode, e.g. CBC, OFB. */
  private String mode;

  /** Cipher padding scheme, e.g. PKCS5Padding. */
  private String padding;


  /**
   * Creates a new instance for the given cipher algorithm name.
   *
   * @param  algorithm  Cipher algorithm name.
   */
  public AlgorithmSpec(final String algorithm)
  {
    this.name = algorithm;
  }


  /**
   * Creates a new instance for the given cipher algorithm name.
   *
   * @param  algorithm  Cipher algorithm name.
   * @param  cipherMode  Cipher mode.
   * @param  cipherPadding  Cipher padding scheme name.
   */
  public AlgorithmSpec(
    final String algorithm,
    final String cipherMode,
    final String cipherPadding)
  {
    this.name = algorithm;
    this.mode = cipherMode;
    this.padding = cipherPadding;
  }


  /**
   * Gets the cipher algorithm name.
   *
   * @return  Algorithm name.
   */
  public String getName()
  {
    return name;
  }


  /**
   * Gets the cipher mode.
   *
   * @return  Cipher mode, e.g. CBC, OFB.
   */
  public String getMode()
  {
    return mode;
  }


  /**
   * Gets the cipher padding scheme.
   *
   * @return  Padding scheme name, e.g. PKCS5Padding.
   */
  public String getPadding()
  {
    return padding;
  }
}
