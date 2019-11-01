//
//  CarritoViewController.swift
//  CarritoCompras
//
//  Created by Andrès Leal Giorguli on 8/7/19.
//  Copyright © 2019 Andrès Leal Giorguli. All rights reserved.
//
import Foundation
import UIKit

class CarritoViewController: UIViewController{
    
    @IBOutlet weak var totalPrice: UILabel!
    
    var Compras = Producto(nombre: "", precio: 00.00, caracteristicas: "", imagen: UIImage())
    var num = 0
    var total = 0.00

    override func viewDidLoad() {
        super.viewDidLoad()
        for number in 0..<(tablaCarrito.count-1){
            if Compras.nombre != "" && Compras.nombre == tablaCarrito[number].prod.nombre{
                tablaCarrito[number].cantidad = num
            }
        }
        totalPrice.text = "\(total)"
        print(total)
    }
    
    func reloadData(_ tableView: UITableView){
        tableView.reloadData()
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 175
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tablaCarrito.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CarritoCell", for: indexPath)
        for number in 0..<(tablaCarrito.count-1){
            if tablaCarrito[number].cantidad != 0 && tablaCarrito[number].prod.nombre == Compras.nombre{
                cell.textLabel!.text = "\(tablaCarrito[number].prod.nombre)  \((tablaCarrito[number].prod.precio)*Double(tablaCarrito[number].cantidad)))"
                cell.imageView!.image = tablaCarrito[number].prod.imagen
                total = total + (tablaCarrito[number].prod.precio)*Double(tablaCarrito[number].cantidad)
            }
        }
        return cell
    }
}
