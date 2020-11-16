#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-
# -*- coding: utf-8 -*-

from src.main.python.Partidos.Interface_Partidos import Interface_Partidos
from src.main.python.Partido.Partido import Partido
from src.main.python.Partido.Equipo import Equipo
from collections import defaultdict
import random
import sys
import json
import jsonpickle
from json import JSONEncoder
from datetime import *

class AprendicesDeJosukaPartidos (Interface_Partidos):
    """"
    Class to handle Airlines queries using Deusto Airlines Service
    """
    def __init__(self):
        """
        Constructor
        """
        self.__equipos = dict( )
        # airport_name -> [ Airport_object ]

        # todo move ???
        self.generate_sample_equipos()

        self.__partidos = dict( )
        # flight_code -> [ Flight_object ]

        # Create some data
        # todo: improve



    """ Override Interface Authentication"""

    def search_partidos(self, **kwparams) -> [Partido]:
        
    
        if kwparams:
            equipo1_name = kwparams.get('equipo1_name')
            equipo2_name = kwparams.get('equipo2_name')
            res_e1 = kwparams.get('res_e1')
            res_e2 = kwparams.get('res_e2')
            date = kwparams.get('date')
            
            if ( equipo1_name is None and
                    equipo2_name is None and
                    res_e1 is None and
                    res_e2 is None and
                    date is None):
                return list(self.__partidos.values())

            elif ( equipo1_name is not None and
                    equipo2_name is not None and
                    res_e1 is not None and
                    res_e2 is not None and
                    date is not None):
                return self.search_flights_by_5(kwparams)

            elif ( equipo1_name is not None and
                   equipo2_name is not None and
                   res_e1 is not None and
                   res_e2 is not None):
                return self.search_flights_by_4(kwparams)

            elif ( equipo1_name is not None and
                   equipo2_name is not None and
                   res_e1 is not None ):
                return self.search_flights_by_3(kwparams)

            elif ( equipo1_name is not None and
                   equipo2_name is not None ):
                return self.search_flights_by_2(kwparams)
            
            else:
                # if we are here OMG!
                return list(self.__partidos.values())    
        else:
            return list(self.__partidos.values())


    def with_time(self, partido, kwparams):
        try:
            parsed_time = datetime.strptime(kwparams['date'], '%Y/%m/%d %H:%M:%S')
        except:
            print("Raised exception - invalid date string")
            return False

        return parsed_time <= partido.get_date() <= parsed_time + timedelta(days=10)

    def search_partidos_by_5(self, kwparams):
        return [partido for partido in self.__partidos.values() if self.with_same_equipos(partido, kwparams) and self.with_res_e1(partido, kwparams) and self.with_res_e2(partido, kwparams) and self.with_time(partido, kwparams)]

    def search_partidos_by_4(self, kwparams):
        return [partido for partido in self.__partidos.values() if self.with_same_equipos(partido, kwparams) and self.with_res_e1(partido, kwparams) and self.with_res_e2(partido, kwparams) ]

    def search_partidos_by_3(self, kwparams):
        return [partido for partido in self.__partidos.values() if self.with_same_equipos(partido, kwparams) and self.with_res_e1(partido, kwparams) ]

    def search_partidos_by_2(self, kwparams):
        return [partido for partido in self.__partidos.values() if self.with_same_equipos(partido, kwparams) ]


    def with_res_e1(self, partido, kwparams):
        return partido.get_resultado_e1() <= kwparams['res_e1']

    def with_res_e2(self, partido, kwparams):
        return partido.get_resultado_e2() <= kwparams['res_e2']


    def with_same_equipos(self, partido, kwparams):
        return (partido.get_equipo1().get_nombre() == kwparams['equipo1_name']) and (partido.get_equipo2().get_nombre() == kwparams['equipo2_name'])



    def toJSON(self, partido_array):
        result = jsonpickle.encode(partido_array, unpicklable=False)
        return result
    

    """Flight related private methods"""
    def partido_exists(self, code):
        if code != None and code.strip() != "" and code in self.__partidos.keys():
            return True
        else:
            return False


    """Airport related private methods"""
    def equipo_exists(self, code):
        if code != None and code.strip() != "" and code in self.__partidos.keys():
            return True
        else:
            return False


    """Sample code generation related"""
    def generate_sample_equipos(self):
        a1 = Equipo("E1", "Zumaiako",54, "Alevin")
        a2 = Equipo("E2", "Aurrera KE",32, "Infantil")
        a3 = Equipo("E3", "Hamaikak bat",40, "Cadete")
        a4 = Equipo("E4", "Pulpo",47, "Juvenil")
        a5 = Equipo("E5", "Getariako", 39, "Senior")
        a6 = Equipo("E6", "Bilbo KE",34,  "Alevin")
        a7 = Equipo("E7", "Itziar KE",39, "Infantil")
        a8 = Equipo("E8", "Mutriku KE",45, "Juvenil")
        a9 = Equipo("E9", "Zarautz KE",43, "Senior")
        a10 = Equipo("E10", "Ondarru KE", 52, "Cadete")
        a11 = Equipo("E11", "Urnieta KE",31, "Cadete")
        a12= Equipo("E12", "Zizur Nagusia KE",36,  "Alevin")
        a13= Equipo("E13", "Eibar KE",42, "Juvenil")
        a14= Equipo("E14", "Donosti KE",48, "Senior")
        a15 = Equipo("E15", "Deba KE", 51, "Infantil")

        self.__equipos[a1.get_nombre] = a1
        self.__equipos[a2.get_nombre] = a2
        self.__equipos[a3.get_nombre] = a3
        self.__equipos[a4.get_nombre] = a4
        self.__equipos[a5.get_nombre] = a5
        self.__equipos[a6.get_nombre] = a6
        self.__equipos[a7.get_nombre] = a7
        self.__equipos[a8.get_nombre] = a8
        self.__equipos[a9.get_nombre] = a9
        self.__equipos[a10.get_nombre] = a10
        self.__equipos[a11.get_nombre] = a11
        self.__equipos[a12.get_nombre] = a12
        self.__equipos[a13.get_nombre] = a13
        self.__equipos[a14.get_nombre] = a14
        self.__equipos[a15.get_nombre] = a15


    def generate_random_partido(self):
        
        a1 , a2 = random.sample( list (self.__equipos.values() ), k = 2)
        if a1.get_categoria() == a2.get_categoria():
            partido = Partido("P" + str(random.randint(1, 9999)),
                        Equipo(a1.get_code(), a1.get_nombre(), a1.get_puntuacion(), a1.get_categoria()),
                        Equipo(a2.get_code(), a2.get_nombre(), a2.get_puntuacion(), a2.get_categoria()),
                        random.randint(0,5),
                        random.randint(0, 5),
                        datetime.now() - timedelta(days=random.randint(0, 40) , hours = random.randint(0, 23), minutes = random.randint(0, 59)))
            self.__partidos[partido.get_code()] = partido
        else:
            self.generate_random_partido()


    """Generic private methods"""
    def debug(self):
        print("Printing content...")

        for entry in self.__partidos.keys():

            print("Entry Key: {}\n"
                  "Entry values: {}".format(entry, self.__partidos[entry]))

            self.__partidos[entry].print()



if __name__ == '__main__':


    # Create DeustoAirlines system
    adj_partidos = AprendicesDeJosukaPartidos()

    # Create sample data
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
    adj_partidos.generate_random_partido()
   

    print("Searching all partidos")
    partidos = adj_partidos.search_partidos()


    print("JSON related tests")
    result_array = adj_partidos.search_partidos()
    type(result_array)
    print()
    print(adj_partidos.toJSON(result_array))

