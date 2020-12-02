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
   
    def __init__(self):
        """
        Constructor
        """

        self.__partidos = dict( )

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

    def toJSON(self, partido_array):
        result = jsonpickle.encode(partido_array, unpicklable=False)
        return result
    



    """Sample code generation related"""



    def generate_partido(self):

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


        
        p1 = Partido("P1", a1, a12, 2,0, "2020-10-02 17:00:00")
        p2 = Partido("P2", a2, a15, 1,0, "2020-10-06 17:00:00")
        p3 = Partido("P3", a3, a10, 0,2, "2020-11-02 17:00:00")
        p4 = Partido("P4", a4, a13, 2,0, "2020-10-12 17:00:00")
        p5 = Partido("P5", a5, a14, 0,0, "2020-09-17 17:00:00")

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

        p6 = Partido("P6", a6, a12, 1,2, "2020-10-22 17:00:00")
        p7 = Partido("P7", a7, a15, 2,5, "2020-10-30 17:00:00")
        p8 = Partido("P8", a8, a13, 2,2, "2020-09-12 17:00:00")
        p9 = Partido("P9", a3, a11, 1,1, "2020-09-02 17:00:00")
        p10 = Partido("P10", a5, a9, 0,1, "2020-03-25 17:00:00")

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

        p11 = Partido("P11", a1, a12, 2,0, "2020-02-02 17:00:00")
        p12 = Partido("P12", a2, a15, 1,0, "2020-02-06 17:00:00")
        p13 = Partido("P13", a3, a10, 0,2, "2020-03-02 17:00:00")
        p14 = Partido("P14", a4, a13, 2,0, "2020-04-12 17:00:00")
        p15 = Partido("P15", a5, a14, 0,0, "2020-04-17 17:00:00")

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

        p16 = Partido("P16", a6, a12, 1,2, "2020-05-22 17:00:00")
        p17 = Partido("P17", a7, a15, 2,5, "2020-05-30 17:00:00")
        p18 = Partido("P18", a8, a13, 2,2, "2020-01-12 17:00:00")
        p19 = Partido("P19", a3, a11, 1,1, "2020-05-02 17:00:00")
        p20 = Partido("P20", a5, a9, 0,1, "2020-02-25 17:00:00")

        
        self.__partidos[p1.get_code()] = p1
        self.__partidos[p2.get_code()] = p2
        self.__partidos[p3.get_code()] = p3
        self.__partidos[p4.get_code()] = p4
        self.__partidos[p5.get_code()] = p5
        self.__partidos[p6.get_code()] = p6
        self.__partidos[p7.get_code()] = p7
        self.__partidos[p8.get_code()] = p8
        self.__partidos[p9.get_code()] = p9
        self.__partidos[p10.get_code()] = p10
        self.__partidos[p11.get_code()] = p11
        self.__partidos[p12.get_code()] = p12
        self.__partidos[p13.get_code()] = p13
        self.__partidos[p14.get_code()] = p14
        self.__partidos[p15.get_code()] = p15
        self.__partidos[p16.get_code()] = p16
        self.__partidos[p17.get_code()] = p17
        self.__partidos[p18.get_code()] = p18
        self.__partidos[p19.get_code()] = p19
        self.__partidos[p20.get_code()] = p20




