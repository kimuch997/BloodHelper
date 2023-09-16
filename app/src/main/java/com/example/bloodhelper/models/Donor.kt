package com.example.bloodhelper.models

class Donor {
    var name:String = ""
    var email:String = ""
    var bloodtype:String = ""
    var phonenumber: String = ""



    constructor(name: String, email: String,bloodtype: String,phonenumber:String) {
        this.name = name
        this.email = email
        this.bloodtype = bloodtype
        this.phonenumber = phonenumber
    }
    constructor()
}