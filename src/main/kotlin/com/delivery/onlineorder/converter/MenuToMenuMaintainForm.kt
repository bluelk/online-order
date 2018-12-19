package com.delivery.onlineorder.converter

import com.delivery.onlineorder.form.MenuMaintainForm
import com.delivery.onlineorder.repository.Menu
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class MenuToMenuMaintainForm : Converter<Menu, MenuMaintainForm> {
	override fun convert(source: Menu): MenuMaintainForm? {
		val mealMaintainForm = MenuMaintainForm()
		val dishJson = source.dishes
		val drinkJson = source.drinks
		mealMaintainForm.menuId = source.menuId
		mealMaintainForm.dishJson = dishJson
		mealMaintainForm.drinkJson = drinkJson
		return mealMaintainForm
	}
}