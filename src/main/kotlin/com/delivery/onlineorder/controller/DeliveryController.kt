package com.delivery.onlineorder.controller

import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["admin/delivery"])
class DeliveryController {

	@Autowired
	private lateinit var deliveryService: DeliveryService

	@RequestMapping(method = [RequestMethod.GET])
	fun list(): ModelAndView {
		val mav = ModelAndView("backend/delivery/list")
		mav.addObject("menus", deliveryService.findMenus())
		return mav
	}

	@RequestMapping(value = ["create", "edit/{menuId}"], method = [RequestMethod.GET])
	fun editGet(@ModelAttribute("maintainForm") menuMaintainForm: MenuMaintainForm,
				@PathVariable("menuId") menuId: Int?): ModelAndView {
		val mav = ModelAndView("backend/delivery/edit")
		mav.addObject("menus", deliveryService.findMaintainFormByMenuId(menuId))
		return mav
	}

	@RequestMapping(value = ["create", "edit"], method = [RequestMethod.POST])
	fun editSave(@ModelAttribute("maintainForm") menuMaintainForm: MenuMaintainForm): ModelAndView {
		val mav = ModelAndView("backend/delivery/edit")
		deliveryService.save(menuMaintainForm)
		return mav
	}
}