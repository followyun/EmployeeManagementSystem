package com.my.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * ���������������Ǽ���û��Ƿ��е�½�����û�е�½����ת����½ҳ��
 * @author yun
 *
 */
public class UserLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�����û��Ƿ��½");
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			String result = arg0.invoke();
			return result;
		}
		
	return Action.LOGIN;
		
	}
	

	/*
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("�����û��Ƿ��½");
		if(ActionContext.getContext().getSession().get("existEmployee")!=null) {
			String result = arg0.invoke();
			return result;
		}
		
		return Action.LOGIN;
	}
	*/

}
