package com.webservice.cxf.impl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.wang.core.helper.DatabaseHelper;
import com.webservice.cxf.ILogin;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/5/4.
 */
public class LoginTest {
    @Before
    public void init() throws Exception{
        String file="sql/customer_init.sql";
        InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String sql;
        while((sql=reader.readLine())!=null){
            DatabaseHelper.executeUpdate(sql);
        }
    }

    @Test
    public void getTextTest(){
        //调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ILogin.class);
        factory.setAddress("http://localhost:8080/heag/webservice/userLogin");
        ILogin iLogin = (ILogin) factory.create();
        System.out.println("#############Client getUserByName##############");
        String user = iLogin.loginOut("wangnan");
        System.out.println(user);
    }
}
