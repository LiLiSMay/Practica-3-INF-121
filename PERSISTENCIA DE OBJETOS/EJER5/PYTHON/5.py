import pickle

class Farmacia:
    def __init__(self, sucursal: int, direccion: str, medicamentos: list):
        self.__sucursal = sucursal
        self.__direccion = direccion
        self.__medicamentos = medicamentos

    def get_sucursal(self):
        return self.__sucursal

    def get_direccion(self):
        return self.__direccion

    def get_medicamentos(self):
        return self.__medicamentos

    def __str__(self):
        return f"Sucursal: {self.__sucursal}, Dirección: {self.__direccion}, Medicamentos: {self.__medicamentos}"


class ArchivoFarmacia:
    def __init__(self, nombre_archivo: str):
        self.__nomA = nombre_archivo

    def crear_archivo(self):
        with open(self.__nomA, "wb") as f:
            pickle.dump([], f)

    def guardar_farmacia(self, farmacia: Farmacia):
        farmacias = self.leer_todas()
        farmacias.append(farmacia)
        with open(self.__nomA, "wb") as f:
            pickle.dump(farmacias, f)

    def leer_todas(self):
        try:
            with open(self.__nomA, "rb") as f:
                return pickle.load(f)
        except FileNotFoundError:
            return []

    def mostrar_todas(self):
        for f in self.leer_todas():
            print(f)

    def medicamentos_por_sucursal(self, sucursal: int):
        for f in self.leer_todas():
            if f.get_sucursal() == sucursal:
                print(f"Medicamentos en sucursal {sucursal}: {f.get_medicamentos()}")
                return
        print("Sucursal no encontrada.")

    def sucursales_con_medicamento(self, nombre: str):
        encontrado = False
        for f in self.leer_todas():
            if nombre in f.get_medicamentos():
                print(f"El medicamento '{nombre}' se encuentra en Sucursal {f.get_sucursal()} - Dirección: {f.get_direccion()}")
                encontrado = True
        if not encontrado:
            print(f"No se encontró '{nombre}' en ninguna sucursal.")



if __name__ == "__main__":
    archivo = ArchivoFarmacia("farmacias.pkl")
    archivo.crear_archivo()

    f1 = Farmacia(1, "Av. Siempre Viva 123", ["Paracetamol", "Golpex", "Ibuprofeno"])
    f2 = Farmacia(2, "Calle Luna 456", ["Jarabe Tos", "Vitamina C", "Golpex"])
    f3 = Farmacia(3, "Plaza Sol 789", ["Aspirina", "Jarabe Tos", "Antigripal"])

    archivo.guardar_farmacia(f1)
    archivo.guardar_farmacia(f2)
    archivo.guardar_farmacia(f3)

    print("\n📦 Todas las farmacias:")
    archivo.mostrar_todas()

    print("\n💊 Medicamentos en la sucursal 3:")
    archivo.medicamentos_por_sucursal(3)

    print("\n📍 Sucursales con medicamento 'Golpex':")
    archivo.sucursales_con_medicamento("Golpex")
