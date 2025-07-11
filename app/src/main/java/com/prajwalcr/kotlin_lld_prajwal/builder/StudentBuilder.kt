package com.prajwalcr.kotlin_lld_prajwal.builder

class StudentBuilder {
    var rollNumber: Int? = null
    var name: String? = null
    var age: Int? = null
    var phoneNumber: String? = null
    var subjects: List<String>? = null

    fun setRollNumber(rollNumber: Int): StudentBuilder {
        this.rollNumber = rollNumber
        return this
    }

    fun setName(name: String): StudentBuilder {
        this.name = name
        return this
    }

    fun setAge(age: Int): StudentBuilder{
        this.age = age
        return this
    }

    fun setPhoneNumber(phoneNumber: String): StudentBuilder{
        this.phoneNumber = phoneNumber
        return this
    }

    fun setSubjects(subjects: List<String>): StudentBuilder{
        this.subjects = subjects
        return this
    }

    fun build(): Student {
        return Student(this)
    }
}