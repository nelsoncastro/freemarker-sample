package com;

import com.config.ApplicationConfig;
import com.model.entity.Chargeback;
import com.model.service.ChargebackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class InterceptorTest {

    @Autowired
    private ChargebackService chargebackService;

    @Test
    public void interceptorTest() {
        Chargeback chargeback = new Chargeback(1L, "TIO PATINHAS", "0000000001",
                new BigDecimal(100), "BANCO TIO PATINHAS", "SOBRINHOS TIO PATINHAS");

        chargebackService.generateChargeback(chargeback);
    }
}
