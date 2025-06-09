import pickle

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"Cliente(id: {self.id}, nombre: {self.nombre}, telefono: {self.telefono})"

class ArchivoCliente:
    def __init__(self, nombre_archivo):
        self.nomA = nombre_archivo

    def crear_archivo(self):
        with open(self.nomA, 'wb') as archivo:
            pickle.dump([], archivo)

    def guarda_cliente(self, cliente):
        clientes = self._leer_clientes()
        clientes.append(cliente)
        self._guardar_lista(clientes)

    def buscar_cliente(self, id_cliente):
        clientes = self._leer_clientes()
        for cli in clientes:
            if cli.id == id_cliente:
                return cli
        return None

    def buscar_celular_cliente(self, telefono):
        clientes = self._leer_clientes()
        for cli in clientes:
            if cli.telefono == telefono:
                return cli
        return None

    def _leer_clientes(self):
        try:
            with open(self.nomA, 'rb') as archivo:
                return pickle.load(archivo)
        except:
            return []

    def _guardar_lista(self, clientes):
        with open(self.nomA, 'wb') as archivo:
            pickle.dump(clientes, archivo)



if __name__ == "__main__":
    archivo = ArchivoCliente("clientes.dat")
    archivo.crear_archivo()

    c1 = Cliente(1, "Maya", 77712345)
    c2 = Cliente(2, "Lucas", 76543210)

    archivo.guarda_cliente(c1)
    archivo.guarda_cliente(c2)

    print("Buscar por ID 2:")
    encontrado = archivo.buscar_cliente(2)
    if encontrado:
        print(encontrado)
    else:
        print("No encontrado")

    print("Buscar por Telefono 77712345:")
    encontrado = archivo.buscar_celular_cliente(77712345)
    if encontrado:
        print(encontrado)
    else:
        print("No encontrado")
