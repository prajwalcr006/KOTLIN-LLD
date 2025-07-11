package com.prajwalcr.kotlin_lld_prajwal.builder

class Student(builder: StudentBuilder) {
    private val rollNumber: Int? = builder.rollNumber
    private val name: String? = builder.name
    private val age: Int? = builder.age
    private val phoneNumber: String? = builder.phoneNumber
    private val subjects: List<String>? = builder.subjects

    fun getRollNumber() = rollNumber
    fun getName() = name
    fun getAge() = age
    fun getPhoneNumber() = phoneNumber
    fun getSubjects() = subjects

    override fun toString(): String {
        return "Student(rollNumber=$rollNumber, name=$name, age=$age, phoneNumber=$phoneNumber, subjects=$subjects)"
    }
}