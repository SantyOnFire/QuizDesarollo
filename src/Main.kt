import java.util.Scanner

var productos = ArrayList<Producto>()
var scanner = Scanner(System.`in`)

fun main() {
    var opcion = 0

    while (opcion != 5) {
        println("\n*** MENÚ DE PRODUCTOS ***")
        println("1. Crear producto")
        println("2. Mostrar productos")
        println("3. Vender producto")
        println("4. Reponer stock")
        println("5. Salir")
        print("Elige una opción del Menu: ")


        opcion = scanner.nextInt()
        scanner.nextLine()

        if (opcion == 1) {
            crearProducto()
        } else if (opcion == 2) {
            mostrarProductos()
        } else if (opcion == 3) {
            venderProducto()
        } else if (opcion == 4) {
            reponerStock()
        } else if (opcion == 5) {
            println("Gracias por usar nuestro Sistema")
        } else {
            println("Opción no válida")
        }
    }
}


fun crearProducto() {
    println("\n-- CREAR PRODUCTO --")

    print("Código del producto: ")
    var codigo = scanner.nextLine()

    print("Nombre del producto: ")
    var nombre = scanner.nextLine()

    print("Precio del producto: ")
    var precio = scanner.nextDouble()

    print("Cantidad en stock: ")
    var stock = scanner.nextInt()
    scanner.nextLine()

    var producto = Producto(codigo, nombre, precio, stock)
    productos.add(producto)

    println("Producto agregado correctamente")
}

fun mostrarProductos() {
    println("\n-- LISTA DE PRODUCTOS --")

    if (productos.size == 0) {
        println("No hay productos registrados")
        return
    }

    for (i in 0 until productos.size) {
        println("Producto " + (i+1) + ":")
        productos[i].mostrarInformacion()
        println("---------------")
    }
}


fun venderProducto() {
    if (productos.size == 0) {
        println("No hay productos registrados")
        return
    }

    println("\n-- VENDER PRODUCTO --")
    mostrarProductos()

    print("Ingrese el número del producto: ")
    var indice = scanner.nextInt() - 1
    scanner.nextLine() // Limpiar buffer

    if (indice >= 0 && indice < productos.size) {
        print("Cantidad a vender: ")
        var cantidad = scanner.nextInt()
        scanner.nextLine()

        productos[indice].vender(cantidad)
    } else {
        println("Número de producto inválido")
    }
}


fun reponerStock() {
    if (productos.size == 0) {
        println("No hay productos registrados")
        return
    }

    println("\n-- REPONER STOCK --")
    mostrarProductos()

    print("Ingrese el número del producto: ")
    var indice = scanner.nextInt() - 1
    scanner.nextLine()

    if (indice >= 0 && indice < productos.size) {
        print("Cantidad a reponer: ")
        var cantidad = scanner.nextInt()
        scanner.nextLine()

        productos[indice].reponerStock(cantidad)
    } else {
        println("Número de producto inválido")
    }
}
