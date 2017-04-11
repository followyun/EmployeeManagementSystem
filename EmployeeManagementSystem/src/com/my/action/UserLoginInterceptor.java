package com.my.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 该拦截器的作用是检测用户是否有登陆，如果没有登陆则跳转到登陆页面
 * @author yun
 *
 */
public class UserLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截用户是否登陆");
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			String result = arg0.invoke();
			return result;
		}
		
	return Action.LOGIN;
		
	}
	

	/*
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截用户是否登陆");
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			String result = arg0.invoke();
			return result;
		}
		
		return Action.LOGIN;
	}
	*/

}
