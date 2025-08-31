package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework

import java.util.concurrent.ConcurrentHashMap

class DIContainer {
    private val bindingMap = ConcurrentHashMap<Class<*>, Binding<*>>()
    private val singleTonClass = ConcurrentHashMap<Class<*>, Any>()

    private val moduleList: MutableList<Any> = mutableListOf()

    fun<T> bind(
        type: Class<T>,
        scope: Scope,
        provider: () -> T
    ) {
        bindingMap[type] = Binding(type,scope,provider)
    }

    fun<T> getInstance(classType: Class<T>): T {
        val binding = bindingMap[classType] ?: throw Exception("No binding found for $classType!!")

        return when(binding.scope) {
            Scope.SingleTon -> {
                singleTonClass.getOrPut(classType) {
                    binding.provider.invoke()
                } as T
            }
            Scope.Factory -> {
                binding.provider.invoke() as T
            }
        }
    }

    fun<T> createInstance(classType: Class<T>): T {
        val constructors = classType.declaredConstructors

        val injectedConstructor = constructors.find { it.isAnnotationPresent(Inject::class.java) }
            ?: constructors.firstOrNull {it.parameterCount == 0}
            ?: constructors.first()

        val parameters = injectedConstructor.parameterTypes.map {
            getInstance(it)
        }.toTypedArray()

        val instance = injectedConstructor.newInstance(*parameters)

        performFieldInjection(instance)

        return instance as T
    }

    fun installModule(module: Any) {
        moduleList.add(module)
        parseModule(module)
    }

    private fun parseModule(moduleClass: Any) {
        val module = moduleClass.javaClass
        if (!module.isAnnotationPresent(Module::class.java)) throw Exception("Not a Module Class")

        moduleList.add(module)

        module.declaredMethods
            .filter { it.isAnnotationPresent(Provides::class.java) }
            .forEach { method ->
                val type = method.returnType as Class<Any>
                val scope = if (method.isAnnotationPresent(SingleTon::class.java)) {
                    Scope.SingleTon
                } else {
                    Scope.Factory
                }

                bind(type, scope) {
                    val parameters = method.parameterTypes.map { paramType ->
                        getInstance(paramType)  // Recursively get dependencies
                    }.toTypedArray()

                    method.isAccessible = true
                    val result = method.invoke(moduleClass, *parameters)

                    result ?: throw IllegalStateException("@Provides method ${method.name} returned null")
                }
            }
    }

    fun performFieldInjection(instance: Any) {
        val classReference = instance.javaClass

        classReference.declaredFields
            .filter { it.isAnnotationPresent(Inject::class.java) }
            .forEach { field->
                field.isAccessible = true
                val dependency = getInstance(field.type)
                field.set(instance, dependency)
            }
    }
}