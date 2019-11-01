//
//  DetallesViewController.swift
//  CarritoCompras
//
//  Created by Andrès Leal Giorguli on 8/7/19.
//  Copyright © 2019 Andrès Leal Giorguli. All rights reserved.
//

import UIKit

class DetallesViewController: UIViewController {
    
    var prod = Product(nombre: "", precio: 0.00, caracteristicas: "", imagen: UIImage(), compra: 0)
    var quantity = 0
    
    @IBOutlet weak var Imagen: UIImageView!
    @IBOutlet weak var Nombre: UILabel!
    @IBOutlet weak var descripcion: UITextView!
    @IBOutlet weak var precio: UILabel!
    
    @IBAction func cambiar(_ sender: Any) {
        let stepper = sender as! UIStepper
        stepper.maximumValue = 10
        quantity = Int(stepper.value)
        numero.text = "\(quantity)"
        precioTotal.text = "Precio Total: \(Double(quantity)*prod.precio)"

    }
    @IBAction func comprar(_ sender: Any) {
    }
    @IBOutlet weak var numero: UILabel!
    @IBOutlet weak var precioTotal: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        Imagen.image = prod.imagen
        Nombre.text = prod.nombre
        descripcion.text = prod.caracteristicas
        print(prod.caracteristicas)
        precio.text = "\(prod.precio)"
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let numero = quantity
        for num in 0 ..< (tablaProductos.count){
            if tablaProductos[num].nombre  == prod.nombre{
                tablaProductos[num].compra = tablaProductos[num].compra + numero
            }
        }
        
    }

}
