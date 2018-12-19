package com.delivery.onlineorder.form

data class MenuMaintainForm(var menuId: Int? = null,
							var dishJson: String? = null,
							var drinkJson: String? = null,
							var type: Int? = null)