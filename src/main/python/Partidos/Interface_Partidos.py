#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-

from abc import ABC, abstractmethod
from src.main.python.Partido.Partido import Partido

class Interface_Partidos ( ABC ):
"""
interfaz que establece el método que se podrá implementar para los partidos
"""  
    @abstractmethod
    def search_partidos( self, **kwparams) -> [ Partido ]:
        
        pass






    
