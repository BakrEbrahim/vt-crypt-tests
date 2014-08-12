/*
  $Id: EncryptPropertyTask.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.tasks;

import edu.vt.middleware.crypt.symmetric.SymmetricAlgorithm;
import edu.vt.middleware.crypt.util.Base64Converter;
import edu.vt.middleware.crypt.util.Convert;
import org.apache.tools.ant.BuildException;

/**
 * <p><code>EncryptPropertyTask</code> will encrypt an ant property using a
 * symmetric algorithm. Encrypted value will be BASE64 encoded.</p>
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public final class EncryptPropertyTask extends AbstractCryptTask
{

  /**
   * <p>See @link{org.apache.tools.ant.Task}.</p>
   */
  public void execute()
  {
    try {
      final SymmetricAlgorithm crypt = createAlgorithm();
      crypt.initEncrypt();

      final String propertyValue = this.getProject().getProperty(
        this.propertyName);
      final String encryptValue = crypt.encrypt(
        Convert.toBytes(propertyValue),
        new Base64Converter());
      this.getProject().setProperty(this.propertyName, encryptValue);
    } catch (Exception e) {
      e.printStackTrace();
      throw new BuildException(e);
    }
  }
}
