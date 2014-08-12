/*
  $Id: PolicyInformationList.java 2744 2013-06-25 20:20:29Z dfisher $

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
 * Stores a list of {@link PolicyInformation} objects that could represent the
 * data in the <code>CertificatePolicies</code> extension field defined in
 * section 4.2.1.5 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class PolicyInformationList extends AbstractList<PolicyInformation>
{

  /**
   * Constructs a new instance from the given list of policies.
   *
   * @param  listOfPolicies  List of certificate policies.
   */
  public PolicyInformationList(final List<PolicyInformation> listOfPolicies)
  {
    if (listOfPolicies == null) {
      throw new IllegalArgumentException("List of policies cannot be null.");
    }
    items = listOfPolicies.toArray(
      new PolicyInformation[listOfPolicies.size()]);
  }


  /**
   * Constructs a new instance from the given array of policies.
   *
   * @param  arrayOfPolicies  Array of policies.
   */
  public PolicyInformationList(final PolicyInformation[] arrayOfPolicies)
  {
    if (arrayOfPolicies == null) {
      throw new IllegalArgumentException("Array of policies cannot be null.");
    }
    items = arrayOfPolicies;
  }
}
