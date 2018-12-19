package com.delivery.onlineorder.controller

import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["delivery"])
class FrontendDeliveryController {

	@Autowired
	private lateinit var deliveryService : DeliveryService

	@RequestMapping(method = [RequestMethod.GET])
	fun index(): ModelAndView {
		val mav = ModelAndView("frontend/delivery/index")
		mav.addObject("currentOrders", deliveryService.findCurrentOrders())
		mav.addObject("placedOrders", deliveryService.findPlacedOrders())
		return mav
	}

	@RequestMapping(value = ["order"], method = [RequestMethod.GET])
	fun order(@ModelAttribute("maintainForm") menuMaintainForm: MenuMaintainForm): ModelAndView {
		val mav = ModelAndView("frontend/delivery/order")
		mav.addObject("menus", deliveryService.findMenus())
		mav.addObject("placedOrders", deliveryService.findPlacedOrders())
		return mav
	}
}