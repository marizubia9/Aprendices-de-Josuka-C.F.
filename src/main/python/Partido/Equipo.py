#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-
# -*- coding: utf-8 -*-

import json
import jsonpickle
from json import JSONEncoder

class Equipo():
    """"
    Class to handle Airports
    """

    def __init__(self, code: str, nombre: str, puntuacion: int, categoria: str):
        """
        Constructor
        """
        self.__code = code
        self.__nombre = nombre
        self.__puntuacion = puntuacion
        self.__categoria = categoria



    def get_code(self) -> str:
        return self.__code


    def get_nombre(self) -> str:
        return self.__nombre

    def get_puntuacion(self) -> int:
        return self.__puntuacion

    def get_categoria(self) -> str:
        return self.__categoria


    def print (self) -> None:
        print("Printing equipo\n"
              "Code: {} \n"
              "Nombre: {} \n"
              "Puntuacion: {}\n"
              "Categoria: {}\n".format( self.get_code(), self.get_nombre(), self.get_puntuacion(), self.get_categoria()))


if __name__ == '__main__':

    # Create some airports
    a1 = Equipo("E1", "Zumaiako",54,"Alevin")
    a2 = Equipo("E2", "Aurrera KE",32,"Infantil")
    a3 = Equipo("E3", "Hamaikak bat",40,"Cadete")
    a4 = Equipo("E4", "Pulpo",47,"Juvenil")
    a5 = Equipo("E5", "Getariako",39,"Senior")

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




