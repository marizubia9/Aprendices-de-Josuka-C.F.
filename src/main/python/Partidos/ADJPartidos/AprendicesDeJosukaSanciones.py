from src.main.python.Partidos.Interface_Sanciones import Interface_Sanciones
from src.main.python.Partido.Sancion import Sancion
from collections import defaultdict
import random
import sys
import json
import jsonpickle
from json import JSONEncoder
from datetime import *

class AprendicesDeJosukaSanciones (Interface_Sanciones):

    def __init__(self):

        self.__sanciones = dict( )


    def search_sanciones(self, **kwparams) -> [Sancion]:
    
        if kwparams:
            code = kwparams.get('code')
            tipo = kwparams.get('tipo')
            dni = kwparams.get('dni')
            cod_partido = kwparams.get('cod_partido')
            
            if ( code is None and
                    tipo is None and
                    dni is None and
                    cod_partido is None ):
                return list(self.__sanciones.values())
            
            else:
                # if we are here OMG!
                return list(self.__sanciones.values())    
        else:
            return list(self.__sanciones.values())


 
    def toJSON(self, sancion_array):
        result = jsonpickle.encode(sancion_array, unpicklable=False)
        return result
    


    def generate_sancion(self):

        s1 = Sancion("S1", "INSULTO", "123123123", "P1")
        s2 = Sancion("S2", "AGRESION","869458659", "P2")
        s3 = Sancion("S3", "FALTA", "243574569", "P3")
        s4 = Sancion("S4", "INSULTO","980584738", "P4")
        s5 = Sancion("S5", "AGRESION","144533490", "P5")
        s6 = Sancion("S6", "FALTA", "248809849", "P6")
        s7 = Sancion("S7", "INSULTO", "789678889","P7")
        s8 = Sancion("S8", "AGRESION", "543345654","P8")
        s9 = Sancion("S9", "FALTA", "768495867", "P9")
        s10 = Sancion("S10","INSULTO", "049053583", "P10")
        s11 = Sancion("S11", "AGRESION","495345345", "P11")
        s12= Sancion("S12", "FALTA", "456456654", "P12")
        s13 = Sancion("S13", "INSULTO", "0980945094", "P13")
        s14 = Sancion("S14", "AGRESION", "897934343", "P14")
        s15= Sancion("S15", "FALTA", "203458345", "P15")
        s16 = Sancion("S16", "INSULTO", "243534554", "P16")
        s17 = Sancion("S17", "AGRESIO", "79898798", "P17")
        s18= Sancion("S18", "FALTA", "231123543", "P18")
        s19 = Sancion("S19", "INSULTO", "879509890", "P19")
        s20 = Sancion("S20", "AGRESION", "123533245", "P20")


        
        self.__sanciones[s1.get_code()] = s1
        self.__sanciones[s2.get_code()] = s2
        self.__sanciones[s3.get_code()] = s3
        self.__sanciones[s4.get_code()] = s4
        self.__sanciones[s5.get_code()] = s5
        self.__sanciones[s6.get_code()] = s6
        self.__sanciones[s7.get_code()] = s7
        self.__sanciones[s8.get_code()] = s8
        self.__sanciones[s9.get_code()] = s9
        self.__sanciones[s10.get_code()] = s10
        self.__sanciones[s11.get_code()] = s11
        self.__sanciones[s12.get_code()] = s12
        self.__sanciones[s13.get_code()] = s13
        self.__sanciones[s14.get_code()] = s14
        self.__sanciones[s15.get_code()] = s15
        self.__sanciones[s16.get_code()] = s16
        self.__sanciones[s17.get_code()] = s17
        self.__sanciones[s18.get_code()] = s18
        self.__sanciones[s19.get_code()] = s19
        self.__sanciones[s20.get_code()] = s20



