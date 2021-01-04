#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-
# -*- coding: utf-8 -*-

from src.main.python.Partido.Equipo import Equipo
import json
import jsonpickle
from json import JSONEncoder
from time import *
from datetime import *

class Partido():

    def __init__(self, code: str, equipo_1: Equipo, equipo_2: Equipo, resultado_e1: int, resultado_e2: int,  date : datetime):

        self.__code = code
        self.__equipo_1 = equipo_1
        self.__equipo_2 = equipo_2
        self.__resultado_e1 = resultado_e1
        self.__resultado_e2 = resultado_e2
        self.__date = date


    def get_code(self) -> str:
        return self.__code


    def get_equipo_1(self) -> Equipo:
        return self.__equipo_1


    def get_equipo_2(self) -> Equipo:
        return self.__equipo_2


    def get_resultado_e1(self) -> int:
        return self.__resultado_e1


    def get_resultado_e2(self) -> int:
        return self.__resultado_e2


    def get_date(self) -> datetime:
        return self.__date

    def print (self) -> None:
        print("Printing Partido\n"
              "code: {} \n"
              "equipo 1: {}\n"
              "equipo 2: {} \n"
              "res e1: {} \n"
              "res e2: {} \n"
              "date: {}".format( self.get_code(), self.get_equipo_1().get_nombre(), self.get_equipo_2().get_nombre(), self.get_resultado_e1(), self.get_resultado_e2(), self.get_date() )
              )

