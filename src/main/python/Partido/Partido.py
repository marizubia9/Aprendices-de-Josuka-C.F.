#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-
# -*- coding: utf-8 -*-

from src.main.python.Partido.Equipo import Equipo
import json
import jsonpickle
from json import JSONEncoder
from time import *
from datetime import *

class Partido():
    """"
    Class to handle Flights
    """

    def __init__(self, code: str, equipo_1: Equipo, equipo_2: Equipo, resultado_e1: int, resultado_e2: int,  date : datetime):
        """
        Constructor
        """
        self.__code = code
        self.__equipo_1 = equipo_1
        self.__equipo_2 = equipo_2
        self.__resultado_e1 = resultado_e1
        self.__resultado_e2 = resultado_e2
        self.__date = date

        # Todo arrival and departure date


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


if __name__ == '__main__':

    # Create some Equipo
    a1 = Equipo("E1", "Zumaiako",54, "Alevin")
    a2 = Equipo("E2", "Aurrera KE",32, "Infantil")
    a3 = Equipo("E3", "Hamaikak bat",40, "Cadete")
    a4 = Equipo("E4", "Pulpo",47, "Juvenil")
    a5 = Equipo("E5", "Getariako", 39, "Senior")



    # Create some Partido
    # datetime(year = 2020, month = 6, day = 10, hour = 5, minute = 55, second = 13)
    f1 = Partido("P1", a1, a2, 1, 1, datetime.now())
    f2 = Partido("P2", a1, a3, 0, 1, datetime.now() - timedelta(days=1))
    f3 = Partido("P3", a1, a4, 2, 3, datetime.now() - timedelta(days=2))
    f4 = Partido("P4", a2, a1, 1, 4, datetime.now() - timedelta(days=3))
    f5 = Partido("P5", a2, a3, 1, 2, datetime.now() - timedelta(days=4))
    f6 = Partido("P6", a3, a4, 0, 2, datetime.now() - timedelta(days=5))
    f7 = Partido("P7", a4, a1, 1, 0, datetime.now() - timedelta(days=6))


    # Test all methods
    f1.print()
    f2.print()
    f3.print()
    f4.print()
    f5.print()
    f6.print()
    f7.print()

    # Test Marshalling / Unmarshalling
    json_encoded_1 = jsonpickle.encode(f1, unpicklable=False)
    json_encoded_2 = jsonpickle.encode(f2, unpicklable=False)
    json_encoded_3 = jsonpickle.encode(f3, unpicklable=False)
    json_encoded_4 = jsonpickle.encode(f4, unpicklable=False)
    json_encoded_5 = jsonpickle.encode(f5, unpicklable=False)
    json_encoded_6 = jsonpickle.encode(f6, unpicklable=False)
    json_encoded_7 = jsonpickle.encode(f7, unpicklable=False)

    print(json_encoded_1)
    print(json_encoded_2)
    print(json_encoded_3)
    print(json_encoded_4)
    print(json_encoded_5)
    print(json_encoded_6)
    print(json_encoded_7)

    #print(json.dumps(json_encoded_1, indent=4))
    #json_encoded1 = json.loads(json.dumps(json_encoded_1, indent=4))

    #f5 = jsonpickle.decode(json_encoded_1)
    #f5.print()