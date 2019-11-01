//
//  TiendaViewController.swift
//  CarritoCompras
//
//  Created by Andrès Leal Giorguli on 8/7/19.
//  Copyright © 2019 Andrès Leal Giorguli. All rights reserved.
//

import UIKit

class TiendaViewController: UIViewController, UITableViewDataSource, UITableViewDelegate{

    @IBOutlet weak var tabla: UITableView!
    @IBOutlet weak var Carrito: UIBarButtonItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 175
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ProductCell", for: indexPath)
        cell.textLabel!.text = tablaProductos[indexPath.row].nombre
        cell.imageView!.image = tablaProductos[indexPath.row].imagen
        return cell
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return tablaProductos.count
    }
        
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        let indexPath = tabla.indexPathForSelectedRow
        
        let secondView = segue.destination as? DetallesViewController
        secondView?.prod = tablaProductos[(indexPath?.row)!]
    }
    
}
