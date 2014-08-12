/*
  $Id: DSASignature.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import edu.vt.middleware.crypt.digest.DigestAlgorithm;
import edu.vt.middleware.crypt.digest.SHA1;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.signers.DSASigner;

/**
 * Implements the DSA signature algorithm.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class DSASignature extends AbstractDSASignature
{

  /** Signature algorithm name. */
  private static final String ALGORITHM = "DSA";


  /**
   * Creates a new DSA signature class that uses a SHA-1 for message digest
   * computation. This is the conventional DSA signature configuration.
   */
  public DSASignature()
  {
    this(new SHA1());
  }


  /**
   * Creates a new DSA signature class that uses the given digest algorithm for
   * message digest computation.
   *
   * @param  d  Message digest algorithm.
   */
  public DSASignature(final DigestAlgorithm d)
  {
    super(ALGORITHM);
    digest = d;
    signer = new DSASigner();
  }


  /** {@inheritDoc} */
  public void setSignKey(final PrivateKey key)
  {
    if (!DSAPrivateKey.class.isInstance(key)) {
      throw new IllegalArgumentException("DSA private key required.");
    }
    super.setSignKey(key);
  }


  /** {@inheritDoc} */
  public void setVerifyKey(final PublicKey key)
  {
    if (!DSAPublicKey.class.isInstance(key)) {
      throw new IllegalArgumentException("DSA public key required.");
    }
    super.setVerifyKey(key);
  }


  /** {@inheritDoc} */
  public void initSign()
  {
    if (signKey == null) {
      throw new IllegalStateException(
        "Sign key must be set prior to initialization.");
    }

    final DSAPrivateKey privKey = (DSAPrivateKey) signKey;
    final DSAParams params = privKey.getParams();
    final DSAPrivateKeyParameters bcParams = new DSAPrivateKeyParameters(
      privKey.getX(),
      new DSAParameters(params.getP(), params.getQ(), params.getG()));
    init(true, bcParams);
  }


  /** {@inheritDoc} */
  public void initVerify()
  {
    if (verifyKey == null) {
      throw new IllegalStateException(
        "Verify key must be set prior to initialization.");
    }

    final DSAPublicKey pubKey = (DSAPublicKey) verifyKey;
    final DSAParams params = pubKey.getParams();
    final DSAPublicKeyParameters bcParams = new DSAPublicKeyParameters(
      pubKey.getY(),
      new DSAParameters(params.getP(), params.getQ(), params.getG()));
    init(false, bcParams);
  }

}
