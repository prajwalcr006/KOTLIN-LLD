package com.prajwalcr.kotlin_lld_prajwal.facade

fun main() {
    val orderFacade = OrderFacade()

    for (i in 1..6) {
        orderFacade.addProduct("Pant", 100.0)
    }

    for (i in 1..5) {
        orderFacade.addProduct("Shirt", 50.0)
    }

    orderFacade.orderProduct("Prajwal", "Pant", 5, 10.0)

}