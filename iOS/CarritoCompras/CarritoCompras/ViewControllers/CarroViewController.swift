//
//  CarroViewController.swift
//  CarritoCompras
//
//  Created by Andrès Leal Giorguli on 8/8/19.
//  Copyright © 2019 Andrès Leal Giorguli. All rights reserved.
//

import UIKit
import Foundation

class CarroViewController: UIViewController, UITableViewDataSource, UITableViewDelegate{
    
    @IBAction func pagar(_ sender: UIButton) {
    }
    @IBOutlet weak var tablaCarrito: UITableView!
    @IBOutlet weak var total: UILabel!
    
    var totalp = 0.00
    
    override func viewDidLoad() {
        super.viewDidLoad()
        for num in 0..<(tablaProductos.count){
            totalp = totalp + (Double(tablaProductos[num].compra)*(tablaProductos[num].precio))
        }
        total.text = "\(totalp)"
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tablaProductos.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CarritoCell", for: indexPath)
            if tablaProductos[indexPath.row].compra != 0 {
                cell.textLabel?.text = "\(tablaProductos[indexPath.row].compra):  $\(tablaProductos[indexPath.row].nombre) \((tablaProductos[indexPath.row].precio)*Double(tablaProductos[indexPath.row].compra))"
                cell.imageView?.image = tablaProductos[indexPath.row].imagen
                tablaCarrito.rowHeight = 120
            }
            else{
                tablaCarrito.rowHeight = 0
        }
        return cell
    }
    
}
