package com.example.teste2

//classe que vai receber os dados do JSON
class Fruits {
    lateinit var name:String
    lateinit var image:String
    var price:Double = 0.0

    constructor(name: String,image:String,price:Double) {
        this.name = name
        this.image = image
        this.price = price
    }

    constructor()
}
