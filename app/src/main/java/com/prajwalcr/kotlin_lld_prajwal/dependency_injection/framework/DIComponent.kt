package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework

abstract class DIComponent {
    val diContainer = DIContainer()

    abstract fun inject(target: Any)

    fun injectField(instance: Any) {
        val classReference = instance.javaClass

        classReference.declaredFields
            .filter { it.isAnnotationPresent(Inject::class.java) }
            .forEach { field->
                field.isAccessible = true
                val dependency = diContainer.getInstance(field.type)
                field.set(instance, dependency)
            }
    }
}
