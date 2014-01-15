package ru.jts.server.tests.crypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.jts.common.util.ArrayUtils;
import ru.jts.server.network.crypt.CryptEngine;

import java.security.Security;

/**
 * @author: Camelion
 * @date: 12.11.13/19:56
 */
public class CryptEngineTest {
    private byte[] in = new byte[]{
            (byte) 0x4d, (byte) 0x3f, (byte) 0x36, (byte) 0x81, (byte) 0xa1, (byte) 0xcc, (byte) 0x36, (byte) 0x74, (byte) 0x00, (byte) 0xdd, (byte) 0xee, (byte) 0xbc, (byte) 0xac, (byte) 0x1f, (byte) 0xd7, (byte) 0x39, (byte) 0x01, (byte) 0x33, (byte) 0xc6, (byte) 0xbb, (byte) 0x4b, (byte) 0xaf, (byte) 0xb9, (byte) 0x6b
    };
    private byte[] out = {
            (byte) 0x58, (byte) 0x04, (byte) 0x0E, (byte) 0xFE, (byte) 0x92, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x07, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF5, (byte) 0x5C, (byte) 0xCD, (byte) 0x22, (byte) 0xCF, (byte) 0xA6, (byte) 0x5C, (byte) 0xEF, (byte) 0xBE, (byte) 0xAD, (byte) 0xDE, (byte) 0x08
    };

    private byte[] key = new byte[]{
            (byte) 0xCF, (byte) 0x0E, (byte) 0x2F, (byte) 0xE1, (byte) 0x70, (byte) 0x02, (byte) 0xB5, (byte) 0x48, (byte) 0x87, (byte) 0xE0, (byte) 0xEA, (byte) 0x73, (byte) 0x4B, (byte) 0x3E, (byte) 0x14, (byte) 0xB2
    };

    @Before
    public void before() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void testXorBlowFish() {
        byte[] result = CryptEngine.getInstance().decrypt(in, key);

        Assert.assertArrayEquals(result, out);
    }
}
