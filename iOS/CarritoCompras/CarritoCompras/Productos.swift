//
//  Productos.swift
//  CarritoCompras
//
//  Created by Andrès Leal Giorguli on 8/7/19.
//  Copyright © 2019 Andrès Leal Giorguli. All rights reserved.
//

import Foundation
import UIKit

class Product {
    let nombre: String
    let precio: Double
    let caracteristicas: String
    let imagen: UIImage
    var compra: Int
    
    init(nombre: String, precio: Double, caracteristicas: String, imagen: UIImage, compra: Int){
        self.nombre = nombre
        self.precio = precio
        self.caracteristicas = caracteristicas
        self.imagen = imagen
        self.compra = compra
    }
}


var ventilador = Product(nombre: "Dyson Fan", precio: 1499.00, caracteristicas: "Potencia de 35W bladeless fan 8000r/min capacidad eólica 620l/s con control remoto funcion de temporizacion no abanico de hojas de plata (grey blue)", imagen: UIImage(imageLiteralResourceName: "ventilador"),compra: 0)

var audifonos = Product(nombre: "Audifonos Sony", precio: 849.99, caracteristicas: "EXTRA BASS para sonidos profundos y potentes, micrófono y control remoto integrados compatibles con smartphones", imagen: UIImage(imageLiteralResourceName: "audifonos"),compra: 0)

var tenis = Product(nombre: "Tenis Futbol Adidas", precio: 889.00, caracteristicas: "El exterior de piel sintética es liviano y resistente al desgaste, y se amolda al pie para garantizar un control total del balón.", imagen: UIImage(imageLiteralResourceName: "tenis"), compra: 0)

var  control = Product(nombre: "control", precio: 1098.00, caracteristicas: "Equípate con el control inalámbrico Xbox: Edición especial Sport Red, con un diseño rojo vibrante y detalles metálicos.", imagen: UIImage(imageLiteralResourceName: "control"), compra: 0)

var iphone = Product(nombre: "Iphone 8 Gold(refurbished", precio: 9459.00, caracteristicas: "El vidrio mas resistente usado en un smartphone, una carga inalambrica para un mundo sin cables, bocinas estereo. Mas potentes y con mayor rango dinamico.", imagen: UIImage(imageLiteralResourceName: "iphone"), compra: 0)

var tablaProductos: [Product] = [ventilador,audifonos,tenis,control,iphone]
