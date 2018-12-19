package com.delivery.onlineorder.converter

import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.repository.Menu
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class MenuMaintainFormToMenu : Converter<MenuMaintainForm, Menu> {
	override fun convert(source: MenuMaintainForm): Menu {
		val menu = Menu()
		source.menuId?.apply {
			menu.menuId = this
		}
		menu.dishes = source.dishJson
		menu.drinks = source.drinkJson
		return menu
	}
}