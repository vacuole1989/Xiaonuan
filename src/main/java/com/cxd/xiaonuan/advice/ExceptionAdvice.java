package com.cxd.xiaonuan.advice;

import com.cxd.xiaonuan.dto.ResponseJSON;
import com.cxd.xiaonuan.exception.BizException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ws03089
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static Log LOG = LogFactory.getLog(ExceptionAdvice.class);

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object processException(BizException e) {
        String msg = e.getMessage();
        LOG.error(msg);
        e.printStackTrace();
        return new ResponseJSON(msg,msg,null,HttpStatus.BAD_REQUEST.value(),System.currentTimeMillis());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object handleException(Exception ex) {
        String msg = ex.getMessage();
        LOG.error(msg);
        ex.printStackTrace();
        return new ResponseJSON(msg,msg,null,HttpStatus.INTERNAL_SERVER_ERROR.value(),System.currentTimeMillis());
    }

}
