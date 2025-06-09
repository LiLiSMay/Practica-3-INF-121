import pickle
import os

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Empleado(nombre: {self.nombre}, edad: {self.edad}, salario: {self.salario})"

class ArchivoEmpleado:
    def __init__(self, nomA):
        self.nomA = nomA

    def crear_archivo(self):
        if not os.path.exists(self.nomA):
            with open(self.nomA, 'wb') as f:
                pickle.dump([], f)

    def guardar_empleado(self, e):
        empleados = []
        if os.path.exists(self.nomA):
            with open(self.nomA, 'rb') as f:
                empleados = pickle.load(f)
        empleados.append(e)
        with open(self.nomA, 'wb') as f:
            pickle.dump(empleados, f)

    def busca_empleado(self, nombre):
        if os.path.exists(self.nomA):
            with open(self.nomA, 'rb') as f:
                empleados = pickle.load(f)
                for e in empleados:
                    if e.nombre == nombre:
                        return e
        return None

    def mayor_salario(self, sueldo):
        if os.path.exists(self.nomA):
            with open(self.nomA, 'rb') as f:
                empleados = pickle.load(f)
                for e in empleados:
                    if e.salario > sueldo:
                        return e
        return None

archivo = ArchivoEmpleado("empleados.pkl")
archivo.crear_archivo()


archivo.guardar_empleado(Empleado("Ana", 30, 4000))
archivo.guardar_empleado(Empleado("Luis", 28, 3800))
archivo.guardar_empleado(Empleado("María", 35, 4500))


empleado_buscado = archivo.busca_empleado("Luis")
print("Empleado encontrado:", empleado_buscado)


empleado_salario = archivo.mayor_salario(3900)
print("Empleado con salario > 3900:", empleado_salario)
