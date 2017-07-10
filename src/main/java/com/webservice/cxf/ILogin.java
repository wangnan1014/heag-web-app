package com.webservice.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2017/5/3.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ILogin {
    String loginIn(@WebParam(name="userName") String userName, @WebParam(name="password") String password, @WebParam(name="ext") String ext);
    String loginOut(@WebParam(name="userName") String userName);
    String loginCheck(@WebParam(name="userName") String userName);
}
