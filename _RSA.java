/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author admin
 */
public class _RSA {
    public  static final int VERSION=512;
    public static final BigInteger E=new BigInteger("65537"); //65537
    
    private BigInteger p,q,phiN,d;
    public BigInteger n;
    
    public void initialize(){
        p=BigInteger.probablePrime(VERSION/2, new Random());
        q=BigInteger.probablePrime(VERSION/2, new Random());

//        p=new BigInteger("23");
//        q=new BigInteger("17");

        n=p.multiply(q);
        phiN=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        d=E.modInverse(phiN);
        System.out.println("p="+p+"\n q="+q);
    }
    
    public BigInteger encrypt(BigInteger message, BigInteger partnerN){
        return message.modPow(E, partnerN);
    }
    public BigInteger decrypt( BigInteger cipher,BigInteger d,BigInteger n){
        return cipher.modPow(d, n);
    }
    public BigInteger getD(){
        return d;
    }
}
