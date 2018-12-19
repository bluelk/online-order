package com.delivery.onlineorder.service

import com.delivery.onlineorder.converter.MenuMaintainFormToMenu
import com.delivery.onlineorder.converter.MenuToMenuMaintainForm
import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.repository.GroupOrder
import com.delivery.onlineorder.repository.GroupOrderRepository
import com.delivery.onlineorder.repository.Menu
import com.delivery.onlineorder.repository.MenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeliveryServiceImpl : DeliveryService {

	@Autowired
	private lateinit var groupOrderRepository: GroupOrderRepository

	@Autowired
	private lateinit var menuRepository: MenuRepository

	@Autowired
	private lateinit var menuToMenuMaintainForm: MenuToMenuMaintainForm

	@Autowired
	private lateinit var menuMaintainFormToMenu: MenuMaintainFormToMenu

	override fun findCurrentOrders(): List<GroupOrder> =ArrayList()
//			orderRepository.findByStatus(Status.CURRENT.value)


	override fun findPlacedOrders(): List<GroupOrder> =ArrayList()
//			orderRepository.findByStatus(Status.PLACED.value)


	override fun findMenus(): List<Menu> =
			menuRepository.findAll()

	override fun findMaintainFormByMenuId(menuId: Int?): MenuMaintainForm =
			menuId?.let { menuRepository.findById(it).orElse(null)?.let { menu -> menuToMenuMaintainForm.convert(menu) } } ?: MenuMaintainForm()

	override fun save(menuMaintainForm: MenuMaintainForm): Menu? =
			menuRepository.save(menuMaintainFormToMenu.convert(menuMaintainForm))
}