package com.delivery.onlineorder.service

import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.repository.GroupOrder
import com.delivery.onlineorder.repository.Menu

interface DeliveryService {

	fun findCurrentOrders(): List<GroupOrder>

	fun findPlacedOrders(): List<GroupOrder>

	fun findMenus(): List<Menu>

	fun findMaintainFormByMenuId(menuId: Int?): MenuMaintainForm

	fun save(menuMaintainForm: MenuMaintainForm): Menu?
}