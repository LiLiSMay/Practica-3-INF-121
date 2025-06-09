from typing import Generic, TypeVar

T = TypeVar('T')
class Caja(Generic[T]):
    def __init__(self):
        self._contenido: T = None

    def guardar(self, valor: T):
        self._contenido = valor

    def obtener(self) -> T:
        return self._contenido

caja1 = Caja[str]()
caja1.guardar("libros de programacion ")

caja2 = Caja[int]()
caja2.guardar(1263)

print("Contenido de caja1:", caja1.obtener())
print("Contenido de caja2:", caja2.obtener())
