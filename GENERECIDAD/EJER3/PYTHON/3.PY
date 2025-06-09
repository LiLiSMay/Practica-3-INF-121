from typing import Generic, TypeVar, List

T = TypeVar('T')

class Catalogo(Generic[T]):
    def __init__(self):
        self._elementos: List[T] = []

    def agregar(self, item: T):
        self._elementos.append(item)

    def buscar(self, item: T) -> bool:
        return item in self._elementos

    def mostrar(self):
        for item in self._elementos:
            print(item)

class Libro:
    def __init__(self, titulo: str):
        self.titulo = titulo

    def __eq__(self, other):
        return isinstance(other, Libro) and self.titulo == other.titulo

    def __str__(self):
        return f"Libro: {self.titulo}"

class Producto:
    def __init__(self, nombre: str):
        self.nombre = nombre

    def __eq__(self, other):
        return isinstance(other, Producto) and self.nombre == other.nombre

    def __str__(self):
        return f"Producto: {self.nombre}"


catalogo_libros = Catalogo[Libro]()
catalogo_libros.agregar(Libro("El Principito"))
catalogo_libros.agregar(Libro("1984"))
print("Esta '1984'?", catalogo_libros.buscar(Libro("1984")))
catalogo_libros.mostrar()

catalogo_productos = Catalogo[Producto]()
catalogo_productos.agregar(Producto("Celular"))
catalogo_productos.agregar(Producto("Laptop"))
print("Esta 'Tablet'?", catalogo_productos.buscar(Producto("Tablet")))
catalogo_productos.mostrar()
