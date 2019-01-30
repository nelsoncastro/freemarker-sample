package com;

import com.model.entity.Chargeback;
import com.model.service.ChargebackService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class InterceptorTest {

    @Autowired
    private ChargebackService chargebackService;

    @Test
    public void interceptorTest() {
        Chargeback chargeback = new Chargeback.Builder("TIO PATINHAS", "0000000001",
                new BigDecimal(100), "BANCO TIO PATINHAS", "SOBRINHOS TIO PATINHAS",
                "tio.patinhas").build();

        chargeback = chargebackService.create(chargeback);
        Long expected = 1L;
        Assert.assertEquals(expected, chargeback.getId());
    }

    @Test(expected = AssertionError.class)
    public void interceptorNotCaptureTest() {
        Chargeback chargeback = new Chargeback.Builder(null, "0000000001",
                new BigDecimal(100), "BANCO TIO PATINHAS", "SOBRINHOS TIO PATINHAS",
                "tio.patinhas").build();

        chargeback = chargebackService.create(chargeback);
        Long expected = 1L;
        Assert.assertEquals(expected, chargeback.getId());
    }
}
