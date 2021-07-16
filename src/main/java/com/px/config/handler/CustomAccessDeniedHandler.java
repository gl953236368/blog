package com.px.config.handler;

import com.px.utils.JsonResult;
import com.px.utils.ResultCode;
import com.px.utils.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.alibaba.fastjson.JSON;

// AccessDeniedException权限异常捕获,CustomAccessDeniedHandler
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        JsonResult fail = ResultTool.fail(ResultCode.NO_PERMISSION);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(JSON.toJSONString(fail));
    }
}
