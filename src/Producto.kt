open class Producto {

    var codigo: String
    var nombre: String
    var precio: Double
    var cantidadStock: Int


    constructor(codigo: String, nombre: String, precio: Double, cantidadStock: Int) {
        this.codigo = codigo
        this.nombre = nombre
        this.precio = precio
        this.cantidadStock = cantidadStock
    }

    fun vender(cantidad: Int): Boolean {
        if (cantidadStock >= cantidad) {
            cantidadStock = cantidadStock - cantidad
            return true
        } else {
            println("No hay suficiente stock disponible para " + nombre)
            return false
        }
    }


    fun reponerStock(cantidad: Int) {
        if (cantidad > 0) {
            cantidadStock = cantidadStock + cantidad
            println("Se han añadido " + cantidad + " unidades de " + nombre)
        } else {
            println("La cantidad a reponer debe ser mayor que cero")
        }
    }


    fun aplicarDescuento() {
        precio = precio - (precio * 0.02)
        println("Se ha aplicado con exito un descuento del 2% al producto " + nombre)
    }

    fun mostrarInformacion() {
        println("Código: " + codigo)
        println("Nombre: " + nombre)
        println("Precio: $" + precio)
        println("Stock: " + cantidadStock)
        println("Valor total en inventario: $" + calcularValorTotal())
    }

    fun aumentarPrecio() {
        precio = precio + (precio * 0.06)
        println("Se ha aumentado el precio del producto " + nombre + " en un 6%")
    }


    fun calcularValorTotal(): Double {
        return precio * cantidadStock
    }
}