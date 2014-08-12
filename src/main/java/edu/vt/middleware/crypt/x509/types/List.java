/*
  $Id: List.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

/**
 * Interface describing a type that is simply a collection of other types.
 *
 * @param  <T>  Type of object contained in collection.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public interface List<T>
{

  /** @return  Array of items in the collection. */
  T[] getItems();
}
