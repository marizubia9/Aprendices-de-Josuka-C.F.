import json
import jsonpickle
from json import JSONEncoder

class Sancion():
"""
clase donde se establecen los atributos de las sanciones
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




