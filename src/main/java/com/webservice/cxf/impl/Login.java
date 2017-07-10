package com.webservice.cxf.impl;

import com.webservice.cxf.ILogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2017/5/3.
 */
@Component("login")
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Login implements ILogin {
    private static Logger logger = LoggerFactory.getLogger(Login.class);
    public String loginIn(@WebParam(name="userName") String userName, @WebParam(name="password") String password, @WebParam(name="ext") String ext) {
        logger.debug("loginIn:" +userName );
        logger.info("loginIn:" +userName );
        return userName;
    }

    public String loginOut(@WebParam(name="userName") String userName) {
        logger.debug("loginOut:" +userName );
        logger.info("loginOut:" +userName );
        return userName;
    }

    public String loginCheck(@WebParam(name="userName") String userName) {
        logger.debug("loginCheck:" +userName );
        logger.info("loginCheck:" +userName );
        return userName;
    }
}
