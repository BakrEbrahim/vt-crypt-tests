/*
  $Id: RelativeDistinguishedNameTest.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2007-2011 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for {@link RelativeDistinguishedName} class.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class RelativeDistinguishedNameTest
{

  /**
   * @return  RDN test data.
   *
   * @throws  Exception  On test data generation failure.
   */
  @DataProvider(name = "rdndata")
  public Object[][] createRDNTestData()
    throws Exception
  {
    return
      new Object[][] {
        {
          new RelativeDistinguishedName(
            new AttributeTypeAndValue(AttributeType.DomainComponent, "vt")),
          "DC=vt",
        },
        {
          new RelativeDistinguishedName(
            new AttributeTypeAndValue[] {
              new AttributeTypeAndValue(
                AttributeType.OrganizationalUnitName,
                "Sales"),
              new AttributeTypeAndValue(AttributeType.CommonName, "J. Smith"),
            }),
          "OU=Sales+CN=J. Smith",
        },
      };
  }


  /**
   * @param  rdn  Test value to perform toString() on.
   * @param  expected  Expected string value.
   */
  @Test(
    groups = {"functest", "x509"},
    dataProvider = "rdndata"
  )
  public void testToString(
    final RelativeDistinguishedName rdn,
    final String expected)
  {
    AssertJUnit.assertEquals(rdn.toString(), expected);
  }

}
