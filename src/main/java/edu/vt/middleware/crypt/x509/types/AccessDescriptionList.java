/*
  $Id: AccessDescriptionList.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

import java.util.List;

/**
 * Representation of the SEQUENCE of <code>AccessDescription</code> types that
 * is the value of the <code>AuthorityInformationAccess</code> extension field
 * defined in section 4.2.2.1 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class AccessDescriptionList extends AbstractList<AccessDescription>
{

  /**
   * Constructs a new instance from the given list of access descriptions.
   *
   * @param  listOfAccessDescriptions  List of access descriptions.
   */
  public AccessDescriptionList(
    final List<AccessDescription> listOfAccessDescriptions)
  {
    if (listOfAccessDescriptions == null) {
      throw new IllegalArgumentException(
        "List of access descriptions cannot be null.");
    }
    items = listOfAccessDescriptions.toArray(
      new AccessDescription[listOfAccessDescriptions.size()]);
  }


  /**
   * Constructs a new instance from the given array of access descriptions.
   *
   * @param  arrayOfAccessDescriptions  Array of access descriptions.
   */
  public AccessDescriptionList(
    final AccessDescription[] arrayOfAccessDescriptions)
  {
    if (arrayOfAccessDescriptions == null) {
      throw new IllegalArgumentException(
        "Array of access descriptions cannot be null.");
    }
    items = arrayOfAccessDescriptions;
  }
}
