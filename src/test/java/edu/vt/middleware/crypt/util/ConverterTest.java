/*
  $Id: ConverterTest.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2007-2011 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for {@link Converter} class.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public class ConverterTest
{

  /** Data for testing. */
  private static final String CLEARTEXT =
    "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
    "Cras aliquet massa nec dui. Cras arcu nunc, hendrerit ac, eleifend eu, " +
    "ullamcorper nec, tellus. Sed pharetra purus sit amet quam. " +
    "Curabitur mollis.Nam vitae pede. Etiam risus massa, vehicula sit amet, " +
    "pharetra nec, sollicitudin ut, dui. Donec eg estas justo at quam. " +
    "Proin nisl risus, vestibulum nec, pretium vitae, tristi que ac, lorem. " +
    "Aliquam erat volutpat. Cras sed nibh. " +
    "Pellentesque sollicitud in euismod augue.";

  /** Logger instance. */
  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  /**
   * @return  Test data.
   *
   * @throws  Exception  On test data generation failure.
   */
  @DataProvider(name = "testdata")
  public Object[][] createTestData()
    throws Exception
  {
    return
      new Object[][] {
        {new Base64Converter()},
        {new HexConverter()},
        {new HexConverter(true)},
      };
  }


  /**
   * @param  converter  Converter to test.
   *
   * @throws  Exception  On test failure.
   */
  @Test(
    groups = {"functest", "util"},
    dataProvider = "testdata"
  )
  public void testConvert(final Converter converter)
    throws Exception
  {
    logger.info("Testing {}", converter);

    final String encoded = converter.fromBytes(CLEARTEXT.getBytes());
    logger.info("Produced encoded string:\n{}", encoded);

    final String text = new String(converter.toBytes(encoded), "UTF-8");
    AssertJUnit.assertEquals(CLEARTEXT, text);
  }
}
