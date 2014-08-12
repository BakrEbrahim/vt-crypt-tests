/*
  $Id: DistributionPointList.java 2744 2013-06-25 20:20:29Z dfisher $

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
 * Representation of the SEQUENCE of <code>DistributionPoint</code> types that
 * are the value of the <code>CRLDistributionPoints</code> extension field
 * described in section 4.2.1.14 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class DistributionPointList extends AbstractList<DistributionPoint>
{

  /**
   * Constructs a new instance from the given list of distribution points.
   *
   * @param  listOfDistPoints  List of distribution points.
   */
  public DistributionPointList(final List<DistributionPoint> listOfDistPoints)
  {
    if (listOfDistPoints == null) {
      throw new IllegalArgumentException(
        "List of distribution points cannot be null.");
    }
    items = listOfDistPoints.toArray(
      new DistributionPoint[listOfDistPoints.size()]);
  }


  /**
   * Constructs a new instance from the given array of distribution points.
   *
   * @param  arrayOfDistPoints  Array of distribution points.
   */
  public DistributionPointList(final DistributionPoint[] arrayOfDistPoints)
  {
    if (arrayOfDistPoints == null) {
      throw new IllegalArgumentException(
        "Array of distribution points cannot be null.");
    }
    items = arrayOfDistPoints;
  }
}
