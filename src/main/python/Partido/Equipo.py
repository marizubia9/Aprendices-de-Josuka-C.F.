import json
import jsonpickle
from json import JSONEncoder

class Equipo():

    

    def __init__(self, code: str, nombre: str, puntuacion: int, categoria: str):
     
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






