/*
  $Id: GeneralName.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

/**
 * Representation of the <code>GeneralName</code> type defined in section
 * 4.2.1.7 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public class GeneralName
{

  /** Hash code scale factor. */
  private static final int HASH_FACTOR = 31;

  /** Name. */
  private String name;

  /** Type of general name. */
  private GeneralNameType type;


  /**
   * Creates a new instance with the given name and type.
   *
   * @param  nameString  String representation of name.
   * @param  nameType  Type of general name.
   */
  public GeneralName(final String nameString, final GeneralNameType nameType)
  {
    if (nameString == null) {
      throw new IllegalArgumentException("Name cannot be null.");
    }
    name = nameString;
    type = nameType;
  }


  /** @return  String representation of name. */
  public String getName()
  {
    return name;
  }


  /** @return  Type of name. */
  public GeneralNameType getType()
  {
    return type;
  }


  /** @return  Value of {@link #getName()}. */
  @Override
  public String toString()
  {
    return name;
  }


  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object obj)
  {
    boolean result;
    if (obj == this) {
      result = true;
    } else if (obj == null || obj.getClass() != getClass()) {
      result = false;
    } else {
      final GeneralName other = (GeneralName) obj;
      result = other.getName().equals(name) && other.getType().equals(type);
    }
    return result;
  }


  /** {@inheritDoc} */
  @Override
  public int hashCode()
  {
    int hash = getClass().hashCode();
    hash = HASH_FACTOR * hash + type.ordinal();
    hash = HASH_FACTOR * hash + name.hashCode();
    return hash;
  }
}
