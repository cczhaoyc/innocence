package com.suxia.innocence.system.base.controller;

import com.suxia.innocence.system.base.constant.LoginConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:10 星期四
 * @description TODO 系统控制器
 */
@Controller
public class DefaultController {

	/**
	 * 登录页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "", "/", "/login" })
	public String login() {
		return LoginConstant.LOGIN;
	}

}
