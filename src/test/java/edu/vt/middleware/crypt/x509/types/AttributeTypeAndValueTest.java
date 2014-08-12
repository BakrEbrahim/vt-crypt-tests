/*
  $Id: AttributeTypeAndValueTest.java 2744 2013-06-25 20:20:29Z dfisher $

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
 * Unit test for {@link AttributeTypeAndValue} class.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class AttributeTypeAndValueTest
{

  /**
   * @return  Certificate test data.
   *
   * @throws  Exception  On test data generation failure.
   */
  @DataProvider(name = "atvdata")
  public Object[][] createAttributeTypeAndValueTestData()
    throws Exception
  {
    return
      new Object[][] {
        {
          new AttributeTypeAndValue(
            AttributeType.CommonName,
            "Marvin S. Addison"),
          "CN=Marvin S. Addison",
        },
        {
          new AttributeTypeAndValue(
            AttributeType.OrganizationName,
            "Sue, Grabbit and Runn"),
          "O=Sue\\, Grabbit and Runn",
        },
        {
          new AttributeTypeAndValue(
            "3.1.4.1.5",
            " Apple, Cherry, and Mixed Berry! "),
          "3.1.4.1.5=\\ Apple\\, Cherry\\, and Mixed Berry!\\ ",
        },
      };
  }


  /**
   * @param  atv  Test value to perform toString() on.
   * @param  expected  Expected string value.
   */
  @Test(
    groups = {"functest", "x509"},
    dataProvider = "atvdata"
  )
  public void testToString(
    final AttributeTypeAndValue atv,
    final String expected)
  {
    AssertJUnit.assertEquals(atv.toString(), expected);
  }

}
