import json
import jsonpickle
from json import JSONEncoder

class Equipo():
"""
clase donde se establecen los atributos de los equipos que se guardaran con los partidos en la raspberry
"""  
    

    def __init__(self, code: str, nombre: str, puntuacion: int, categoria: str):
        """
        constructor del equipo
        """
        self.__code = code
        self.__nombre = nombre
        self.__puntuacion = puntuacion
        self.__categoria = categoria


        
    def get_code(self) -> str:
        """
        Getter del código del equipo
        """
        return self.__code


    def get_nombre(self) -> str:
        """
        Getter del nombre del equipo
        """
        return self.__nombre

    def get_puntuacion(self) -> int:
        """
        Getter de la puntuación del equipo
        """
        return self.__puntuacion

    def get_categoria(self) -> str:
        """
        Getter de la categoria del equipo
        """
        return self.__categoria


    def print (self) -> None:
        """
        Imprime datos de los equipos
        """
        print("Printing equipo\n"
              "Code: {} \n"
              "Nombre: {} \n"
              "Puntuacion: {}\n"
              "Categoria: {}\n".format( self.get_code(), self.get_nombre(), self.get_puntuacion(), self.get_categoria()))






