import json
import jsonpickle
from json import JSONEncoder

class Sancion():
    """"
    Class to handle Airports
    """

    def __init__(self, code: str, tipo: str, dni: str, cod_partido: str):
        """
        Constructor
        """
        self.__code = code
        self.__tipo = tipo
        self.__dni = dni
        self.__cod_partido = cod_partido



    def get_code(self) -> str:
        return self.__code


    def get_tipo(self) -> str:
        return self.__tipo

    def get_dni(self) -> str:
        return self.__dni

    def get_cod_partido(self) -> str:
        return self.__cod_partido


    def print (self) -> None:
        print("Printing sancion\n"
              "Code: {} \n"
              "Tipo: {} \n"
              "Dni: {}\n"
              "Cod partido: {}\n".format( self.get_code(), self.get_tipo(), self.get_dni(), self.get_cod_partido()))


if __name__ == '__main__':

    # Create some airports
    a1 = Sancion("S1", "Falta","1231231231","P123")
    a2 = Sancion("S2", "Agresion","1231231231","P123")
    a3 = Sancion("S3", "Insulto","1231231231","P123")
    a4 = Sancion("S4", "Falta","1231231231","P123")
    a5 = Sancion("S5", "Agresion","1231231231","P123")

    # Test Marshalling / Unmarshalling
    json_encoded_1 = jsonpickle.encode(a1, unpicklable=True)
    json_encoded_2 = jsonpickle.encode(a2, unpicklable=True)
    json_encoded_3 = jsonpickle.encode(a3, unpicklable=True)
    json_encoded_4 = jsonpickle.encode(a4, unpicklable=True)
    json_encoded_5 = jsonpickle.encode(a5, unpicklable=True)

    print(json_encoded_1)
    print(json_encoded_2)
    print(json_encoded_3)
    print(json_encoded_4)
    print(json_encoded_5)

    print(json.dumps(json_encoded_1, indent=4))
    json_encoded1 = json.loads(json.dumps(json_encoded_1, indent=4))

    a5 = jsonpickle.decode(json_encoded_1)
    a5.print()




