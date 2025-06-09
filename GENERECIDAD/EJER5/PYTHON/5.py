from typing import Generic, TypeVar, List

T = TypeVar('T')

class Pila(Generic[T]):
    def __init__(self):
        self._elementos: List[T] = []

    def apilar(self, item: T):
        self._elementos.append(item)

    def desapilar(self) -> T:
        if self._elementos:
            return self._elementos.pop()
        raise IndexError("La pila está vacía")

    def mostrar(self):
        print("Contenido de la pila:", self._elementos)

# enteros
pila_enteros = Pila[int]()
pila_enteros.apilar(1)
pila_enteros.apilar(2)
pila_enteros.apilar(3)
pila_enteros.mostrar()
print("Desapilado:", pila_enteros.desapilar())
pila_enteros.mostrar()

# cadenas
pila_cadenas = Pila[str]()
pila_cadenas.apilar("uno")
pila_cadenas.apilar("dos")
pila_cadenas.mostrar()
print("Desapilado:", pila_cadenas.desapilar())
pila_cadenas.mostrar()
